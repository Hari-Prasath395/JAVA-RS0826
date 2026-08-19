package start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {


    public static void main(String[] args)
    {
        //Invoking  Browser -- chrome

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/");
        driver.getTitle();
        System.out.println(driver.getTitle());
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
//        driver.close();
        driver.quit();


    }
}
