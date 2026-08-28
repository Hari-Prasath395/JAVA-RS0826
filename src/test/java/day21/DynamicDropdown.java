package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicDropdown {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();


//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='BLR']"))).click();
// xpath using parent to child relationship
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='BLR']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='to-testID-destination']"))).click();

//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[normalize-space()='MAA']")
//        )).click();

        driver.quit();
//
    }
}
