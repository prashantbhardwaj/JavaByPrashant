public class AWithClassVariable {

    // these are called class level variables

    String name = "Prashant";
    static String message;

    public static void main(String[] args) {
        // This is still a clss level variable but we are assigning a value here
        message = "Hello";

        // This is called method level variable, this can't be accessed out side of this method
        String otherName = "Ram";

        System.out.println(message + " " + otherName);

        // static method which is written inside the same class can be called by the name of method
        System.out.println(sum(2, 5));

        // static method which is written inside the same class or in any other calss,
        // can be called by the ClassName.methodName
        System.out.println(AWithClassVariable.sum(12, 15));

        System.out.println(StaticMethodHolder.sum(22, 15));

        AWithClassVariable myObject = new AWithClassVariable();

        System.out.println(myObject.multiply(33, 22));


    }

    private static int sum(int value1, int value2){
        return value1 + value2;
    }

    private int multiply(int value1, int value2){
        return value1 * value2;
    }

}
