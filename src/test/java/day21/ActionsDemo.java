package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsDemo {

    /**
     * =============================================================================
     * SELENIUM ACTIONS CLASS — COMPLETE REFERENCE + INTERVIEW PREP (4 YOE LEVEL)
     * =============================================================================
     *
     * WHAT IS THE ACTIONS CLASS?
     * ---------------------------
     * org.openqa.selenium.interactions.Actions is Selenium's API for simulating
     * complex user gestures that WebElement.click()/sendKeys() cannot express on
     * their own — mouse hover, drag-and-drop, right-click, multi-key combinations
     * (Ctrl+A, Shift+Click), and precise mouse-move sequences.
     *
     * Under the hood (Selenium 4+), Actions builds a W3C-standard "action sequence"
     * — a list of low-level input device events such as pointer moves,
     * pointer down/up, key down/up, and pauses.
     *
     * Selenium 4 uses the W3C WebDriver Actions API.
     * =============================================================================
     */

    private final WebDriver driver;
    private final Actions actions;

    // Constructor
    public ActionsDemo(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // =========================================================================
    // 1. MOUSE HOVER
    // URL: https://the-internet.herokuapp.com/hovers
    // =========================================================================
    /*
     * Q: How do you handle a hover-triggered dropdown menu?
     * A: Use moveToElement() to hover — it triggers CSS :hover or JS mouseover
     *    listeners that .click() never fires. Then wait for the submenu to
     *    appear before clicking it.
     */

    public void hoverToRevealMenu_hoversDemo() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement figure1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        actions.moveToElement(figure1).perform();

        WebElement subMenu = driver.findElement(By.xpath("//div[@class='figure'][1]//h5"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(subMenu));

        System.out.println("Submenu text: " + subMenu.getText());

        driver.findElement(By.xpath("//div[@class='figure'][1]//a[contains(text(),'View profile')]")).click();

        Thread.sleep(2000); // Just for demo purposes to see the click effect

    }

    // =========================================================================
    // 2. CLICK, DOUBLE-CLICK, RIGHT-CLICK
    // URL: https://demoqa.com/buttons
    // =========================================================================
    /*
     * Q: Difference between Actions.click(element) and element.click()?
     * A: element.click() just clicks. Actions.click() is part of a chain — it
     *    moves the pointer, then clicks — so you can combine it with hover,
     *    hold, or key presses in one sequence.
     */

    public void doubleClickExample_buttonsDemo() {

        driver.get("https://demoqa.com/buttons");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement doubleClickButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("doubleClickButton")));

        actions.doubleClick(doubleClickButton).perform();

        WebElement message =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("doubleClickMessage")));

        System.out.println(message.getText());
    }

    public void rightClickExample_buttonsDemo() {
        driver.get("https://demoqa.com/buttons");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));
        actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());
    }


    // =========================================================================
    // 3. CLICK AND HOLD / RELEASE
    // URL: https://demoqa.com/droppable
    // =========================================================================
    /*
     * Q: When would clickAndHold()+release() work but dragAndDrop() fail?
     * A: clickAndHold() holds the mouse down until you call release(). Some
     *    JS drag libraries need the mouse-move events in between — dragAndDrop()
     *    jumps straight to the target and skips them, so the drop never fires.
     */
    public void clickHoldReleaseExample_droppableDemo() {
        driver.get("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));
        actions.clickAndHold(draggable).pause(Duration.ofMillis(500)).release().perform();

    }

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        // Maximize browser
        driver.manage().window().maximize();
        ActionsDemo actionsDemo = new ActionsDemo(driver);
//        actionsDemo.hoverToRevealMenu_hoversDemo();
//        actionsDemo.doubleClickExample_buttonsDemo();
//        actionsDemo.rightClickExample_buttonsDemo();
        actionsDemo.clickHoldReleaseExample_droppableDemo();


        driver.quit();
    }
}