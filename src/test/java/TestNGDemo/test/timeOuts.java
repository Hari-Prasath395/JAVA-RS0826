package TestNGDemo.test;

import org.testng.annotations.Test;

public class timeOuts {

    @Test(timeOut = 2000)
    public void testCase() throws InterruptedException {

        System.out.println("Test started");

        Thread.sleep(1000);

        System.out.println("Test completed");
    }
}
