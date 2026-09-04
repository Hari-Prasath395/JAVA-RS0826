package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsAmazon {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement accountList = driver.findElement(By.cssSelector("#nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).contextClick().perform();
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("laptop").keyUp(Keys.SHIFT).doubleClick().perform();

        driver.quit();

    }
}
