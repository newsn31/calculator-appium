package com.example.testapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Calculator {

    private WebDriver driver;

    public Calculator(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(String button) throws InterruptedException {
        By currentButton = By.xpath("//android.widget.Button[@text='" + button + "']");
        driver.findElement(currentButton).click();
        Thread.sleep(3000);
    }

    public void expectCalculatorResultToEqual(String expected) {
        By actual = By.xpath("//android.widget.TextView[@text='" + expected + "']");
        assertEquals(driver.findElement(actual).getText(), expected);
    }
}
