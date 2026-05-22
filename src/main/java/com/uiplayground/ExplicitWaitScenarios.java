package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitScenarios {
    static void main() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://uiplayground.techwithjatin.com/");
        webDriver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        By explicitWaitMenuLinkLocator = By.xpath("//span[contains(text(),'Explicit Waits')]/..");
        wait.until(ExpectedConditions.elementToBeClickable(explicitWaitMenuLinkLocator)).click();

        System.out.println("+++++++++++++++++++++++++++++++++TASK 1++++++++++++++++++++++++++++++++++++++++");

        By taskOneTriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-visible']");
        wait.until(ExpectedConditions.elementToBeClickable(taskOneTriggerButtonLocator)).click();

        By taskOneVisibleTextLocator = By.xpath("//div[@data-testid='wait-visibility-target']");
        WebElement taskOneVisibleText = wait.until(ExpectedConditions.visibilityOfElementLocated(taskOneVisibleTextLocator));
        System.out.println(taskOneVisibleText.getText());

        System.out.println("+++++++++++++++++++++++++++++++++TASK 2++++++++++++++++++++++++++++++++++++++++");
        By taskTwoDisableButtonLocator = By.xpath("//button[@data-testid='wait-clickable-target']");
        WebElement taskTwoDisableButton = wait.until(ExpectedConditions.visibilityOfElementLocated(taskTwoDisableButtonLocator));
        String status = taskTwoDisableButton.getAttribute("disabled");
        System.out.println("DISABLED? : "+status);

        By taskTwoTriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-clickable']");
        wait.until(ExpectedConditions.elementToBeClickable(taskTwoTriggerButtonLocator)).click();

        WebElement taskTwoClickableButton = wait.until(ExpectedConditions.elementToBeClickable(taskTwoDisableButtonLocator));
        status = taskTwoClickableButton.getAttribute("disabled");

        System.out.println("DISABLED? : "+status);

        System.out.println("+++++++++++++++++++++++++++++++++TASK 3++++++++++++++++++++++++++++++++++++++++");

        By textBoxLocator = By.xpath("//div[@data-testid=\"wait-text-target\"]");
        WebElement divTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
        System.out.println(divTextBox.getText());

        By taskThreeTriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-text']");
        WebElement taskThreeTriggerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(taskThreeTriggerButtonLocator));
        taskThreeTriggerButton.click();

        boolean injectStatus = wait.until(ExpectedConditions.textToBePresentInElementLocated(textBoxLocator, "injected"));
        System.out.println(injectStatus);

        System.out.println("+++++++++++++++++++++++++++++++++TASK 4++++++++++++++++++++++++++++++++++++++++");

        By spinnerLocator = By.xpath("//div[@data-testid='wait-invisible-target']");
        WebElement spinner = wait.until(ExpectedConditions.visibilityOfElementLocated(spinnerLocator));
        System.out.println("Spinner is Displayed? "+spinner.isDisplayed());

        By taskFourTriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-invisible']");
        wait.until(ExpectedConditions.elementToBeClickable(taskFourTriggerButtonLocator)).click();

        boolean statusOfInfiniteLoaded = wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
        System.out.println("Status of Spinner: "+statusOfInfiniteLoaded);
        System.out.println("Spinner is Displayed? "+spinner.isDisplayed());

        System.out.println("+++++++++++++++++++++++++++++++++TASK 5: STALENESS OF ELEMENT++++++++++++++++++++++++++++++++++++++++");
        By divStaleTargetLocator = By.xpath("//div[@data-testid='wait-stale-target'][1]");
        WebElement divStaleTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(divStaleTargetLocator));
        System.out.println(divStaleTarget.getAttribute("data-render-key"));

        By taskFiveTriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-stale']");
        wait.until(ExpectedConditions.elementToBeClickable(taskFiveTriggerButtonLocator)).click();
        boolean staleStatus = wait.until(ExpectedConditions.stalenessOf(divStaleTarget));
        System.out.println(staleStatus);
        WebElement divStaleTargetNew = wait.until(ExpectedConditions.visibilityOfElementLocated(divStaleTargetLocator));
        System.out.println(divStaleTargetNew.getAttribute("data-render-key"));

        System.out.println("+++++++++++++++++++++++++++++++++TASK 6: Element to be Selected++++++++++++++++++++++++++++++++++++++++");
        By checkBoxLocator = By.xpath("//input[@data-testid='wait-selected-target']");
        boolean checkBoxStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxLocator)).isSelected();
        System.out.println("Checkbox Status: "+checkBoxStatus);

        By triggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-selected']");
        wait.until(ExpectedConditions.elementToBeClickable(triggerButtonLocator)).click();

        boolean checkBoxStatusNow = wait.until(ExpectedConditions.elementToBeSelected(checkBoxLocator));
        wait.until(ExpectedConditions.elementToBeSelected(checkBoxLocator));

        System.out.println("Checkbox Status: "+checkBoxStatusNow);

        webDriver.close();
    }
}
