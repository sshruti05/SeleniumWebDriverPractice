package com.uiplayground;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LazyLoading {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uiplayground.techwithjatin.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//        **************************** TASK 1 *********************************
        By lazyLoadingLocator = By.xpath("//span[text()='Lazy Load Images']/..");
        wait.until(ExpectedConditions.elementToBeClickable(lazyLoadingLocator)).click();

        By lazyCounterLocator = By.xpath("//div[@data-testid='lazy-count']");
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(lazyCounterLocator)).getText());

        By imagePlaceHolderLocator = By.xpath("//div[starts-with(@data-testid='img-placeholder')]");
        List<WebElement> imagePlaceHolderList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imagePlaceHolderLocator));
        System.out.println(imagePlaceHolderList.size());

//        **************************** TASK 2 *********************************

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(int i=0; i<12; i++){
            By locator = By.xpath("//div[@data-testid='image-container-"+i+"']");
            WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block: 'center'})", container);
            By placeHolderLocator = By.xpath("//div[@data-testid='image-placeholder"+i+"']");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(placeHolderLocator));

            By imageLocator = By.xpath("//img[@data-testid='img-"+i+"']");
            WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
            System.out.println("Image displayed: "+i+"======="+image.isDisplayed());

            System.out.println("Image Info ");
            System.out.println("data-testid "+ image.getAttribute("data-testid"));
            System.out.println("alt "+ image.getAttribute("alt"));
        }

    }
}
