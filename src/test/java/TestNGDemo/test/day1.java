package TestNGDemo.test;

import org.testng.annotations.Test;

public class day1 {

    @Test(groups = {"Smoke"})
    public void demo(){
        System.out.println("Hello");
    }

    @Test
    public void secondTest(){
        System.out.println("Second test ");
    }
}
