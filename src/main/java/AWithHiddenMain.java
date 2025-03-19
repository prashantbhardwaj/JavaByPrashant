public class AWithHiddenMain {

    // because our main method is not publicly accessible, we will get an error while we run this class

    // error: can't find main(String[]) method in class: AWithHiddenMain
    private static void main(String[] args) {
        System.out.println("Hello World");
    }
}
