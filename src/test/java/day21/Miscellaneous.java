package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

    public static void main(String[] args) {

        // Launch a new Chrome browser session using default settings
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window so all page elements are visible
        driver.manage().window().maximize();

        // Delete ALL cookies stored in the current browser session
        // This clears any saved login/session data, so the site treats us as a new/logged-out user
        //
        // Q1. What is the difference between deleteAllCookies() and deleteCookieNamed()?
        // A: deleteAllCookies() removes every cookie stored for the current domain in that
        //    browser session. deleteCookieNamed("cookieName") removes only one specific cookie
        //    by name, keeping the rest intact.
        //
        // Q2. Why would you clear cookies before starting a test?
        // A: To ensure test independence - each test should start from a clean state
        //    (logged out, empty cart, no cached preferences) instead of relying on leftover
        //    data from a previous run. This avoids flaky or misleading test results.
        //
        // Q3. Does deleteAllCookies() also clear localStorage or sessionStorage?
        // A: No. Cookies, localStorage, and sessionStorage are three separate browser storage
        //    mechanisms. deleteAllCookies() only clears cookies - if the site also uses
        //    localStorage/sessionStorage to persist login state, you'd need to clear those
        //    separately using JavaScriptExecutor.
        //    Example: ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        driver.manage().deleteAllCookies();

        // Delete only ONE specific cookie named "session-id"
        // Note: This runs AFTER deleteAllCookies(), so at this point there are no cookies
        // left to delete - this line is here just to show the syntax, it has no real effect
        // after deleteAllCookies() already ran
        //
        // Q4. When should you call deleteAllCookies() - before driver.get() or after?
        // A: Cookies are domain-specific, so typically you first navigate to the domain
        //    (driver.get()), then call deleteAllCookies(), then refresh the page. Calling it
        //    before visiting the site (like in this code) may not always clear cookies tied
        //    to that specific domain, since the browser might not have any domain context
        //    loaded yet. This is actually a subtle bug worth pointing out in this code.
        driver.manage().deleteCookieNamed("session-id");

        // Open Amazon's homepage
        //
        // Q5. What happens if you don't clear cookies between test runs in a suite?
        // A: Tests can become flaky or give false positives - e.g., a "login" test might pass
        //    even if the login logic is broken, simply because a previous session's cookie
        //    kept the user logged in.
        //
        // Q6. What's a real scenario where clearing cookies helped you in your project?
        // A: In ChipTrac's Admin module automation, cookie clearing/session reset was used
        //    before login test cases to make sure each test started with a fresh,
        //    unauthenticated session - avoiding false passes caused by an already-logged-in
        //    session from a previous test.
        driver.get("https://www.amazon.com/");

        // Since cookies were cleared before loading the page, Amazon will NOT recognize us
        // as a previously logged-in user - so the site should show the "Sign In" / logged-out
        // state instead of a saved account.
        //
        // Q7. Is clearing cookies enough to guarantee a fully "fresh" browser state?
        // A: Not always. Besides cookies, you may also need to clear localStorage,
        //    sessionStorage, and sometimes browser cache - depending on how the application
        //    stores its session/auth data. For a truly clean state in CI, launching a fresh
        //    browser profile per test is often more reliable than manually clearing storage.
    }
}