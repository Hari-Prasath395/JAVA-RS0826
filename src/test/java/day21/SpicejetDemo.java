package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SpicejetDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // =========================================================
        // 1. Select FROM city
        // =========================================================

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-testid='to-testID-origin']")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[normalize-space()='BLR']")
        )).click();

        // =========================================================
        // 2. Select TO city
        // =========================================================

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-testid='to-testID-destination']")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[normalize-space()='MAA']")
        )).click();

        // =========================================================
        // 3. Wait for calendar to appear
        // =========================================================

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'r-k8qxaj')]")
        ));

        // =========================================================
        // 4. Get Month and Year displayed in calendar
        // =========================================================

        List<WebElement> monthYear = driver.findElements(
                By.xpath("//div[contains(@class,'r-k8qxaj')]")
        );

        boolean monthFound = false;

        for (WebElement my : monthYear) {

            String monthYearText = my.getText().trim();

            System.out.println("Month and Year: " + monthYearText);

            if (monthYearText.equalsIgnoreCase("August 2026")) {

                System.out.println("Month and Year is correct");

                monthFound = true;

                // =================================================
                // 5. Select date 28
                // =================================================

                WebElement date28 = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//div[@data-testid='undefined-calendar-day-28'"
                                                + " and not(contains(@class,'disabled'))]"
                                )
                        )
                );

                date28.click();

                System.out.println("28 August 2026 selected");

                break;
            }
        }

        if (!monthFound) {

            System.out.println("August 2026 is not displayed");

            // =====================================================
            // 6. Click Next Month button
            // =====================================================

            WebElement nextButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@data-testid='undefined-calendar-next']")
                    )
            );

            nextButton.click();

            System.out.println("Clicked Next Month");
        }

        // =========================================================
        // 7. Select Round Trip
        // =========================================================

        WebElement roundTrip = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@data-testid='round-trip-radio-button']")
                )
        );

        // Scroll Round Trip into the center of the screen
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                roundTrip
        );

        Thread.sleep(500);

        // Try normal Selenium click
        try {

            wait.until(ExpectedConditions.elementToBeClickable(roundTrip)).click();

        } catch (Exception e) {

            System.out.println("Normal click intercepted. Using JavaScript click.");

            js.executeScript("arguments[0].click();", roundTrip);
        }

        System.out.println("Round Trip selected");

        // =========================================================
        // 8. Validate Return Date is enabled
        // =========================================================

        WebElement returnDate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//div[@data-testid='return-date-dropdown-label-test-id']"
                        )
                )
        );

        boolean isReturnDateEnabled = returnDate.isEnabled();

        System.out.println(
                "Is Return Date enabled? " + isReturnDateEnabled
        );

        // =========================================================
        // 9. Final validation
        // =========================================================

        if (isReturnDateEnabled) {

            System.out.println("PASS: Return Date is enabled.");

        } else {

            System.out.println("FAIL: Return Date is disabled.");
        }

        driver.quit();
    }
}