package JavaPackages.Constructorss;

public class ImportantIntPoint {

    /*If you create any constructor yourself,
    Java will not automatically provide the compiler-generated default constructor.

     */

    public ImportantIntPoint() {
        System.out.println("No Argument Constructor");
    }

    public ImportantIntPoint(String name) {
        System.out.println("Name :" +name);
    }



    public static void main(String[] args) {
        // This will NOT compile
        ImportantIntPoint ip = new ImportantIntPoint();
    }

    /*
    Why?

    Because you already defined a constructor with a parameter.


    If you want both, you need to define both:

    */



}
