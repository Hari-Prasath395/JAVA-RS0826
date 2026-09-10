package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavascriptExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/#/");

        JavascriptExecutor js = (JavascriptExecutor) driver;//explaination: we are casting driver to JavascriptExecutor interface so that we can use its methods.
        js.executeScript("window.scrollBy(0,600)");//scroll down by 600 pixels
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,50)");//scroll into view of the table
        List<WebElement> values =driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;

        for(int i=0;i<values.size();i++){
            System.out.println(values.get(i).getText());
            sum = sum+Integer.parseInt(values.get(i).getText());
        }
        System.out.println("Sum of values in the fourth column: " + sum);

//

        WebElement totalAmt =driver.findElement(By.xpath("//div[@class='tableFixHead']/following::div[@class='totalAmount']"));
        String[] amtText = totalAmt.getText().split(":");
        String Amt = amtText[1].trim();
        int Total= Integer.parseInt(Amt);
        System.out.println(Amt);

        Assert.assertEquals(Total, sum);
        driver.quit();

    }


}
