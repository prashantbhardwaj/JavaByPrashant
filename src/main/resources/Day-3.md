# Day 3: Understanding how to store and manipulate basic data.

* Understanding the structure of a Java program (class, main method).
* Variables and data types (int, double, String, boolean).
* Declaring and initializing variables.
* Basic output using System.out.println().

## Understanding the structure of a Java program (class, main method).

Here's the basic structure of a Java class, explained step-by-step:

### 1. Package Declaration (Optional):

- This is the first line in a Java file (if present).
- It specifies the package to which the class belongs.
- Packages are used to organize classes into logical groups.
- Example: package com.example.myapp;

### 2. Import Statements (Optional):

- These statements are used to bring in other classes or packages that your class needs to use.
- They tell the compiler where to find those external classes.
- Example: import java.util.ArrayList;

### 3. Class Declaration:

- This is where you define the class itself.
- It starts with the class keyword, followed by the class name.
- The class name should start with an uppercase letter.
- Example: public class MyClass { ... }
- The public keyword is an access modifier, that controls where the class can be accessed from.

### 4. Class Body:

- This is enclosed in curly braces {} and contains the class's members (variables and methods).

### 5. Variables (Fields/Attributes):

- These are used to store data associated with the class. Variable is a data holder. Just like in your math class you do x = 3 & y = 5
- They are also known as fields or attributes.
- They have a data type and a name.
- Example: public int myNumber; or private String myName;
- The public and private keywords are access modifiers.

### 6. Constructors (Optional):

- These are special methods used to initialize objects of the class.
- They have the same name as the class.
- Example: public MyClass() { ... } or public MyClass(int number) { ... }

### 7. Methods (Functions):

- These define the behavior of the class.
- They contain blocks of code that perform specific tasks.
- They have a return type, a name, and a list of parameters (optional).
- Example: public void myMethod() { ... } or public int addNumbers(int a, int b) { ... }
- The public keyword is an access modifier.
- The void keyword means that the method does not return a value.
- The int keyword means the method returns an integer.

### 8. Main Method (Optional, but required for executable classes):

- This is a special method that serves as the entry point for a Java application.
- It has a specific signature: public static void main(String[] args) { ... }
- When you run a Java program, the JVM starts executing the code inside the main method.

### Example Structure:


```java
package com.example.myapp;

import java.util.ArrayList;

public class MyClass {

    // Variables (Fields)
    public int myNumber;
    private String myName;

    // Constructor
    public MyClass(String name) {
        this.myName = name;
        this.myNumber = 0;
    }

    // Methods
    public void setNumber(int number) {
        this.myNumber = number;
    }

    public String getName() {
        return this.myName;
    }

    // Main method (if this is an executable class)
    public static void main(String[] args) {
        MyClass myObject = new MyClass("Example");
        myObject.setNumber(10);
        System.out.println("Name: " + myObject.getName());
        System.out.println("Number: " + myObject.myNumber);

    }
}
```
> ### Key takeaways:
>> * A class is a blueprint for creating objects.
>> * It contains variables (data) and methods (behavior).
>> * The main method is the entry point for executable classes.
>> *  Access modifiers control the visibility of class members.

## Variables and Data Types (int, double, String, boolean)

Objective: To understand what variables are, how to declare them, and the basic data types used to store different kinds of information in Java.

### 1. What are Variables? (5 Minutes)

* Analogy: Think of a variable as a labeled box in your computer's memory.
* The label is the variable's name (e.g., age, name, isReady).
* The box holds a value (e.g., 25, "John", true).
* Purpose: Variables allow us to store and manipulate data in our programs.
* Dynamic vs. Static: Java is a statically typed language, which means you must declare the type of data a variable will hold before you use it.

### 2. Declaring Variables (5 Minutes)

* Syntax: data_type variable_name;
* data_type: Specifies the type of data the variable will hold (e.g., int, double, String, boolean).
* variable_name: The name you give to the variable (should be descriptive).
>   Examples:
>>   int age; <br>
>>   double price; <br>
>>   String name; <br>
>>   boolean isReady; <br>

### 3. Initializing Variables (5 Minutes)

