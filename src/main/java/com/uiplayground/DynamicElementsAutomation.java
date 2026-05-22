package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicElementsAutomation {
    static void main() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://uiplayground.techwithjatin.com/");
        webDriver.manage().window().maximize();

//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Explicit Wait: checks state of the element like: viisibility, present, clickable
        WebDriverWait wait =  new WebDriverWait(webDriver, Duration.ofSeconds(10));

        By dynamicElementMenuLinkLocator = By.xpath("//span[contains(text(),'Dynamic Elements')]/..");
        WebElement dynamicElementMenuLink = wait.until(ExpectedConditions.elementToBeClickable(dynamicElementMenuLinkLocator));
        dynamicElementMenuLink.click();

        By addItemButtonLocator = By.xpath("//button[contains(text(),'Add Menu Item')]");
        WebElement addItemButton = wait.until(ExpectedConditions.elementToBeClickable(addItemButtonLocator));
        addItemButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(addItemButtonLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addItemButtonLocator)).click();

        By swiggyCardLocator = By.xpath("//div[@class='swiggy-card']");
        List<WebElement> foodItemList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(swiggyCardLocator,2));
        System.out.println(foodItemList.size());
        for(WebElement foodItem: foodItemList){

            By foodItemNameLocator = By.xpath(".//div[@class='swiggy-name']");
            WebElement foodItemName = foodItem.findElement(foodItemNameLocator);
            System.out.println(foodItemName.getText());

            By foodItemPriceLocator = By.xpath(".//span[@class='swiggy-price']");
            WebElement foodItemPrice = foodItem.findElement(foodItemPriceLocator);
            System.out.println(foodItemPrice.getText());
        }

        By liveCounterLocator = By.className("counter-badge");
        WebElement liveCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(liveCounterLocator));
        System.out.println(liveCounter.getText());

        By toggleVisibilityButtonLocator = By.id("btn-toggle-visibility");
        WebElement toggleVisibilityButton = wait.until(ExpectedConditions.elementToBeClickable(toggleVisibilityButtonLocator));
        toggleVisibilityButton.click();

        By visibilityStateLocator = By.xpath("//span[@data-testid='visibility-state']");
        WebElement visibilityState = wait.until(ExpectedConditions.visibilityOfElementLocated(visibilityStateLocator));
        System.out.println("Visibility state is:- "+visibilityState.getText());

//        webDriver.close();
    }
}
