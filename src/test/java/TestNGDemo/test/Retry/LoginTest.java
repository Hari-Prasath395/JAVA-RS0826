package TestNGDemo.test.Retry;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {

        @Test
        public void loginTest() {

            System.out.println("Executing login test");

            Assert.fail("Intentional failure");
        }


        @Test
        public void dashboardTest() {

            System.out.println("Executing dashboard test");

            Assert.fail("Intentional failure");
        }



    /*
     * ================================================================
     * IANNOTATIONTRANSFORMER - INTERVIEW QUESTIONS
     * ================================================================
     *
     * Q1. What is IAnnotationTransformer in TestNG?
     *
     * ANSWER:
     * IAnnotationTransformer is a TestNG listener interface that allows
     * us to modify TestNG annotations dynamically at runtime.
     *
     *
     * Q2. Why would you use IAnnotationTransformer?
     *
     * ANSWER:
     * It allows us to dynamically modify annotations without changing
     * every test method individually.
     *
     * For example, we can automatically add:
     *
     * - Retry Analyzer
     * - Groups
     * - Priority
     * - Enabled/disabled status
     * - Other TestNG annotation properties
     *
     *
     * Q3. How do you use IAnnotationTransformer with Retry Analyzer?
     *
     * ANSWER:
     * We implement IAnnotationTransformer and use:
     *
     * annotation.setRetryAnalyzer(RetryAnalyzer.class);
     *
     * This automatically associates the Retry Analyzer with test methods.
     *
     *
     * Q4. What is the advantage of using IAnnotationTransformer
     *    instead of adding retryAnalyzer to every @Test?
     *
     * ANSWER:
     * It avoids code duplication.
     *
     * Instead of:
     *
     * @Test(retryAnalyzer = RetryAnalyzer.class)
     * @Test(retryAnalyzer = RetryAnalyzer.class)
     * @Test(retryAnalyzer = RetryAnalyzer.class)
     *
     * We configure it centrally in the Annotation Transformer.
     *
     *
     * Q5. Which interface is used for retry logic?
     *
     * ANSWER:
     * IRetryAnalyzer.
     *
     *
     * Q6. Which interface is used to dynamically modify annotations?
     *
     * ANSWER:
     * IAnnotationTransformer.
     *
     *
     * Q7. What is the difference between IRetryAnalyzer and
     *    IAnnotationTransformer?
     *
     * ANSWER:
     *
     * IRetryAnalyzer:
     * Handles the actual retry logic.
     *
     * IAnnotationTransformer:
     * Dynamically attaches/configures the Retry Analyzer to test methods.
     *
     *
     * Q8. How do you register an Annotation Transformer?
     *
     * ANSWER:
     * We can register it as a TestNG listener in testng.xml.
     *
     * Example:
     *
     * <listeners>
     *     <listener class-name="AnnotationTransformer"/>
     * </listeners>
     *
     *
     * Q9. Can we apply Retry Analyzer without modifying every test?
     *
     * ANSWER:
     * Yes.
     *
     * We can use IAnnotationTransformer to automatically attach the
     * Retry Analyzer to test methods.
     *
     *
     * Q10. Is retrying every failed test a good practice?
     *
     * ANSWER:
     * No.
     *
     * Retry should mainly handle transient failures.
     * We should investigate and fix the root cause of flaky tests.
     *
     *
     * Q11. What problems can excessive retries cause?
     *
     * ANSWER:
     *
     * - Increased execution time
     * - Increased CI/CD resource consumption
     * - Masking genuine defects
     * - Misleading test reports
     *
     *
     * Q12. Where would you use this in a real automation framework?
     *
     * ANSWER:
     * In a centralized TestNG listener configuration.
     *
     * This allows common behavior such as retry handling to be applied
     * consistently across the automation suite.
     *
     * ================================================================
     */
    }

