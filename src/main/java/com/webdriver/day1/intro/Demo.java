package com.webdriver.day1.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://phoenix.techwithjatin.com/sign-in");
        Thread.sleep(5000);
        By userTextBoxLocator = By.id("username");
        WebElement userTextBox = webDriver.findElement(userTextBoxLocator);
        userTextBox.clear();
        userTextBox.sendKeys("iamsup");

        By passwordTextBoxLocator = By.id("password");
        WebElement passwordTextBox = webDriver.findElement(passwordTextBoxLocator);
        passwordTextBox.clear();
        passwordTextBox.sendKeys("password");

        By singInButtonLocator = By.xpath("//span[contains(text(),'Sign in')]/ancestor::button");
        WebElement singInButton = webDriver.findElement(singInButtonLocator);
        singInButton.click();
        
        webDriver.close();

    }
}
