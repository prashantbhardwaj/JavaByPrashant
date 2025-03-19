Day 2: Getting comfortable with the tools and seeing their first program run.
----------------------------------------------------------------------------
1. Setting up a basic text editor or a simple IDE (like VS Code with Java extensions or a very simple online IDE).
2. Writing and running a simple "Hello, World!" program.

> To change the directory in `cmd` type the directory character and colon.
> Example

```
H:
```
## Create a Project
- In any of your directory create a folder called <b><i>workspace</i></b>. I am creating in `H:` directory
- Inside <b><i>workspace</i></b> folder, create another folder <b><i>JavaByPrashant</i></b> 
- Inside <b><i>JavaByPrashant</i></b> folder, create another folder <b><i>src</i></b>
- Inside <b><i>src</i></b> folder, create another folder <b><i>main</i></b>
- Inside <b><i>main</i></b> folder, create another folder <b><i>java</i></b>
- Now, you will have a directory structure like - `H:/workspace/JavaByPrashant/src/main/java`

## Write a program
- Inside java, create a file A.java and write following code in that:

```java
package com.prashant.tutorial;

public class A {
    public static void main(String[] args) {
        System.out.println("Hello World !!");
    }
}

```
## Run your program
- Open cmd and change directory to the place where your java file is
```groovy
H:
cd "H:/workspace/JavaByPrashant/src/main/java"
```

Now first compile your java file <b><i>A.java</i></b>

### Compile your java class
```bash
javac A.java
``` 

If there are no errors, this will create a .class file (e.g., MyProgram.class) in the same directory. This .class file contains the compiled bytecode.
If you have errors, the command line will display those errors, and you will have to correct them in your java file, and compile again.

Key Points:

> javac: This command is used to compile Java source code (.java files).

> java: This command is used to run compiled Java bytecode (.class files).

> Case Sensitivity: Java is case-sensitive, so make sure you type file and class names correctly.

> Directory Navigation: Use the cd command to navigate to the correct directory in the command line.

### Resolving the errors:

```bash 
cd ../../../
java com.prashant.tutorial.A
```

> We need to run the java class using fully qualified name of the class which includes package name and class name.

###  What is java compiler

The Java compiler, typically invoked through the javac command, is a crucial part of the Java Development Kit (JDK). Its primary function is to translate Java source code (written in .java files) into Java bytecode (stored in .class files). Here's a more detailed explanation:

Key Functions:

    Source Code Analysis:
        The Java compiler reads the .java source code file.
        It performs lexical analysis, breaking the code into tokens (keywords, identifiers, operators, etc.).
        It then performs syntax analysis, checking if the code adheres to Java's grammar rules.
        It also performs semantic analysis, ensuring that the code is logically consistent (e.g., type checking).

    Bytecode Generation:
        If the source code passes all the analysis stages without errors, the compiler generates Java bytecode.
        Bytecode is an intermediate language that is platform-independent. This means it can be executed on any system that has a Java Virtual Machine (JVM) installed.

    Error Reporting:
        If the compiler encounters any errors during analysis (syntax errors, type mismatches, etc.), it reports them to the programmer.
        These error messages help the programmer identify and fix the problems in their code.

    Package and Class Handling:
        The compiler respects package declarations in the source code.
        It creates the necessary directory structure to store the .class files according to their package.
        It handles the compilation of multiple classes and their dependencies.

How it Works (Simplified):

    Input: The compiler takes a .java file as input.
    Analysis: It analyzes the code for syntax and semantic correctness.
    Bytecode Output: If the code is valid, it generates a .class file containing bytecode.
    Error Output: If there are errors, it displays error messages.

Key Characteristics:

    Platform Independence (Indirectly): The compiler itself is platform-dependent (you need a javac for your specific operating system), but the bytecode it produces is platform-independent.
    Strict Checking: The Java compiler performs rigorous checks, which helps catch errors early in the development process.
    Compilation Unit: A compilation unit is typically a .java file.

Example:

    If you have a file named MyClass.java, you can compile it using the following command:
        javac MyClass.java
    This will produce a file named MyClass.class in the same directory (or in the appropriate package directory).

In essence, the Java compiler is a translator that converts human-readable Java code into machine-understandable bytecode, enabling Java's "write once, run anywhere" capability.


Question: why javac command was able to compile the file from tutorial directory

You've hit on a crucial point that often confuses beginners! Here's why javac compiles correctly from the tutorial directory, while java fails:

javac's Behavior:

    Source File Location:
        javac primarily focuses on the location of the source file (A.java) you provide as an argument.
        It reads the package declaration within the source file to determine where to place the compiled .class file.
    Directory Structure Creation:
        If the necessary directory structure (e.g., com\prashant\tutorial) doesn't exist, javac will create it for you.
        It correctly places the A.class file in the com\prashant\tutorial subdirectory, relative to the current directory where you ran javac.
    It does not run the code:
        javac only compiles the code, it does not execute the code.

java's Behavior:

    Class Path Dependence:
        The java command requires a correctly set class path to find the .class files.
        When you run java A from the tutorial directory, the Java runtime environment looks for A.class directly in that directory.
        Because the class is in the com.prashant.tutorial package, it's not found in the root of that directory.
    Fully Qualified Name:
        The java command needs the fully qualified class name (e.g., com.prashant.tutorial.A) to locate the class within its package structure.
    It runs the code:
        java command is responsible for executing the already compiled code.

Analogy:

    Imagine javac as a builder who reads a blueprint and builds a house in the specified location. It doesn't care where you're standing when you give it the blueprint.
    Imagine java as someone trying to find that house. They need the full address to find it, not just the name of the house.

In essence:

    javac is concerned with compiling the source code and placing the compiled output in the correct package structure.
    java is concerned with running the compiled code, and needs the correct class path and fully qualified name to find the class.

Now lets create a new folder other inside tutorial and copy paste A.java inside other folder
>> javac com/prashant/tutorial/other/B.java

com\prashant\tutorial\other\B.java:3: error: class A is public, should be declared in a file named A.java
public class A {
^
Note: File name should match the public class name

H:\workspace\JavaByPrashant\src\main\java>java com.prashant.tutorial.B
Error: Could not find or load main class com.prashant.tutorial.B
Caused by: java.lang.ClassNotFoundException: com.prashant.tutorial.B

H:\workspace\JavaByPrashant\src\main\java>java com.prashant.tutorial.other.B
Error: Could not find or load main class com.prashant.tutorial.other.B
Caused by: java.lang.NoClassDefFoundError: com/prashant/tutorial/B (wrong name: com/prashant/tutorial/other/B)