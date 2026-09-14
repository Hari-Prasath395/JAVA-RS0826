package streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebtableSort {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        //Click on the column of the table
        driver.findElement(By.xpath("//table[@class='table table-bordered']//span[text()='Veg/fruit name']")).click();

        //Fetch the items in the column using getText



//        for(WebElement val:colValues){
//            String allVal = val.getText();
//            System.out.println(allVal);
//        }

        //Fetch the text of all web elements in a list using streams

//        List<String> originalList =colValues.stream().map(cl->cl.getText()).collect(Collectors.toList());

        //Sort on gte original list

//        List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());

        //Assert so that we can find

//        Assert.assertEquals(originalList,sortedList);

        System.out.println("Completed");

        List<String> price;

        do {

            List<WebElement> colValues =driver.findElements(By.xpath("//table//td[1]"));

            price = colValues.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggies(s))
                    .collect(Collectors.toList());

            price.forEach(s -> System.out.println(s));

            if(price.size()<1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        }while(price.size()<1);
//        driver.quit();


    }

    public static String getPriceVeggies(WebElement s){
        String valstring = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return valstring;
    }
}
