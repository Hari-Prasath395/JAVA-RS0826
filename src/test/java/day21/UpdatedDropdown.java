package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@data-testid = 'home-page-travellers']")).click();
        int i =1;
        while(i<4){
            driver.findElement(By.xpath("//div[@data-testid = 'Adult-testID-plus-one-cta']")).click();
            i++;
        }

        driver.findElement(By.xpath("//div[@data-testid = 'home-page-travellers-done-cta']")).click();

        Assert.assertEquals("Passengers 4 Adults", driver.findElement(By.xpath("//div[@data-testid = 'home-page-travellers']")).getText().replaceAll("\\s+", " ").trim());
//        System.out.println(driver.findElement(By.xpath("//div[@data-testid = 'home-page-travellers']")).getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
