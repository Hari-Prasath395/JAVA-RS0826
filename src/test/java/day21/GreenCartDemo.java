package day21;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GreenCartDemo {

    public static void addItemsToCart(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products =
                driver.findElements(By.cssSelector("h4.product-name"));

        List<String> items = Arrays.asList(itemsNeeded);

        for (int i = 0; i < products.size(); i++) {

            String[] productNames = products.get(i).getText().split("-");
            String formattedName = productNames[0].trim();

            System.out.println(formattedName);

            if (items.contains(formattedName)) {

                // Click the Add to Cart button for the current product
                products.get(i)
                        .findElement(By.xpath("following-sibling::div[@class='product-action']/button"))
                        .click();

                j++;

                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

//        Thread.sleep(2000);

        String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot"};

        addItemsToCart(driver, itemsNeeded);

//        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

        driver.quit();
    }
}

