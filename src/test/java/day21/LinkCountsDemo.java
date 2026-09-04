package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class LinkCountsDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Get the count of links on the page
        int linksPresent = driver.findElements(By.tagName("a")).size();
        System.out.println("Total links present on the page: " + linksPresent);

        // Get the count of links in the footer section
        int footerLinksPresent =
                driver.findElements(By.cssSelector("div#gf-BIG a")).size();

        System.out.println("Total links present in the footer section: "
                + footerLinksPresent);

        // Get the links in the first column of the footer section
        WebElement firstColumnFooter =
                driver.findElement(By.cssSelector(
                        "div#gf-BIG table tbody tr td:nth-child(1)"));

        List<WebElement> firstColumnFooterLinks =
                firstColumnFooter.findElements(By.tagName("a"));

        System.out.println("Total links present in the first column of the footer section: "
                + firstColumnFooterLinks.size());

        // Open each link in a new tab
        for (WebElement link : firstColumnFooterLinks) {

            String clickOnLinkTab =
                    Keys.chord(Keys.CONTROL, Keys.ENTER);

            link.sendKeys(clickOnLinkTab);
            Thread.sleep(2000); // Wait for 5 seconds to allow the new tab to open


        }

        Set<String> windowHandles= driver.getWindowHandles();
        for(String handle:windowHandles){
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
        }

        // Close browser
        driver.quit();
    }
}