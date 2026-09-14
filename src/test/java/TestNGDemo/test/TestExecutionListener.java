/*
 * ============================================================================
 * TESTNG LISTENERS - COMPLETE GUIDE WITH SAMPLE CODE
 * ============================================================================
 *
 * WHAT ARE LISTENERS?
 * Listeners are interfaces provided by TestNG that let you "listen" to events
 * happening during test execution (before/after test, suite, method, on
 * failure, on success, etc.) and inject custom logic at those points —
 * WITHOUT modifying the actual test methods.
 *
 * Common use cases in real projects:
 *   - Logging test start/end/status
 *   - Taking screenshots on failure (Selenium)
 *   - Sending results to ExtentReports / Allure
 *   - Retrying failed tests
 *   - Sending email/Slack notifications on suite completion
 *   - Modifying test execution order / skipping tests dynamically
 *
 * MOST COMMONLY USED LISTENER INTERFACES:
 *   1. ITestListener        -> test level events (onTestStart, onTestSuccess,
 *                              onTestFailure, onTestSkipped, etc.)
 *   2. ISuiteListener       -> suite level events (onStart, onFinish)
 *   3. IInvokedMethodListener -> before/after EVERY method invocation
 *                                (including @BeforeMethod/@AfterMethod)
 *   4. IAnnotationTransformer -> modify annotations at runtime (e.g. force
 *                                retry analyzer on all tests)
 *   5. IReporter            -> custom report generation after suite completes
 *   6. IExecutionListener   -> onExecutionStart / onExecutionFinish for the
 *                              entire TestNG run
 *   7. IRetryAnalyzer       -> (not a listener technically, but used WITH
 *                              listeners) to retry failed tests
 *
 * HOW TO REGISTER A LISTENER (3 ways):
 *   a) @Listeners(MyListener.class) annotation on test class
 *   b) <listeners> tag in testng.xml (preferred for project-wide listeners)
 *   c) META-INF/services/org.testng.ITestNGListener (ServiceLoader - auto
 *      picked up without any config, used commonly in frameworks)
 * ============================================================================
 */

package TestNGDemo.test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener implements ITestListener {


    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getMethod().getMethodName());
        // Real-world usage: capture screenshot here
        // ScreenshotUtil.capture(driver, result.getMethod().getMethodName());

        // Log the exception too - useful for ExtentReports integration
        System.out.println("Reason: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        System.out.println("Test Suite STARTED: " + context.getName());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        System.out.println("Test Suite FINISHED: " + context.getName());
        // Real-world usage: flush ExtentReports here
        // extent.flush();
    }
}



