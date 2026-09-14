package TestNGDemo.test;

import org.testng.annotations.Test;

public class day5 {

    @Test
    public void login() {
        System.out.println("Enter username and password");
        System.out.println("Click Login");
    }

    @Test(dependsOnMethods = "login")
    public void addProduct() {
        System.out.println("Add product");
    }

    @Test(dependsOnMethods = "addProduct")
    public void checkout() {
        System.out.println("Checkout");
    }


}
