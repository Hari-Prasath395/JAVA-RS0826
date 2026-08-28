package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * ============================================================
 * INTERVIEW Q&A - Selenium Browser Navigation & Window Handling
 * ============================================================
 *
 * Q1. What is the difference between driver.get() and driver.navigate().to()?
 * A1. - Functionally both load a URL and wait for the page to load.
 *     - get() is a wrapper that simply calls navigate().to() internally.
 *     - navigate() additionally exposes back(), forward(), and refresh(),
 *       which get() does not provide.
 *     - Practically there's no behavioral difference for a first-time load;
 *       navigate() is used when you also need browser history control.
 *
 * Q2. What does driver.navigate().back() do internally?
 * A2. - Simulates clicking the browser's Back button.
 *     - Moves to the previous URL in the browser's session history.
 *     - If there is no previous page in history, it has no effect.
 *     - Common pitfall: page state (e.g., form inputs, JS variables) may
 *       not be restored exactly as before - some browsers reload the page
 *       from cache/bfcache, others do a fresh GET.
 *
 * Q3. What does driver.navigate().forward() do?
 * A3. - Simulates clicking the browser's Forward button.
 *     - Only works if back() (or manual back navigation) was performed
 *       first; otherwise there's no "forward" history to move to.
 *
 * Q4. What does driver.navigate().refresh() do, and how is it different
 *     from re-calling driver.get(currentUrl)?
 * A4. - refresh() reloads the current page, equivalent to hitting F5.
 *     - get(currentUrl) navigates to that URL fresh, which may not trigger
 *       the same "reload" semantics (e.g., resubmission prompts, cache
 *       behavior) that a true refresh does.
 *     - refresh() is preferred when testing scenarios like "does the page
 *       retain state / show a warning on reload".
 *
 * Q5. Why would you use navigate().to() instead of get() in a test?
 * A5. - When you need to chain it with back()/forward()/refresh() logically
 *       as part of the same navigation object.
 *     - Some teams standardize on navigate().to() for consistency across
 *       all navigation actions in the framework (POM navigation layer).
 *
 * Q6. What happens if you call back() when there is no browser history?
 * A6. - No exception is thrown; Selenium delegates to the browser, and the
 *       browser simply stays on the current page (no-op).
 *
 * Q7. How would you validate that navigate().back() actually worked?
 * A7. - Assert driver.getCurrentUrl() equals the expected previous URL.
 *     - Or assert on a unique page element/title that only exists on the
 *       previous page.
 *     - Avoid Thread.sleep(); use WebDriverWait with ExpectedConditions
 *       (e.g., urlToBe / titleIs) since navigation is asynchronous.
 *
 * Q8. Is navigate().refresh() reliable for pages with heavy JS/AJAX content?
 * A8. - Not by itself. refresh() only triggers the reload; it does not wait
 *       for AJAX calls or dynamically rendered elements to complete.
 *     - Always pair it with explicit waits for the specific element/state
 *       you expect after reload, not just page load state.
 *
 * Q9. What's a real-world use case for combining back()/forward()/refresh()
 *     in a test suite?
 * A9. - Verifying session persistence after refresh (e.g., logged-in state,
 *       cart contents).
 *     - Testing browser-history-dependent UI (breadcrumbs, wizards/multi-step
 *       forms) behave correctly when a user navigates back and forth.
 *     - Regression-testing SPA route guards that might break on refresh.
 *
 * Q10. Why call driver.manage().window().maximize() before navigation?
 * A10. - Ensures consistent viewport size across runs/machines, avoiding
 *        flaky failures caused by responsive layouts hiding/collapsing
 *        elements at smaller default window sizes.
 *
 * Q11. Why is driver.quit() used here instead of driver.close()?
 * A11. - close() only closes the current browser tab/window; if it's the
 *        last window, the driver session may still linger.
 *     - quit() closes all windows AND ends the WebDriver session cleanly,
 *        releasing the driver process - the correct call at test teardown.
 * ============================================================
 */
public class BrowserActivities {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.rahulshettyacademy.com/");     // initial load
        driver.navigate().to("https://www.google.com/");       // navigate to new URL
        driver.navigate().back();                               // go back in history
        driver.navigate().forward();                            // go forward in history
        driver.navigate().refresh();                            // reload current page
        driver.quit();                                          // close all windows + end session
    }
}