package JavaPackages.TypeCasting;
class  Parent{

    String name = "Java";

    void m1(){
        System.out.println("this is m1 from parent class");
    }

}

class Child extends Parent{

    int id = 100;

    void m2(){
        System.out.println("this m2 from child class");
    }


}


public class TypeCastingObjects {

    public static void main(String[] args) {

        //Approach 1
        /*
        Child c = new Child();
        System.out.println(c.name);// parent
        c.m1(); // parent
        System.out.println(c.id); // child
        c.m2(); // child

         */

        /*
        Parent p = new Child(); //upcasting
        System.out.println(p.name); //parent
        p.m1(); // parent
        System.out.println(p.id); // Not able to access
        p.m2(); // Not able to access

         */
        /*
        //Downcasting
        Parent p = new Parent();
        Child c = (Child) p;
        System.out.println(c.name);
        c.m1();
        System.out.println(c.id);
        c.m2();

        //However this will result in Exception in thread "main" java.lang.ClassCastException: class JavaPackages.TypeCasting.Parent cannot be cast to class JavaPackages.TypeCasting.Child (JavaPackages.TypeCasting.Parent and JavaPackages.TypeCasting.Child are in unnamed module of loader 'app')
        */


    }
}
