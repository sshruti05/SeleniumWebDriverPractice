package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DateTimePicker {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uiplayground.techwithjatin.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By dateTimeMenueLinkLocator = By.xpath("//span[contains(text(), 'Date Picker')]/..");
        wait.until(ExpectedConditions.elementToBeClickable(dateTimeMenueLinkLocator)).click();

        By singleDateCalenderLocator = By.xpath("//input[@data-testid='date-single']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(singleDateCalenderLocator)).sendKeys("05-06-2026");

        By selectedDataLocator = By.xpath("//div[@data-testid='date-selected']");
        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedDataLocator)).getText();
        System.out.println(result);

        By dateFromLocator = By.xpath("//input[@data-testid='date-from']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateFromLocator)).sendKeys("07-04-2026");

        By dateToLocator = By.xpath("//input[@data-testid='date-to']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateFromLocator)).sendKeys("21-05-2026");



    }
}
