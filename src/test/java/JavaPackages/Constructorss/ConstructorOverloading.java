package JavaPackages.Constructorss;

public class ConstructorOverloading {

    String name;
    int age;
    String department;

    //constructor 1
    public ConstructorOverloading() {
        System.out.println("No argument Constructor");
    }

    //constructor 2
    public ConstructorOverloading(String name) {
        this.name = name;
    }

    //constructor 3
    public ConstructorOverloading(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Constructor 4
    public ConstructorOverloading(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public static void main(String[] args) {

        ConstructorOverloading obj = new ConstructorOverloading();
        ConstructorOverloading obj1 = new ConstructorOverloading("Hari");
        ConstructorOverloading obj2 = new ConstructorOverloading("Ganesh",23);
        ConstructorOverloading obj3 = new ConstructorOverloading("Tom",23,"mech");

        /*
        "Constructor overloading means having multiple constructors in the same class with different parameter lists.
        It allows objects to be initialized in different ways."
         */
    }


}
