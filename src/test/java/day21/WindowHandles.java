package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

/**
 * =============================================================================
 * WINDOW HANDLES — QUICK REFERENCE + INTERVIEW PREP (4 YOE LEVEL)
 * URL: https://rahulshettyacademy.com/loginpagePractise/
 * The "Documents" link on this page opens a NEW TAB — perfect for practicing
 * every pattern below.
 * =============================================================================
 *
 * WHAT IS A WINDOW HANDLE?
 * A unique, randomly-generated alphanumeric string the browser assigns to
 * every open tab/window in a session (e.g. "CDwindow-XXXX..."). Selenium uses
 * this string to tell tabs apart — there's no "tab 1, tab 2" concept, only
 * handles. driver.switchTo().window(handle) is how you move Selenium's focus
 * from one tab to another; without switching, findElement() keeps looking in
 * whichever tab you were last focused on, even if a new tab is now open.
 * =============================================================================
*/


// =========================================================================
// 1. BASIC PARENT -> CHILD -> PARENT SWITCH
// =========================================================================
/*
 * Q: How does Selenium know which tab to act on?
 * A: Whichever handle you last passed to switchTo().window(). Opening a
 *    new tab does NOT auto-focus it — Selenium stays on the parent handle
 *    until you explicitly switch, which is the #1 mistake beginners hit
 *    ("element not found" right after a link opens a new tab).
 */

public static void switchToChildAndBack(WebDriver driver) {
    driver.get("https://rahulshettyacademy.com/loginpagePractise/");

    String parentId = driver.getWindowHandle();   // capture BEFORE the click

    driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/documents-request']")).click();

    // getWindowHandles() returns ALL open handles (parent + any new tabs), as a Set —
    // Set because order isn't guaranteed and handles must be unique.
    Set<String> handles = driver.getWindowHandles();

    for (String handle : handles) {
        if (!handle.equals(parentId)) {
            driver.switchTo().window(handle);
            System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
            break;
        }
    }

    System.out.println("Child tab title: " + driver.getTitle());
    System.out.println("Child tab URL: " + driver.getCurrentUrl());

    // Switch back to parent window
    driver.switchTo().window(parentId);
    System.out.println("Parent tab title: " + driver.getTitle());
}


    // =========================================================================
    // 2. GENERIC VERSION — WORKS FOR ANY NUMBER OF NEW WINDOWS
    // =========================================================================
    /*
     * Q: What if a click opens 3 tabs instead of 1 — how do you handle that
     * without hardcoding "get the 2nd handle"?
     * A: Capture the handle set BEFORE the click, then after the click compute
     *    the difference between the new set and the old set — whatever's left
     *    is newly opened. This avoids relying on iteration order, which the
     *    Set interface never guarantees.
     */
    public static void handleMultipleChildWindows(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        Set<String> handlesBeforeClick = driver.getWindowHandles();

        driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/documents-request']")).click();

        // Wait until at least one new handle actually shows up — opening a tab
        // isn't instant, and getWindowHandles() called too early can still
        // return only the parent.
        int expectedWindowCount = handlesBeforeClick.size() + 1;

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(expectedWindowCount));

        Set<String> handlesAfterClick = driver.getWindowHandles();
        handlesAfterClick.removeAll(handlesBeforeClick);   // now this set contains ONLY the new handle(s)

        for (String newHandle : handlesAfterClick) {
            driver.switchTo().window(newHandle);
            System.out.println("New tab opened: " + driver.getTitle());
        }

        Thread.sleep(2000); // Just for demo purposes to see the new tab
    }


    // =========================================================================
    // 3. CLOSE CHILD, RETURN TO PARENT
    // =========================================================================
    /*
     * Q: Difference between driver.close() and driver.quit()?
     * A: close() shuts only the CURRENTLY FOCUSED tab/window — if that was
     *    the last one open, the driver session ends too, but otherwise the
     *    rest of the session stays alive. quit() closes every window AND
     *    ends the WebDriver session/browser process entirely, wherever your
     *    focus currently is.
     */
    public static void closeChildAndReturnToParent(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        String parentHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/documents-request']")).click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Finished with the child tab — close JUST that tab, not the whole browser.
        driver.close();

        // Focus doesn't auto-return to the parent after close() — you must switch explicitly.
        driver.switchTo().window(parentHandle);
        System.out.println("Back on parent, still open: " + driver.getTitle());
    }

    public static void rahulshettyTutorials(WebDriver driver) {

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        String parentHandle = driver.getWindowHandle();

        // Click the link that opens the new window
        driver.findElement(
                By.xpath("//a[@href='https://rahulshettyacademy.com/documents-request']")
        ).click();

        Set<String> childHandles = driver.getWindowHandles();

        String emailId = null;

        // Switch to child window
        for (String handle : childHandles) {

            if (!handle.equals(parentHandle)) {

                driver.switchTo().window(handle);

                String text = driver.findElement(
                        By.xpath("//p[@class='im-para red']")
                ).getText();

                emailId = text.split("at")[1].trim();

                System.out.println("Email ID: " + emailId);

                break;
            }
        }

        // Switch back to parent window
        driver.switchTo().window(parentHandle);

        // Enter the extracted email
        driver.findElement(By.id("username")).sendKeys(emailId);
    }



    // =========================================================================
    // BONUS — RAPID-FIRE PITFALLS
    // =========================================================================
    /*
     * Q: getWindowHandle() vs getWindowHandles() — what's the difference?
     * A: getWindowHandle() (singular) returns ONE string — the handle of the
     *    window Selenium is currently focused on. getWindowHandles() (plural)
     *    returns a Set<String> of EVERY open window/tab's handle, focused or not.
     *
     * Q: Why is getWindowHandles() a Set and not a List?
     * A: Because handles are unique by definition and order isn't guaranteed
     *    or meaningful — the browser doesn't promise "handle 2 is the 2nd tab
     *    you opened." That's exactly why you diff two Sets (before/after)
     *    instead of trying to index into one.
     *
     * Q: You switched to a child tab, then it closed unexpectedly (e.g. an
     * ad auto-closes it). What happens on your next command?
     * A: NoSuchWindowException — Selenium is still pointed at a handle that
     *    no longer exists. Defensive code re-checks driver.getWindowHandles()
     *    and switches to a known-good handle (usually the parent) before
     *    continuing, rather than assuming the last-switched handle is still valid.
     *
     * Q: Does switching windows affect element references you already grabbed
     * from the previous tab?
     * A: Yes — a WebElement is tied to the DOM of the tab it was found in.
     *    Once you switch away and back, treat old references as stale; re-find
     *    the element after switching rather than reusing a handle to it.
     *
     * Q: How would you handle a new tab that takes a while to load before its
     * title/URL is meaningful?
     * A: Don't just switch and immediately assert — add an explicit wait after
     *    switching (e.g. ExpectedConditions.titleContains(...) or urlContains(...))
     *    since the tab can be open but still mid-navigation.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        switchToChildAndBack(driver);
//        handleMultipleChildWindows(driver);
//        closeChildAndReturnToParent(driver);

        rahulshettyTutorials(driver);
        driver.quit();



    }
}
