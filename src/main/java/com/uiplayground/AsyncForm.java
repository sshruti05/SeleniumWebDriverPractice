package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AsyncForm {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uiplayground.techwithjatin.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By lazyLoadingLocator = By.xpath("//span[text()='Async Form']/..");
        wait.until(ExpectedConditions.elementToBeClickable(lazyLoadingLocator)).click();

        By inputNameLocator = By.xpath("//input[@data-testid='input-name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputNameLocator)).sendKeys("Sneha Shruti");

        By inputEmailLocator = By.xpath("//input[@data-testid='input-email']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmailLocator)).sendKeys("sneha@gmail.com");

        By selectRoleLocator = By.xpath("//select[@data-testid='select-role']");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selectRoleLocator));
        Select roleDropdown = new Select(dropdown);
        roleDropdown.selectByIndex(2);

        By submitBtnLocator = By.xpath("//button[@data-testid='btn-submit-form']");
        wait.until(ExpectedConditions.elementToBeClickable(submitBtnLocator)).click();

        By formStateLocator = By.xpath("//span[@data-testid='form-state']");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(formStateLocator, "validating"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(formStateLocator, "submitting"));

        By formSuccessLocator = By.xpath("//div[@data-testid='form-success']");
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(formSuccessLocator),
                ExpectedConditions.textToBePresentInElementLocated(formStateLocator, "error")));

        boolean status =! driver.findElements(formSuccessLocator).isEmpty();

        if(status){
            String data = wait.until(ExpectedConditions.visibilityOfElementLocated(formStateLocator)).getText();
            System.out.println(data);
        }
        else{
            By errorMsgLocator = By.xpath("div//[@data-testid='form-error']");
            System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator)).getText());
            System.out.println(driver.findElement(formStateLocator).getText());
        }

    }
}
