package TestNGDemo.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {

    /*
     * INTERVIEW Q5:
     * Where can @Parameters get its values from?
     *
     * ANSWER:
     * TestNG @Parameters commonly gets its values from testng.xml.
     */
    @Test
    @Parameters({"browser", "environment"})
    public void launchApplication(String browser, String environment) {

        System.out.println("Browser: " + browser);
        System.out.println("Environment: " + environment);
    }



    /*
     * ================================================================
     * TESTNG PARAMETERIZATION - INTERVIEW QUESTIONS
     * ================================================================
     *
     *
     * Q1. What is parameterization in TestNG?
     *
     * A:
     * Parameterization allows us to execute the same test with different
     * input values without duplicating the test method.
     *
     *
     * Q2. What are the commonly used ways of parameterization in TestNG?
     *
     * A:
     * 1. @Parameters
     * 2. @DataProvider
     *
     *
     * Q3. What is @DataProvider?
     *
     * A:
     * @DataProvider supplies test data to a test method.
     * It is mainly used for data-driven testing.
     *
     *
     * Q4. How many times will a test execute if DataProvider returns
     *    5 rows?
     *
     * A:
     * The test method will execute 5 times.
     *
     *
     * Q5. What is the return type of a commonly used DataProvider?
     *
     * A:
     * Object[][]
     *
     * Example:
     *
     * @DataProvider
     * public Object[][] getData() {
     *     return new Object[][] {
     *         {"user1", "pass1"},
     *         {"user2", "pass2"}
     *     };
     * }
     *
     *
     * Q6. How do you connect a DataProvider with a test method?
     *
     * A:
     *
     * @Test(dataProvider = "loginData")
     *
     *
     * Q7. Can a DataProvider have multiple parameters?
     *
     * A:
     * Yes.
     *
     * Example:
     *
     * @DataProvider(name = "data")
     * public Object[][] data() {
     *     return new Object[][] {
     *         {"username", "password", "role"}
     *     };
     * }
     *
     * The test method should have matching parameters:
     *
     * @Test(dataProvider = "data")
     * public void test(String username, String password, String role) {
     * }
     *
     *
     * Q8. What happens if the number of DataProvider values does not
     *    match the test method parameters?
     *
     * A:
     * TestNG will throw an error because the supplied data cannot be
     * mapped correctly to the test method parameters.
     *
     *
     * Q9. Can DataProvider be placed in another class?
     *
     * A:
     * Yes.
     *
     * We can specify the class using dataProviderClass.
     *
     * Example:
     *
     * @Test(
     *     dataProvider = "loginData",
     *     dataProviderClass = TestData.class
     * )
     *
     *
     * Q10. What is the difference between @Parameters and @DataProvider?
     *
     * A:
     * @Parameters is commonly used for passing configuration values
     * through testng.xml.
     *
     * @DataProvider is mainly used for multiple sets of test data and
     * data-driven testing.
     *
     *
     * Q11. Which one would you use for cross-browser testing?
     *
     * A:
     * It depends on the framework design.
     *
     * @Parameters can be used when the browser value is supplied through
     * testng.xml.
     *
     * DataProvider can be used when we want to execute the same test with
     * multiple browser/data combinations.
     *
     *
     * Q12. Can DataProvider return data from an Excel file?
     *
     * A:
     * Yes.
     *
     * DataProvider itself does not directly read Excel.
     * We can use Apache POI to read Excel data and return it through
     * the DataProvider.
     *
     *
     * Q13. Can DataProvider read data from JSON?
     *
     * A:
     * Yes.
     *
     * We can use libraries such as Jackson or Gson to read JSON data
     * and return the required data through a DataProvider.
     *
     *
     * Q14. Can DataProvider read data from a database?
     *
     * A:
     * Yes.
     *
     * We can use JDBC to retrieve database records and return them
     * through the DataProvider.
     *
     *
     * Q15. What is data-driven testing?
     *
     * A:
     * Data-driven testing separates test logic from test data.
     * The same test logic is executed with multiple sets of input data.
     *
     *
     * Q16. Can we execute DataProvider tests in parallel?
     *
     * A:
     * Yes.
     *
     * We can use:
     *
     * @DataProvider(name = "loginData", parallel = true)
     *
     * This allows multiple data sets to execute in parallel.
     *
     *
     * Q17. What should we consider before using parallel DataProvider?
     *
     * A:
     * We must ensure thread safety.
     *
     * In Selenium frameworks, WebDriver should generally be managed
     * separately for each thread, commonly using ThreadLocal.
     *
     *
     * Q18. What is the advantage of DataProvider?
     *
     * A:
     * 1. Avoids duplicate test methods.
     * 2. Supports data-driven testing.
     * 3. Improves maintainability.
     * 4. Allows multiple test data combinations.
     * 5. Can integrate with Excel, JSON, CSV and databases.
     *
     *
     * Q19. Give a real-world example of DataProvider.
     *
     * A:
     * Login testing:
     *
     * Username       Password       Expected Result
     * ------------------------------------------------
     * admin          admin123       Login successful
     * admin          wrong123       Login failed
     * wronguser      admin123       Login failed
     * wronguser      wrong123       Login failed
     *
     * The same login test method can validate all these combinations.
     *
     *
     * Q20. In a real automation framework, where would you keep
     *      test data?
     *
     * A:
     * It depends on the project.
     *
     * Common options are:
     * - JSON
     * - Excel
     * - CSV
     * - Database
     * - Configuration files
     *
     * For larger frameworks, keeping test data separate from test logic
     * improves maintainability and reusability.
     *
     * ================================================================
     */
}
