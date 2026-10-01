package JavaPackages.MethodOverloadAndOverride;

public class MethodOverloadingAndOverriding {

    // ============================================================
    // METHOD OVERLOADING
    // ============================================================
    //
    // Method overloading means:
    // Same method name + different parameters.
    //
    // The difference can be:
    // 1. Number of parameters
    // 2. Type of parameters
    // 3. Order of parameters
    //
    // Return type alone cannot be used for method overloading.
    //
    // Method overloading is also called:
    // "Compile-time polymorphism"
    // because Java decides which method to call during compilation.
    // ============================================================

    public void login(){
        System.out.println("Login with default credentials");
    }

    //Same name with one parameter
    public void login(String username){
        System.out.println("Login with username "+ username);

    }

    //same methode name , but two parameters
    public void login(String username, String password){
        System.out.println("Login with username: "+username+" and password :"+password);
    }

    //Different parameter type
    public void login(int userId){
        System.out.println("Login with userID: "+userId);
    }


    // ============================================================
    // METHOD OVERRIDING
    // ============================================================
    //
    // Method overriding happens when:
    //
    // Parent class has a method
    //          +
    // Child class provides its own implementation
    // of the same method.
    //
    // Method overriding is also called:
    // "Runtime polymorphism"
    //
    // The method that gets executed is decided at runtime
    // based on the actual object.
    // ============================================================

    public static void main(String[] args) {
        //creating object of current class

        MethodOverloadingAndOverriding obj = new MethodOverloadingAndOverriding();

        //Calling overloaded methods

        obj.login();
        obj.login("Hari");
        obj.login("John","Doe");
        obj.login(101);
    }
}
