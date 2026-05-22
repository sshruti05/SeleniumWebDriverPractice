package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FileUpload {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uiplayground.techwithjatin.com/");
        driver.manage().window().maximize();
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        By fileUploadMenuLinkLocator = By.xpath("//span[contains(text(),'File Upload')]/..");
        wait.until(ExpectedConditions.elementToBeClickable(fileUploadMenuLinkLocator)).click();

        By fileInputLocator = By.xpath("//input[@data-testid='file-input']");
        wait.until(ExpectedConditions.presenceOfElementLocated(fileInputLocator)).sendKeys("C:\\Users\\jaisw\\OneDrive\\Desktop\\Demo.txt");

        By fileUploadedListLocator = By.xpath("//div[@data-testid='file-list']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fileUploadedListLocator));

        wait.until(ExpectedConditions.presenceOfElementLocated(fileInputLocator)).sendKeys("C:\\Users\\jaisw\\OneDrive\\Pictures\\Camera Roll\\WIN_20210819_16_03_59_Pro.mp4");

        By fileInfoElement = By.xpath("//div[@data-testid='file-list']/div");

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(fileInfoElement,1));
        List<WebElement> fileInfoList = driver.findElements(fileInfoElement);
        System.out.println(fileInfoList.size());

        for(WebElement fileData: fileInfoList){
            System.out.print(fileData.findElement(By.xpath(".//span[@class='file-name']")).getText()+"|");
            System.out.print(fileData.findElement(By.xpath(".//span[@class='file-size']")).getText()+"|");
            System.out.print(fileData.findElement(By.xpath(".//span[@class='file-status']")).getText()+"|");
            System.out.println(" ");


        }


    }
}