* Assigning a value: After declaring a variable, you can assign a value to it using the assignment operator =.
* Syntax: variable_name = value;
>   Examples:
>>   age = 25;
>>   price = 19.99;
>>   name = "Alice";
>>   isReady = true;
*   Declaration and initialization in one line:
   int age = 25;

### 4. Basic Data Types (20 Minutes)

   ```groovy
   int (Integers):
   Used to store whole numbers (e.g., -10, 0, 100).
   Example: int numberOfStudents = 30;
   ```

   ```
   double (Floating-Point Numbers):
   Used to store decimal numbers (e.g., 3.14, -2.5, 19.99).
   Example: double temperature = 25.5;
   ```

   ```
   String (Text):
   Used to store sequences of characters (text).
   Enclosed in double quotes.
   Example: String message = "Hello, Java!";
   ```


   ```
   boolean (True/False):
   Used to store logical values (either true or false).
   Example: boolean isFinished = false;
   ```

### 5. Examples and Practice (10 Minutes)

   Simple Program:
   

   ```java
   public class VariablesExample {
    public static void main(String[] args) {
        int age = 30;
        double price = 49.95;
        String name = "Bob";
        boolean isValid = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Valid: " + isValid);
    }
   }
   ```

   Exercises:
   * Ask students to declare and initialize variables of different data types.
   * Have them print the values of the variables to the console.
   * Simple arithmetic examples using int and double.

### Key Points to Emphasize:

    Naming Conventions: Variable names should be descriptive and follow the camelCase convention (e.g., numberOfStudents).
    Data Type Matching: You can only assign values of the correct data type to a variable.
    Printing to Console: Use System.out.println() to display variable values.
    Hands-on Practice: Encourage students to type the code and experiment.
    Explain the use of the + operator: Explain how the + operator is used to concatenate strings.
    Explain the use of semi colons: Explain that semi colons are used to end java statements.

## Basic Output using System.out.println()

Objective: To understand how to display information to the console using System.out.println().

### 1. What is Output? (5 Minutes)

Concept:
   Output is how a program communicates with the user.
   It's how the program displays results, messages, or other information.
   
Console:
   The console is a text-based interface (like the command prompt or terminal) where programs can display output.

### 2. Introduction to System.out.println() (10 Minutes)

Explanation:
   System.out.println() is a built-in Java method used to print text or values to the console.
   System.out represents the standard output stream (usually the console).
   println stands for "print line," meaning it prints the specified content and then moves the cursor to the next line.
   
Syntax:
   System.out.println(content);
   
content: The text or value you want to print.

### 3. Printing Text (Strings) (10 Minutes)

Example:
  

```java
   public class PrintExample {
   public static void main(String[] args) {
   System.out.println("Hello, World!");
   System.out.println("This is a Java program.");
   }
   }
   ```

Explanation:
   The text you want to print must be enclosed in double quotes (").
   Each System.out.println() call prints the text on a new line.

### 4. Printing Variables (10 Minutes)

Example:


   ```java
   public class PrintVariables {
   public static void main(String[] args) {
   int age = 30;
   String name = "Alice";
   double price = 19.99;

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Price: " + price);
        }
   }
   ```

Explanation:
   You can print the values of variables by placing them inside the System.out.println() parentheses.
   The + operator is used to concatenate (join) strings and variable values.
   Java automatically converts non-string values (like numbers) to strings when used with the + operator in this way.

### 5. Printing Multiple Items on the Same Line (System.out.print()) (5 Minutes)

Explanation:
   System.out.print() is similar to System.out.println(), but it doesn't move the cursor to the next line after printing.

Example:
```Java

   public class PrintSameLine {
   public static void main(String[] args) {
   System.out.print("Hello, ");
   System.out.print("Java!");
   System.out.println(" Welcome!");
   }
   }
   ```

>   Output: Hello, Java! Welcome!

### 6. Practice and Examples (5 Minutes)

Simple Exercises:
* Ask students to write programs that print different messages to the console.
* Have them declare variables and print their values.
* Use both System.out.println() and System.out.print() to demonstrate the difference.
   
Debugging:
* Show how System.out.println() can be used to debug programs by printing the values of variables at different points in the code.
   
Explain escape sequences:
* Briefly explain escape sequences such as \n, \t, and \.