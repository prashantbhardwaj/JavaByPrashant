# Day 4: Access modifiers

* Class level modifiers
* Member variable level modifiers
* Method level access modifiers

Access modifiers in Java control the visibility and accessibility of classes, variables, and methods. They ensure proper encapsulation and help in designing robust and maintainable code. This document explains class-level, variable-level, and method-level access modifiers, along with the use of static and final keywords.

## 1. Class-Level Access Modifiers

Class-level access modifiers determine whether a class can be accessed from other classes or packages. There are two access modifiers for classes:

### a. public

    A public class is accessible from any other class.

    There can be only one public class in a Java file, and the file name must match the public class name.

```java
// File: MyClass.java
public class MyClass {
// Class content
}
```

### b. Default (Package-Private)

    If no access modifier is specified, the class has default (package-private) access.

    It is accessible only within the same package.

```java
// File: MyClass.java
class MyClass {
// Class content
}
```

## 2. Variable-Level Access Modifiers

Variable-level access modifiers control the visibility of member variables (fields) in a class. The four access modifiers are:

### a. public

    The variable is accessible from any other class.

```java
public class MyClass {
    public int myPublicVar = 10;
}
```

### b. private

    The variable is accessible only within the class it is declared.

```java
public class MyClass {
    private int myPrivateVar = 20;
}
```

### c. protected

    The variable is accessible within the same package and by subclasses (even in different packages).

```java
public class MyClass {
protected int myProtectedVar = 30;
}
```

### d. Default (Package-Private)

    The variable is accessible only within the same package.

```java
public class MyClass {
    int myDefaultVar = 40;
}
```

## 3. Method-Level Access Modifiers

Method-level access modifiers control the visibility of methods in a class. The four access modifiers are:

### a. public

    The method is accessible from any other class.

```java
public class MyClass {
    public void myPublicMethod() {
        System.out.println("Public Method");
    }
}
```

### b. private

    The method is accessible only within the class it is declared.

```java
public class MyClass {
    private void myPrivateMethod() {
        System.out.println("Private Method");
    }
}
```

### c. protected

    The method is accessible within the same package and by subclasses (even in different packages).

```java
public class MyClass {
    protected void myProtectedMethod() {
        System.out.println("Protected Method");
    }
}
```

### d. Default (Package-Private)

    The method is accessible only within the same package.

```java
public class MyClass {
    void myDefaultMethod() {
        System.out.println("Default Method");
    }
}
```

## 4. static Keyword

The static keyword is used to define class-level variables and methods. These belong to the class rather than any specific instance of the class.

### a. Static Variables

    Shared across all instances of the class.

    Accessed using the class name.

```java
public class MyClass {
    public static int myStaticVar = 50;

    public static void main(String[] args) {
        System.out.println(MyClass.myStaticVar); // Access using class name
    }
}
```

### b. Static Methods

    Can be called without creating an instance of the class.

    Cannot access non-static members directly.

```java
public class MyClass {
    
    public static void myStaticMethod() {
        System.out.println("Static Method");
    }

    public static void main(String[] args) {
        MyClass.myStaticMethod(); // Call without creating an object
    }
}
```

## 5. final Keyword

The final keyword is used to restrict modification of variables, methods, and classes.
a. Final Variables

    Cannot be reassigned after initialization.

    Often used for constants.

```java
public class MyClass {
    public final int MY_CONSTANT = 100;

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        // obj.MY_CONSTANT = 200; // Error: Cannot reassign final variable
    }
}
```

### b. Final Methods

    Cannot be overridden by subclasses.

```java
public class MyClass {
    public final void myFinalMethod() {
        System.out.println("Final Method");
    }
}

class SubClass extends MyClass {
    // @Override // Error: Cannot override final method
    // public void myFinalMethod() { }
}
```

### c. Final Classes

    Cannot be extended (inherited).

```java
public final class MyFinalClass {
    // Class content
}

// class SubClass extends MyFinalClass { } // Error: Cannot extend final class
```

## Summary

| Access Modifier | Class | Variable | Method |
|-----------------|-------|----------|--------|
| `public`        | Yes   | Yes      | Yes    |
| `private`       | No    | Yes      | Yes    |
| `protected`     | No    | Yes      | Yes    |
| Default         | Yes   | Yes      | Yes    |

## Key Points:

- Use `public` for maximum accessibility.
- Use `private` for encapsulation.
- Use `protected` for subclass access.
- Use `static` for class-level members.
- Use `final` to prevent modification or inheritance.

By understanding and applying these concepts, you can write well-structured and secure Java code.