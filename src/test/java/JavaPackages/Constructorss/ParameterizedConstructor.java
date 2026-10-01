package JavaPackages.Constructorss;

public class ParameterizedConstructor {

    String name;
    int age;

    public ParameterizedConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayData(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }


    public static void main(String[] args) {

        ParameterizedConstructor pc = new ParameterizedConstructor("John", 18);
        pc.displayData();

    }
    /*
    "A parameterized constructor allows me to initialize an object's instance variables at the time
    of object creation. This helps ensure that the object starts with the required state."

     */
}
