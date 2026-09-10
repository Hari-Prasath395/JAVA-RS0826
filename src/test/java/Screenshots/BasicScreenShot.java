package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasicScreenShot {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));


        // Step 2: Cast the WebDriver object to TakesScreenshot interface
        // TakesScreenshot is a special Selenium interface that gives screenshot capability
        // ChromeDriver internally implements this interface, so casting works
        TakesScreenshot ts =(TakesScreenshot) driver;

        // Step 3: Capture the screenshot as a temporary File object
        // OutputType.FILE tells Selenium to return the screenshot as a File
        // (other options: OutputType.BASE64 for string, OutputType.BYTES for byte array)
        File src= ts.getScreenshotAs(OutputType.FILE);

        // Step 4: Define destination path where you want to save the screenshot
        File dest = new File("E:\\Work Space-Java\\Screenshots\\amazon_homepage.png");

        // Step 5: Copy the temp screenshot file to your desired location
        // FileUtils is from Apache Commons IO library (add dependency in pom.xml)
        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());


        //What it captures: Only the visible viewport (what's currently shown on screen) — not the full scrollable page.

        driver.quit();
    }
}
