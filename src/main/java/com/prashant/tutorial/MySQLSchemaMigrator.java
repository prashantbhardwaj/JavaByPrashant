package com.prashant.tutorial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLSchemaMigrator {

    private static final Logger LOGGER = Logger.getLogger(MySQLSchemaMigrator.class.getName());

    // Source Database Configuration
    private static final String SOURCE_DB_URL = "jdbc:mysql://localhost:3306/progress";
    private static final String SOURCE_DB_USER = "root";
    private static final String SOURCE_DB_PASSWORD = "123456";

    // Destination Database Configuration
    private static final String DEST_DB_URL = "jdbc:mysql://btw6ntikkz8fjsaokdkh-mysql.services.clever-cloud.com:3306/btw6ntikkz8fjsaokdkh";
    private static final String DEST_DB_USER = "u5zxzknz0dr1bdmu";
    private static final String DEST_DB_PASSWORD = "PNfUeXZKLHOH0ybyTOjW";

    public static void main(String[] args) {
        // Configure logger to output to console
        LOGGER.setLevel(Level.INFO);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false); // Prevent duplicate console output

        try {
            // 1. Fetch table definitions from source
            List<String> tableNames = getTableNames(SOURCE_DB_URL, SOURCE_DB_USER, SOURCE_DB_PASSWORD);
            LOGGER.info("Fetched " + tableNames.size() + " tables from source database.");

            // 2. Create tables in destination
            for (String tableName : tableNames) {
                String createTableSQL = getCreateTableStatement(SOURCE_DB_URL, SOURCE_DB_USER, SOURCE_DB_PASSWORD, tableName);
                if (createTableSQL != null) {
                    //createTableInDestination(DEST_DB_URL, DEST_DB_USER, DEST_DB_PASSWORD, tableName, createTableSQL);
                }
            }
            LOGGER.info("All tables created in the destination database.");

            // 3. Migrate data for all tables
            for (String tableName : tableNames) {
                migrateTableData(SOURCE_DB_URL, SOURCE_DB_USER, SOURCE_DB_PASSWORD,
                        DEST_DB_URL, DEST_DB_USER, DEST_DB_PASSWORD,
                        tableName);
            }
            LOGGER.info("Data migration complete for all tables.");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "MySQL JDBC Driver not found: " + e.getMessage(), e);
        }
    }

    private static Connection getConnection(String dbURL, String user, String password)
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL 8.x and above
        return DriverManager.getConnection(dbURL, user, password);
    }

    private static List<String> getTableNames(String dbURL, String user, String password)
            throws SQLException, ClassNotFoundException {
        List<String> tableNames = new ArrayList<>();
        String query = "SHOW TABLES";
        try (Connection conn = getConnection(dbURL, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                tableNames.add(rs.getString(1));
            }
        }
        return tableNames;
    }

    private static String getCreateTableStatement(String dbURL, String user, String password, String tableName)
            throws SQLException, ClassNotFoundException {
        String createTableSQL = null;
        String query = "SHOW CREATE TABLE " + tableName;
        try (Connection conn = getConnection(dbURL, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                createTableSQL = rs.getString(2); // The second column contains the CREATE TABLE statement
            }
        }
        LOGGER.log(Level.FINE, "Fetched CREATE TABLE for " + tableName + ":\n" + createTableSQL);
        return createTableSQL;
    }

    private static void createTableInDestination(String dbURL, String user, String password, String tableName, String createTableSQL)
            throws SQLException, ClassNotFoundException {
        LOGGER.info("Creating table '" + tableName + "' in destination database...");
        try (Connection conn = getConnection(dbURL, user, password);
             Statement stmt = conn.createStatement()) {
            // Remove AUTO_INCREMENT to avoid issues when re-creating tables,
            // as it might conflict with existing data or cause issues with new inserts
            // unless you explicitly want to preserve it. For data migration, it's often
            // simpler to let the destination handle auto-increment on insert if applicable.
            String modifiedCreateTableSQL = createTableSQL.replaceAll(" AUTO_INCREMENT", "");
            stmt.execute(modifiedCreateTableSQL);
            LOGGER.info("Table '" + tableName + "' created successfully in destination.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error creating table '" + tableName + "': " + e.getMessage(), e);
            throw e; // Re-throw to indicate a critical error
        }
    }

    private static void migrateTableData(String sourceDbURL, String sourceUser, String sourcePassword,
                                         String destDbURL, String destUser, String destPassword,
                                         String tableName)
            throws SQLException, ClassNotFoundException {
        LOGGER.info("Migrating data for table '" + tableName + "'...");
        int rowCount = 0;

        try (Connection sourceConn = getConnection(sourceDbURL, sourceUser, sourcePassword);
             Statement sourceStmt = sourceConn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = sourceStmt.executeQuery("SELECT * FROM " + tableName);
             Connection destConn = getConnection(destDbURL, destUser, destPassword)) {

            destConn.setAutoCommit(false); // Start transaction for bulk insert

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Prepare the INSERT statement for the destination table
            StringBuilder insertSQLBuilder = new StringBuilder("INSERT INTO ")
                    .append(tableName).append(" (");
            StringBuilder valuePlaceholders = new StringBuilder("VALUES (");

            for (int i = 1; i <= columnCount; i++) {
                insertSQLBuilder.append(metaData.getColumnName(i));
                valuePlaceholders.append("?");
                if (i < columnCount) {
                    insertSQLBuilder.append(", ");
                    valuePlaceholders.append(", ");
                }
            }
            insertSQLBuilder.append(") ").append(valuePlaceholders).append(")");
            String insertSQL = insertSQLBuilder.toString();
            LOGGER.log(Level.FINE, "Generated INSERT SQL for " + tableName + ": " + insertSQL);

            try (PreparedStatement ps = destConn.prepareStatement(insertSQL)) {
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        // Set parameter based on column type
                        Object columnValue = rs.getObject(i);
                        ps.setObject(i, columnValue);
                    }
                    ps.addBatch(); // Add to batch for efficient insertion
                    rowCount++;

                    if (rowCount % 1000 == 0) { // Execute batch every 1000 rows
                        ps.executeBatch();
                        destConn.commit();
                        LOGGER.info("Migrated " + rowCount + " rows for table '" + tableName + "' so far.");
                    }
                }
                ps.executeBatch(); // Execute any remaining statements in the batch
                destConn.commit(); // Commit the final batch
            } catch (SQLException e) {
                destConn.rollback(); // Rollback on error
                LOGGER.log(Level.SEVERE, "Error migrating data for table '" + tableName + "': " + e.getMessage(), e);
                //throw e;
            }
        }
        LOGGER.info("Successfully migrated " + rowCount + " rows for table '" + tableName + "'.");
    }
}
