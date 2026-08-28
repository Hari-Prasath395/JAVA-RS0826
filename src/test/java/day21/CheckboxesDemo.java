package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckboxesDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // ==========================================================
        // SCENARIO 1: Count total checkboxes on the page
        // ==========================================================
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int count = checkboxes.size();
        System.out.println("Number of checkboxes: " + count);

        /*
         * Q1) How do you find the total number of checkboxes on a page?
         * A) I use findElements() with an xpath like //input[@type='checkbox'].
         *    findElements returns a list, and I just take .size() of that list.
         *    findElement would throw NoSuchElementException if nothing matches,
         *    so for counting purposes findElements is the safer choice since it
         *    returns an empty list instead of throwing.
         */

        // ==========================================================
        // SCENARIO 2: Verify the default/initial state of a checkbox
        // (checked or unchecked) BEFORE interacting with it
        // ==========================================================
        WebElement sundayCheckbox = driver.findElement(By.id("sunday"));
        boolean isSundayInitiallySelected = sundayCheckbox.isSelected();
        Assert.assertFalse(isSundayInitiallySelected);
        System.out.println("Sunday checkbox initial state: " + isSundayInitiallySelected);

        /*
         * Q2) How do you check if a checkbox is already selected without
         *     clicking it?
         * A) isSelected() — it just reads the current state, it doesn't
         *    interact with the element. click() on the other hand toggles
         *    the state, so if you click a checkbox twice thinking you're
         *    "selecting" it, you've actually selected then deselected it.
         *    That's a mistake I've seen freshers make a lot — always check
         *    isSelected() first if the checkbox might already be pre-checked.
         */

        // ==========================================================
        // SCENARIO 3: Select a checkbox only if it is NOT already selected
        // (idempotent select — avoids accidental toggle-off)
        // ==========================================================
        if (!sundayCheckbox.isSelected()) {
            sundayCheckbox.click();
        }
        System.out.println("Sunday checkbox selected: " + sundayCheckbox.isSelected());

        // ==========================================================
        // SCENARIO 4: Deselect a checkbox only if it IS currently selected
        // ==========================================================
        WebElement mondayCheckbox = driver.findElement(By.id("monday"));
        if (mondayCheckbox.isSelected()) {
            mondayCheckbox.click();
        }

        /*
         * Q3) What's the difference between click() and isSelected() on a
         *     checkbox?
         * A) click() performs the action of toggling the checkbox — it flips
         *    whatever state it's currently in. isSelected() is a getter, it
         *    just tells you true/false for the current state and does not
         *    change anything. You typically combine both: read the state
         *    with isSelected(), decide what to do, then act with click().
         */

        // ==========================================================
        // SCENARIO 5: Select ALL checkboxes on the page in a loop
        // ==========================================================
        for (WebElement cb : checkboxes) {
            if (cb.isDisplayed() && cb.isEnabled() && !cb.isSelected()) {
                cb.click();
            }
        }

        /*
         * Q4) How would you select all checkboxes on a page dynamically,
         *     without hardcoding each locator?
         * A) findElements() to get the whole list, then loop through it and
         *    click() each one after checking isSelected() so I don't
         *    accidentally uncheck anything that was already checked. I also
         *    check isDisplayed() and isEnabled() inside the loop — some pages
         *    have hidden or disabled checkboxes in the DOM that you can't (or
         *    shouldn't) interact with, and clicking a hidden element throws
         *    ElementNotInteractableException.
         */

        // ==========================================================
        // SCENARIO 6: Deselect ALL checkboxes on the page in a loop
        // ==========================================================
        for (WebElement cb : checkboxes) {
            if (cb.isDisplayed() && cb.isEnabled() && cb.isSelected()) {
                cb.click();
            }
        }

        // ==========================================================
        // SCENARIO 7: Count how many checkboxes are currently selected
        // vs unselected (useful for validating a "select all" feature)
        // ==========================================================
        int selectedCount = 0;
        for (WebElement cb : checkboxes) {
            if (cb.isSelected()) {
                selectedCount++;
            }
        }
        System.out.println("Selected checkboxes: " + selectedCount + " / " + count);

        /*
         * Q5) How do you validate a "Select All" checkbox works correctly?
         * A) I click the "select all" checkbox, then loop through every
         *    individual checkbox and assert isSelected() is true for each
         *    one. I also test the reverse — uncheck "select all" and confirm
         *    every individual box gets cleared. And I check the partial
         *    case: if I manually uncheck one item, does the "select all"
         *    box itself go back to unchecked (or show an indeterminate
         *    state, if the UI supports that)?
         */

        // ==========================================================
        // SCENARIO 8: Verify a checkbox is enabled before interacting
        // (disabled checkboxes should not be clickable / should not change)
        // ==========================================================
        // Example pattern — locator is illustrative, adjust id/name as needed
        // WebElement disabledCheckbox = driver.findElement(By.id("someDisabledCheckboxId"));
        // boolean stateBefore = disabledCheckbox.isSelected();
        // System.out.println("Is enabled: " + disabledCheckbox.isEnabled());
        // if (disabledCheckbox.isEnabled()) {
        //     disabledCheckbox.click();
        // }
        // boolean stateAfter = disabledCheckbox.isSelected();
        // // Negative check: for a disabled checkbox, stateBefore should equal stateAfter

        /*
         * Q6) How do you test a disabled checkbox?
         * A) First confirm isEnabled() returns false. Then, as a negative
         *    test, I try clicking it anyway (or rather, I don't even
         *    attempt click() in real automation since Selenium will throw
         *    an exception on a truly disabled element — but from a manual/
         *    exploratory angle, the point is to confirm the state genuinely
         *    can't change through the UI). The assertion is basically:
         *    state before == state after, and isEnabled() == false.
         */

        // ==========================================================
        // SCENARIO 9: Verify checkbox label text is correctly associated
        // ==========================================================
        // Example: locate the <label> using the "for" attribute matching
        // the checkbox id, then read its text.
        // WebElement label = driver.findElement(By.xpath("//label[@for='sunday']"));
        // System.out.println("Label text: " + label.getText());

        /*
         * Q7) How do you verify the label next to a checkbox matches the
         *     expected text?
         * A) If the HTML uses <label for="checkboxId">, I locate the label
         *    with an xpath like //label[@for='sunday'] and compare its
         *    getText() against the expected string. If there's no "for"
         *    attribute and the label just wraps the checkbox, I'd go up to
         *    the parent element instead, something like
         *    checkbox.findElement(By.xpath("./..")).getText().
         */

        // ==========================================================
        // SCENARIO 10: Verify checkbox state persists after an unrelated
        // page action (e.g., scrolling, filling another field, or a
        // partial page refresh via JS) — catches state-reset bugs
        // ==========================================================
        boolean stateBeforeAction = sundayCheckbox.isSelected();
        // ... perform some other UI action here (fill a text field, scroll, etc.) ...
        boolean stateAfterAction = sundayCheckbox.isSelected();
        System.out.println("State retained: " + (stateBeforeAction == stateAfterAction));

        // ==========================================================
        // SCENARIO 11: Keyboard accessibility — toggle checkbox using
        // SPACE key instead of click() (accessibility / a11y coverage)
        // ==========================================================
        // sundayCheckbox.sendKeys(Keys.SPACE);

        /*
         * Q8) Besides click(), how else can a checkbox be toggled, and why
         *     would you test that?
         * A) You can send Keys.SPACE to a focused checkbox to toggle it.
         *    I'd test this for accessibility coverage — a lot of real users
         *    (and screen reader / keyboard-only users) never touch the
         *    mouse, so if space-bar toggling is broken, that's a genuine
         *    accessibility bug even though "click" testing alone would
         *    never catch it.
         */

        // ==========================================================
        // SCENARIO 12: Visibility / presence check before interaction
        // (avoid ElementNotInteractableException on hidden checkboxes)
        // ==========================================================
        for (WebElement cb : checkboxes) {
            if (!cb.isDisplayed()) {
                System.out.println("Hidden checkbox found, skipping interaction.");
            }
        }

        /*
         * Q9) What exception do you get if you try to click a checkbox
         *     that's present in the DOM but not visible, and how do you
         *     avoid it?
         * A) ElementNotInteractableException. I guard against it by
         *    checking isDisplayed() before calling click(), and if the
         *    element is inside a collapsed section or dropdown, I make
         *    sure to expand/scroll to it first rather than force-clicking
         *    with JavascriptExecutor (which can mask real bugs by clicking
         *    something a real user physically couldn't).
         */

        driver.quit();
    }
}

/*
 * ================================================================
 * SUMMARY — Checkbox test coverage checklist
 * ================================================================
 * 1. Total checkbox count on the page
 * 2. Default/initial state of each checkbox (checked vs unchecked)
 * 3. Select a single checkbox (idempotent — check before click)
 * 4. Deselect a single checkbox (idempotent — check before click)
 * 5. Select all checkboxes via loop
 * 6. Deselect all checkboxes via loop
 * 7. Count selected vs unselected (validate "select all" feature)
 * 8. Disabled checkbox behavior (state should not change)
 * 9. Label text association / correctness
 * 10. State persistence across unrelated UI actions
 * 11. Keyboard accessibility (space bar toggle)
 * 12. Visibility check before interaction (avoid hidden-element errors)
 * 13. (Not shown above) Cross-checkbox dependency — e.g., selecting
 *     "Terms & Conditions" enables a submit button; verify the linked
 *     behavior, not just the checkbox itself.
 * 14. (Not shown above) Mandatory checkbox validation — form should
 *     show a validation error if a required checkbox is left unchecked
 *     on submit.
 * ================================================================
 */