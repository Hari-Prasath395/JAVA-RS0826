package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

       Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

                  WebElement fo =  wait.until(new Function<WebDriver, WebElement>() {
                       public WebElement apply(WebDriver driver) {
                           return driver.findElement(By.xpath("[id='finish'] h4"));
                       }
       });
        System.out.println(fo.getText());
        driver.quit();
    }
}
