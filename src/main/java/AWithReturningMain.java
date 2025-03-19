public class AWithReturningMain {

    // this main method is returning an int which is not the correct definition of java's main method, hence you should get an error

    // error: 'main' method is not declared with a return type of 'void'

    public static int main(String[] args) {
        System.out.println("Hello world !!");
        return 1;
    }
}
