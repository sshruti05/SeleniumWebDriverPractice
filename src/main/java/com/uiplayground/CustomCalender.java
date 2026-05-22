package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomCalender {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uiplayground.techwithjatin.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By customDataLocator = By.xpath("//span[contains(text(), 'Custom Calendar')]/..");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customDataLocator)).click();

        By dateInputLocator = By.id("date-input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLocator)).click();

        By monthYearHeaderLocator = By.className("dp-header-title");
        String  result = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearHeaderLocator)).getText();
        System.out.println(result);

        By nextMonthButtonLocator = By.className("dp-btn-next");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextMonthButtonLocator)).click();

        By availableDateLocator = By.cssSelector("td.dp-day-available");
        List<WebElement> availableDateElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableDateLocator));
        System.out.println(availableDateElement.size());
        availableDateElement.get(6).click();

        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLocator)).getAttribute("value");
        System.out.println(value);

//        *********************TASK 2**********************************
        wait.until((ExpectedConditions.elementToBeClickable(dateInputLocator))).click();
        By disabledDaysLocator = By.cssSelector("td.dp-day-disabled");
        List<WebElement> disabledDateListElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(disabledDaysLocator));

        for(WebElement disabledDay: disabledDateListElement){
            System.out.println(disabledDay.getText());
        }
        disabledDateListElement.getFirst().click();

        By availableDateNewLocator = By.cssSelector("td.dp-day-available");
        List<WebElement> availableDateListElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableDateNewLocator));

        System.out.println(availableDateListElement.size());

//      ****************************  TASK 3  ******************************

        By rangeBtnLocator = By.id("btn-range-mode");
        wait.until(ExpectedConditions.visibilityOfElementLocated(rangeBtnLocator)).click();

        By startCalenderDateLocator = By.id("range-input-start");
        wait.until(ExpectedConditions.elementToBeClickable(startCalenderDateLocator)).click();

        By availableDayLocator = By.cssSelector("td.dp-day-available");
        List<WebElement> availableStartDate = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableDayLocator));
        availableStartDate.getFirst().click();
        availableStartDate.getLast().click();

        System.out.println("Start Date: "+wait.until(ExpectedConditions.visibilityOfElementLocated(startCalenderDateLocator)).getAttribute("value"));

        By endCalenderDateLocator = By.id("range-input-end");
        System.out.println("End Date: "+wait.until(ExpectedConditions.visibilityOfElementLocated(endCalenderDateLocator)).getAttribute("value"));


    }
}
