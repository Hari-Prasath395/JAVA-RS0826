package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutosuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000); // Wait for the suggestions to load
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option:options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }

        System.out.println(driver.findElement(By.id("autosuggest")).getText());
        driver.quit();


    }
}
