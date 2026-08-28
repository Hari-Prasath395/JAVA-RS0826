package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsDemo3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/Automationpractice/");
        System.out.println(driver.findElement(By.xpath("//header//div//button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header//div//button[1]/following-sibling::button[2]")).getText());
        driver.quit();
    }
}
