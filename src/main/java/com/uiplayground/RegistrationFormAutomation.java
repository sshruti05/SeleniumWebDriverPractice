package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormAutomation {
    static void main() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://uiplayground.techwithjatin.com/");

        By firstNameTextBoxLocator = By.xpath("//input[@data-testid='input-first-name']");
        WebElement firstNameTextBox = webDriver.findElement(firstNameTextBoxLocator);
        firstNameTextBox.sendKeys("Sneha");

        By lastNameTextBoxLocator = By.xpath("//input[@data-testid='input-last-name']");
        WebElement lastNameTextBox = webDriver.findElement(lastNameTextBoxLocator);
        lastNameTextBox.sendKeys("Shruti");

        By emailTextBoxLocator = By.xpath("//input[@data-testid='input-email-reg']");
        WebElement emailTextBox = webDriver.findElement(emailTextBoxLocator);
        emailTextBox.sendKeys("sneha@gmail.com");

        By passwordTextBoxLocator = By.xpath("//input[@data-testid='input-password']");
        WebElement passwordTextBox = webDriver.findElement(passwordTextBoxLocator);
        passwordTextBox.sendKeys("password");

        By phoneTextBoxLocator = By.xpath("//input[@data-testid='input-phone']");
        WebElement phoneTextBox = webDriver.findElement(phoneTextBoxLocator);
        phoneTextBox.sendKeys("+91 1111111111");

        By femaleRadioButtonLocator = By.xpath("//input[@value='Female']");
        WebElement femaleRadioButton = webDriver.findElement(femaleRadioButtonLocator);
        femaleRadioButton.click();

        By termsAndConditionsCheckBoxLocator = By.xpath("//input[@type='checkbox']");
        WebElement termsAndConditionsCheckBox = webDriver.findElement(termsAndConditionsCheckBoxLocator);
        termsAndConditionsCheckBox.click();

        By dateCalenderLocator = By.xpath("//input[@type='date']");
        WebElement dateCalender = webDriver.findElement(dateCalenderLocator);
        dateCalender.sendKeys("20");
        dateCalender.sendKeys("05");
        dateCalender.sendKeys("2026");

        By countrySelectDropdownLocator = By.xpath("//select[@data-testid='input-country']");
        WebElement countrySelectDropdown = webDriver.findElement(countrySelectDropdownLocator);
        Select select = new Select(countrySelectDropdown);
        select.selectByValue("India");
        select.selectByVisibleText("United States");
        select.selectByIndex(10);
        select.selectByContainsVisibleText("Kingdom");

        By registrationButtonLocator = By.tagName("button");
        WebElement registrationButton = webDriver.findElement(registrationButtonLocator);
        registrationButton.click();

        By registrationMessageLocator = By.xpath("//div[@data-testid='registration-success']/div[2]");
        WebElement registrationMessage = webDriver.findElement(registrationMessageLocator);
        System.out.println(registrationMessage.getText());

        By successNameLocator = By.xpath("//strong[@data-testid='success-name']");
        WebElement successName = webDriver.findElement(successNameLocator);
        System.out.println(successName.getText());

        webDriver.close();

    }
}
