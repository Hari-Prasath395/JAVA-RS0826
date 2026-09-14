package TestNGDemo.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestExecutionListener.class})
public class TestNGListenersGuide {


    @Test
    public void loginTest() {
        System.out.println("Executing loginTest...");
        // assertion logic here
    }

    @Test
    public void logoutTest() {
        System.out.println("Executing logoutTest...");
        throw new RuntimeException("Simulated failure to demo onTestFailure()");
    }



    /*
     * ============================================================================
     * INTERVIEW QUESTIONS & ANSWERS - TestNG Listeners
     * (Framed for a candidate with ~4 years of QA automation experience,
     *  Selenium + Java + TestNG + Page Object Model background)
     * ============================================================================
     *
     * Q1. What are listeners in TestNG and why do we use them?
     * A1. Listeners are interfaces that let you hook custom code into TestNG's
     *     test lifecycle events (before/after test, suite, method invocation,
     *     failure, etc.) without changing test method code. They're used for
     *     cross-cutting concerns like logging, reporting (ExtentReports/Allure),
     *     screenshot capture on failure, and retry logic.
     *
     * Q2. What's the difference between ITestListener and IInvokedMethodListener?
     * A2. ITestListener reacts only to @Test method outcomes (start/success/
     *     failure/skip) at the test level. IInvokedMethodListener fires before
     *     and after EVERY method TestNG invokes — including @BeforeMethod,
     *     @AfterMethod, @BeforeClass, etc. — giving finer-grained control, e.g.
     *     to log setup/teardown steps too.
     *
     * Q3. How do you implement automatic screenshot capture on test failure
     *     using listeners?
     * A3. Implement onTestFailure() in a class implementing ITestListener.
     *     Inside it, access the WebDriver instance (commonly stored in a
     *     ThreadLocal<WebDriver> in the framework, retrievable via a static
     *     utility or via result.getTestContext()), take a screenshot using
     *     TakesScreenshot, and attach the file path to the test result /
     *     ExtentReports log.
     *
     * Q4. How do you register a listener without annotating every test class?
     * A4. Register it in testng.xml using the <listeners> tag at the suite
     *     level, or use the ServiceLoader mechanism by creating a file at
     *     src/main/resources/META-INF/services/org.testng.ITestNGListener
     *     containing the fully qualified listener class name — TestNG then
     *     auto-detects it without any explicit registration. This is the
     *     preferred approach for shared automation frameworks.
     *
     * Q5. How would you implement automatic retry of failed tests, and how does
     *     it tie into listeners?
     * A5. Implement IRetryAnalyzer with a retry() method that returns true up to
     *     a max retry count. Since adding retryAnalyzer = RetryClass.class to
     *     every @Test is repetitive, implement IAnnotationTransformer to inject
     *     the RetryAnalyzer into every test method's annotation automatically —
     *     register IAnnotationTransformer as a listener (testng.xml or
     *     ServiceLoader) so it applies suite-wide.
     *
     * Q6. What is the execution order of listener methods relative to
     *     @BeforeMethod / @Test / @AfterMethod?
     * A6. For ITestListener: onTestStart() fires AFTER @BeforeMethod but BEFORE
     *     the @Test method body executes. onTestSuccess/onTestFailure/
     *     onTestSkipped fire AFTER the @Test method completes but BEFORE
     *     @AfterMethod. IInvokedMethodListener's beforeInvocation/
     *     afterInvocation wrap around EVERY method including configuration
     *     methods, so they fire even around @BeforeMethod/@AfterMethod itself.
     *
     * Q7. Can you use multiple listeners together? What's the execution order?
     * A7. Yes — pass multiple classes to @Listeners({A.class, B.class}) or add
     *     multiple <listener> tags in testng.xml. They execute in the order
     *     they are declared/registered. Order can matter if one listener
     *     depends on state set up by another (e.g., a reporting listener
     *     relying on a driver-management listener running first).
     *
     * Q8. How is IReporter different from ITestListener?
     * A8. ITestListener reacts to events DURING execution (per test method).
     *     IReporter's generateReport() runs ONCE, after the entire suite
     *     finishes, and gives access to all suite results at once — ideal for
     *     building a consolidated custom HTML/PDF report rather than logging
     *     incrementally.
     *
     * Q9. In a real project, where have you used listeners?
     * A9. (Sample answer to adapt) "In our ChipTrac-style ERP automation suite,
     *     we used ITestListener to auto-capture screenshots on failure and log
     *     pass/fail status into ExtentReports, and ISuiteListener to flush the
     *     report and trigger a Slack notification with suite pass percentage
     *     once the suite completed."
     *
     * Q10. What is the difference between @Listeners annotation and declaring
     *      listeners in testng.xml?
     * A10. @Listeners is class-scoped — you must annotate each test class that
     *      needs it, so it's easy to forget on new classes. testng.xml
     *      <listeners> is suite-scoped — applies to all classes in that suite
     *      automatically, making it the more maintainable choice for shared
     *      frameworks with many test classes.
     * ============================================================================
     */
}
