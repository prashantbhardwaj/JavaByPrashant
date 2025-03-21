package day4;

public class PersonHelper {

    public static void main(String[] args) {
        // static methods can only use other static methods or static member variable without creating Objects.

        String type = Person.type;

        // An Object of a class can be created using "new" keyword

        Person defaultObject = new Person();
        String address = defaultObject.address;
        String name = defaultObject.getName();

        defaultObject.printInfo();

        defaultObject.setAddress("United Kingdom");

        defaultObject.printInfo();


        Person anotherPerson = new Person("Anuj", "Jatin");
        anotherPerson.printInfo();

        Person oneMorePerson = new Person("Kavita", "Dinesh");
        oneMorePerson.setAddress("Mumbai");
        oneMorePerson.printInfo();
    }
}
