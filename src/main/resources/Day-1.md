Day 1: Installing Java.
----------------------------------------------------------------------------
1. What is Java? (Brief history and use cases)
2. Why learn Java?
3. Introduction to the Java Development Kit (JDK) and Java Runtime Environment (JRE).
4. Installing the JDK (walkthrough).


Examples: Calculator
Input - Pressing
Output - Results on the screen

## Programming language
> Using which, you can write your instructions in plain English and your computer will interpret those instructions and will execute in sequence and will give you the intended results.

### 1. What is Java?
Java is a programming language, like a set of instructions you give to a computer to make it do things.
Java is used to build a wide variety of applications: websites, mobile apps (Android), desktop software, and more

> Java is platform-independent ("write once, run anywhere"). It means you can write a Java program on one computer and run it on another, even if they have different operating systems.

### 2. Why learn Java?
- its popular and widly used in the industry.
- Mention job opportunities related to Java development.
- Point out that learning Java provides a strong foundation for learning other programming languages.
- Say that android apps are made using java.

### 3. Introduction to the Java Development Kit (JDK) and Java Runtime Environment (JRE).
> JDK (Java Development Kit) is needed to write and compile Java programs

> JRE (Java Runtime Environment) is needed to run Java programs.

Think of the JDK as the tools you need to build a house, and the JRE as the house itself.

### 4. Installing the JDK (walkthrough).
1. Download Java:
- Go to this website - https://www.oracle.com/uk/java/technologies/downloads/
- Download Java version 23, make sure you download the JDK and not JRE
- Extract the JDK folder and copy & paste that folder inside folder - `C:\Program Files\Java`

  Setting the Java PATH environment variable in Windows allows you to run Java commands (like java and javac) from any directory in the command prompt or PowerShell. Here's how to do it:

2. Locate Your Java Installation Directory & paste extracted Java JDK there:

   The most common location for Java installations is:
   C:\Program Files\Java\jdk-<version> (for JDK installations)
   C:\Program Files\Java\jre-<version> (for JRE installations, though JDK is recommended).
   Replace <version> with the actual version number of your Java installation (e.g., jdk-17.0.8).
   Specifically, you need the bin subdirectory within this folder. For example:
   C:\Program Files\Java\jdk-17.0.8\bin

3. Open System Properties:

   Windows 10/11:
   Search for "environment variables" in the Windows search bar.
   Select "Edit the system environment variables."
   This will open the "System Properties" window.

4. Edit Environment Variables:

   In the "System Properties" window, click the "Environment Variables..." button.
   You'll see two sections: "User variables" and "System variables."
   System variables are generally preferred, as they apply to all users on the computer. However, if you do not have administrative priviledges, you may need to use User variables.

5. Edit the Path Variable:

   In the "System variables" (or "User variables") section, find the variable named Path and select it.
   Click the "Edit..." button.
   A new window will appear.
   Windows 10/11:
   Click "New" to add a new entry.
   Paste the path to your Java bin directory (e.g., C:\Program Files\Java\jdk-17.0.8\bin).
   Click "OK" on each open window to save your changes.
   Older Windows Versions:
   The Path variable will be a single line of text.
   Add a semicolon (;) to the end of the existing value.
   Then, paste the path to your Java bin directory.
   Click "OK" on each open window to save your changes.

6. Verify the Installation:

   Open a new command prompt or PowerShell window (important: existing windows won't reflect the changes).
   Type java -version and press Enter.
   If Java is correctly installed and the PATH variable is set correctly, you should see the Java version information.
   Type javac -version and press enter. If the path is correct, the compiler version information will display.

### Troubleshooting:

    "java" is not recognized:
        Double-check that you entered the correct path to the bin directory.
        Make sure you opened a new command prompt or PowerShell window.
        Restart your computer.
    Multiple Java Versions:
        If you have multiple Java installations, the PATH variable will determine which version is used.
        Ensure the desired version's bin directory is listed first in the Path variable.
    Administrative Privileges:
        You may need administrative privileges to edit the system environment variables.
