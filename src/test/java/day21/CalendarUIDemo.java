package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class CalendarUIDemo {


    public static void main(String[] args) throws InterruptedException {

        String date = "29-December-2027";
        String[] dateParts = date.split("-");
        String day = dateParts[0].trim();
        String month = dateParts[1].trim();
        String year = dateParts[2].trim();


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='2021 – 2030']")).getText());
        driver.findElement(By.xpath("//button[normalize-space()='"+year+"']")).click();
        List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
        for(WebElement monthElement : months) {
            if(monthElement.getText().equalsIgnoreCase(month)) {
                monthElement.click();
                break;
            }
        }

        List<WebElement> days = driver.findElements(By.cssSelector(".react-calendar__month-view__days__day"));
        for(WebElement dayElement : days) {
            if(dayElement.getText().equalsIgnoreCase(day)) {
                dayElement.click();
                break;
            }
        }

        List<WebElement> dateInputs = driver.findElements(
                By.cssSelector(".react-date-picker__inputGroup__input")
        );

        for(WebElement dateInput : dateInputs) {
            String inputValue = dateInput.getAttribute("value");
            System.out.println(inputValue);

            // Verify that the input value matches the expected date
            //first input is month and second input is day and third input is year and the month is in the format of MM/DD/YYYY so we need to convert the date to that format
            String expectedDate = month + "/" + day + "/" + year;
            if(inputValue.equals(expectedDate)) {
                System.out.println("Date is selected correctly: " + inputValue);
            } else {
                System.out.println("Date is not selected correctly: " + inputValue);
        }
        }









    }
}
