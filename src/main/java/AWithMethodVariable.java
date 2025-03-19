public class AWithMethodVariable {

    // these are called class level variables

    String name = "Prashant";
    static String message;

    public static void main(String[] args) {
        // This is still a clss level variable but we are assigning a value here
        message = "Hello";

        // This is called method level variable
        String otherName = "Ram";

        System.out.println(message + " " + otherName);
    }

}
