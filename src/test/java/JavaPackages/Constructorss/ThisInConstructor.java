package JavaPackages.Constructorss;

public class ThisInConstructor {

    String name;
    int age;

    // 1. No-argument constructor
    public ThisInConstructor() {

        // First, call the parameterized constructor
        this("Hari", 30);

        // This executes only AFTER the parameterized constructor finishes
        System.out.println("No-argument constructor");
    }

    // 2. Parameterized constructor
    public ThisInConstructor(String name, int age) {

        this.name = name;
        this.age = age;

        System.out.println("Parameterized constructor");
    }

    public static void main(String[] args) {

        // Object creation starts here
        ThisInConstructor obj1 = new ThisInConstructor();
    }


    //Important interview point
    //
    //this() is used to call another constructor of the same class.
    //
    //And this() must be the first statement inside a constructor.
}