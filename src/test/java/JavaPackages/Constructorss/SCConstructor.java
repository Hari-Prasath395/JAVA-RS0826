package JavaPackages.Constructorss;

public class SCConstructor extends SPConstructor{

    public SCConstructor() {
        super();//super() is used to call the constructor of the parent class.
        System.out.println("Child Constructor");
    }

    public static void main(String[] args) {
        SCConstructor obj1 = new SCConstructor();

        //Because when creating a child object, the parent portion of the object must be initialized first.
        /*So the general order is:

        Parent constructor
        ↓
        Child constructor
        */
    }
    /*
    "super() is used to invoke the parent class constructor. If we don't explicitly write super(),
    Java implicitly inserts a call to the no-argument constructor of the parent class, provided
    that such a constructor is accessible."
     */
}
