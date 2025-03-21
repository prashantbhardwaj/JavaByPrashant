package day4;

public class Person {
    // member variables (Optional)
    private String name;

    protected String address;

    public String fatherName;

    public static String inDanger;

    public static final String type = "Human";

    // Abstraction - Hiding the complex internal things and just exposing the minimal required things, called Abstraction.
    // In Java. keeping the member variables private and exposign them as Getter and Setter is called Abstraction.

    // Member variable level Access modifier

    // Private Private member variables can only be access within the class where they are mentioned
    // protected - Protected member variables can be accessed from
    //    - The class where the member variable mentioned
    //     - In other classes within the same package

    // methods (Optional)

    // 1 main method (Optional)

    // Constructor (mandatory)
    // Constructors are used to construct an object of that class
    // A constructor which is not accepting any arguments is aways available and created by Java

    // default constrcutor - which doesn't accept any argument. This is available by default even if you do not create this
    public Person(){
        // this represents object of this class
        this.name = "Prashant";
        this.address = "New Delhi";
        this.fatherName = "Daddy Cool";
    }

    public Person(String name, String fatherName){
        this.name = name;
        this.fatherName = fatherName;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }

    // methods may or may not have arguments
    // methods may or may not return a value

    public void printInfo(){
        String result = "Name = " + name + ", address = " + address + ", father's name = " + fatherName;

        System.out.println(result);
    }

    // final key word
    // Access modifier
    // Data types
    // private construstor?
}
