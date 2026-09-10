package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

    /*Concepts in this code

1. ChromeOptions
A class used to configure how Chrome browser should launch — like a settings object you pass before opening the
browser.

2. setAcceptInsecureCerts(true)
This tells Chrome: "Ignore SSL certificate errors and open the site anyway." Normally, if a site has an
expired/invalid SSL certificate, Chrome blocks it with a warning page ("Your connection is not private").
This setting bypasses that warning.

3. new ChromeDriver(options)
Creates a ChromeDriver instance and passes the options (accept insecure certs) into it, so the browser launches
with that config already applied.

4. expired.badssl.com
A public test website specifically built to have an expired SSL certificate. It's used to test how your
automation (or browser) handles broken/invalid certificates.

5. Why this matters in real projects
Some internal company websites (UAT/staging/pre-prod environments) use self-signed or expired certificates.
Without setAcceptInsecureCerts(true), Selenium would fail to load the page or get stuck on the security warning
screen.

Interview Questions & Answers (4 yrs Selenium experience)

Q1. What is setAcceptInsecureCerts() and why do we use it?
A: It's a ChromeOptions method that tells the browser to ignore SSL certificate errors.
We use it when testing environments (like staging/UAT) that don't have valid SSL certificates,
so our tests don't get blocked by the browser's security warning page.

Q2. What happens if you don't set acceptInsecureCerts and try to open a site with an expired certificate?
A: The browser shows a "Your connection is not private" warning page instead of the actual website.
Selenium won't be able to interact with the real page elements, and your test will likely fail or throw an exception.

Q3. Is setAcceptInsecureCerts(true) safe to use in production testing?
A: It's fine for test/staging environments where you know the SSL issue is expected (self-signed certs,
expired test certs). It should NOT be used for production sites, since ignoring SSL errors there could hide
real security problems.

Q4. What is ChromeOptions used for, besides accepting insecure certs?
A: ChromeOptions is used to customize browser behavior before launch — examples: running headless mode,
maximizing window, disabling notifications, setting download folder paths, adding extensions, or ignoring
specific Chrome flags.

Q5. What's the difference between driver.manage().window().maximize() and setting window size via ChromeOptions?
A: maximize() maximizes the window after the browser has already launched. You can also set a fixed window size
directly in ChromeOptions using addArguments("--window-size=1920,1080") before launch — useful for consistent
screen resolution in CI/CD pipelines.

Q6. Why do we call driver.quit() at the end instead of driver.close()?
A: driver.close() only closes the current browser tab/window. driver.quit() closes all windows opened by
that driver session and ends the WebDriver process completely, releasing all resources. Best practice is to
always use quit() at test cleanup.

Q7. How would you verify SSL certificate handling in an automated test (not just visually)?
A: I'd verify it indirectly — check that driver.getTitle() or a specific page element loads successfully
instead of the browser's security interstitial page. If the real page title/content is returned, it confirms
the certificate warning was bypassed.

Q8. Have you faced SSL certificate issues in real projects? How did you handle them?
A: Yes — in staging environments with self-signed certificates, tests would fail at page load.
I resolved it by configuring ChromeOptions.setAcceptInsecureCerts(true) (or driver.manage().certificate()
handling in some frameworks) so automation could proceed past the certificate warning, same as this example.
*/


    public static void main(String[] args) {

        // Create a ChromeOptions object - used to configure browser settings before launch
        ChromeOptions options = new ChromeOptions();

        // Tells Chrome to IGNORE SSL certificate errors (expired/invalid/self-signed certs)
        // Without this, Chrome shows "Your connection is not private" warning page
        options.setAcceptInsecureCerts(true);

        // Launch ChromeDriver with the above options applied
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window after it opens
        driver.manage().window().maximize();

        // Navigate to a test site that intentionally has an EXPIRED SSL certificate
        // Normally this would be blocked, but our option above bypasses that block
        driver.get("https://expired.badssl.com/");

        // Print the page title to console - if this prints the real title,
        // it confirms the SSL warning was successfully bypassed
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser and end the WebDriver session, releasing all resources
        driver.quit();
    }
}