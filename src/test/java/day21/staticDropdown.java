package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

       WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
       Select select  = new Select(staticDropdown);

       select.selectByValue("INR");
       String selectedOption = select.getFirstSelectedOption().getText();
       System.out.println(selectedOption);

       select.selectByIndex(3);
       System.out.println(select.getFirstSelectedOption().getText());

       select.selectByVisibleText("AED");
       System.out.println(select.getFirstSelectedOption().getText());

    }
}
