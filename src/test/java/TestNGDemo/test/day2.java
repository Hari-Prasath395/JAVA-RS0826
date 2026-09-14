package TestNGDemo.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

    @Test
    public void personnelLoan(){

        System.out.println("Personnel Loan");

    }

    @BeforeTest
    public void prerequisite(){

        System.out.println("Execute before or executes first");

    }

    @AfterTest
    public void afterTestAnnotation(){

        System.out.println("Execute last after test completes");

    }
}
