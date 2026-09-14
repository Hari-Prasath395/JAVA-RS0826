package TestNGDemo.test;

import org.testng.annotations.*;

public class day3 {
    @BeforeMethod
    public void beforeM(){
        System.out.println("Need to run before every method");

    }

    @AfterMethod
    public void afterM(){
        System.out.println("Need to run after every method");

    }

    @Test(groups = {"Smoke"})
    public void mobileWebloginCarLoan(){
        System.out.println("webloginCarLoan");

    }

    @Test
    public void mobileloginCarLoan(){

        System.out.println("MobileloginCarLoan");
    }

    @Test
    public void mobileLoginAPICarLoan(){

        System.out.println("loginAPICarLoan");

    }
    @BeforeSuite
    public void beforeSuite(){

        System.out.println("Before suite will run before all that is 1 st ");

    }

    @AfterSuite
    public void afterSuite(){

        System.out.println("After suite will run last of all... ");

    }


}
