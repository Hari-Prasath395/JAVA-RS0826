package JavaPackages.Constructorss;

public class ConstructorDemo {

    /*
     * ============================================================
     * WHAT IS A CONSTRUCTOR?
     * ============================================================
     *
     * A constructor is a special member of a class that is used
     * to initialize an object when the object is created.
     *
     * Important characteristics of a constructor:
     *
     * 1. Constructor name must be the same as the class name.
     *
     * 2. A constructor does NOT have a return type.
     *
     * 3. It is automatically invoked when we create an object
     *    using the 'new' keyword.
     *
     * 4. Constructors are mainly used to initialize object data.
     *
     * 5. A constructor can be overloaded.
     *
     * 6. A constructor cannot be inherited.
     *
     * 7. A constructor can have access modifiers such as
     *    public, protected, private, or default.
     */


    // ============================================================
    // 1. NO-ARGUMENT CONSTRUCTOR
    // ============================================================

    /*
     * This constructor does not accept any arguments.
     *
     * It is called a NO-ARGUMENT CONSTRUCTOR.
     *
     * Important:
     * A no-argument constructor is not necessarily the same as
     * the compiler-generated default constructor.
     */

    public ConstructorDemo() {

        System.out.println("I am the no-argument constructor");
    }


    // ============================================================
    // METHOD
    // ============================================================

    public void getData() {

        System.out.println("I am a method");
    }


    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        /*
         * When this statement executes:
         *
         *     ConstructorDemo cd = new ConstructorDemo();
         *
         * Java creates an object of ConstructorDemo.
         *
         * During object creation, the constructor is automatically
         * called.
         */

        ConstructorDemo cd = new ConstructorDemo();

        /*
         * Output:
         *
         * I am the no-argument constructor
         *
         * Notice that we did not explicitly call the constructor.
         *
         * Java automatically invokes it when the object is created.
         */


        // Calling the method separately
        cd.getData();

        /*
         * Output:
         *
         * I am a method
         *
         * A method must be explicitly called, whereas a constructor
         * is automatically invoked during object creation.
         */
    }

    /*

    | Constructor                                 | Method                       |
            | ------------------------------------------- | ---------------------------- |
            | Used to initialize an object                | Used to perform an operation |
            | Name must match class name                  | Can have any valid name      |
            | Cannot have a return type                   | Can have a return type       |
            | Called automatically during object creation | Usually called explicitly    |
            | Cannot be inherited                         | Methods can be inherited     |
            | Can be overloaded                           | Can be overloaded            |
            | Cannot be overridden                        | Can be overridden            |


     */

}