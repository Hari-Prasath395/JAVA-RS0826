package TestNGDemo.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPDemo {

    /*
     * INTERVIEW Q1:
     * What is parameterization in TestNG?
     *
     * ANSWER:
     * Parameterization is the process of passing different sets of input data
     * to the same test method so that we can execute the same test multiple
     * times with different data.
     *
     * Example:
     * Login test can be executed with:
     * username1/password1
     * username2/password2
     * username3/password3
     *
     * This avoids writing separate test methods for each test data set.
     */


    /*
     * INTERVIEW Q2:
     * What is DataProvider in TestNG?
     *
     * ANSWER:
     * @DataProvider is used to supply multiple sets of test data to a test method.
     * Each row returned by the DataProvider represents one test execution.
     */

    @DataProvider(name="loginData")
    public Object[][] getLoginData(){

        return new Object[][]{
                {"admin","admin123"},
                {"user1","admin123"},
                {"testuser1","testuser2"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username,String password){
        System.out.println("Username"+username);
        System.out.println("Password"+password);
    }


    /*
     * INTERVIEW Q4:
     * What is the difference between @Parameters and @DataProvider?
     *
     * ANSWER:
     *
     * @Parameters:
     *  - Usually used to pass a small number of parameters to a test.
     *  - Values are commonly provided from testng.xml.
     *  - Useful for environment, browser, URL, etc.
     *
     * @DataProvider:
     *  - Used to provide multiple sets of test data.
     *  - Data can be provided programmatically.
     *  - Commonly used for data-driven testing.
     *  - Each data set results in a separate test execution.
     *
     * Example:
     *
     * @Parameters -> browser = "chrome"
     *
     * @DataProvider -> username/password combinations.
     */
}
