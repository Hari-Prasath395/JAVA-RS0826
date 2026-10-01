package JavaPackages.Constructorss;

public class Employee {

    //Constructor
    public Employee(){
        System.out.println("Employee object Created");
    }

    //Method
    public void displayEmployee(){
        System.out.println("Employee Details");
    }

    public static void main(String[] args) {

        Employee emp = new Employee();

        /*
        When this executes:

        Employee object created

        The constructor runs automatically.
        */

        emp.displayEmployee();  //The method runs because we explicitly called it.

    }


}
