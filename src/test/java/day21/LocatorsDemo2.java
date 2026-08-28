package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsDemo2 {

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        WebElement txtmsg = driver.findElement(By.cssSelector("form p"));
        String passwordText = txtmsg.getText();
        String[] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];
        return password;
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        String name = "Rahul";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername"))
                .sendKeys(name);

        driver.findElement(By.name("inputPassword"))
                .sendKeys(password);

        driver.findElement(By.className("signInBtn"))
                .click();

        Thread.sleep(2000);

        String actualMessage =
                driver.findElement(By.tagName("p")).getText();

        System.out.println(actualMessage);

        Assert.assertEquals(
                actualMessage,
                "You are successfully logged in."
        );

       WebElement loginmsg =  driver.findElement(By.cssSelector("[class='login-container'] h2"));
       System.out.println(loginmsg.getText());
       Assert.assertEquals(loginmsg.getText(),"Hello"+" "+name+",");
       driver.findElement(By.xpath("//button[text()='Log Out']")).click();
       driver.quit();
    }
}