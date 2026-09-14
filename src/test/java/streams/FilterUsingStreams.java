package streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterUsingStreams {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement>rowList =driver.findElements(By.xpath("//tr/td[1]"));

        rowList.stream().map(s->s.getText()).forEach(s-> System.out.println(s));

        List<WebElement> filteredList= rowList.stream().filter(rv->rv.getText().contains("Rice")).collect(Collectors.toList());

        filteredList.stream().map(s->s.getText()).forEach(s-> System.out.println(s));
        Assert.assertEquals(rowList,filteredList);


    }
}
