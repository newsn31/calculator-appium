package com.example.testapp;

import com.example.testapp.pageobjects.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FunctionalTest {

    WebDriver driver;
    Calculator calculator;
    public static int TIMEOUT_OUT = 3000;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "P2API24");
        capabilities.setCapability(CapabilityType.VERSION, "8.1");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        calculator = new Calculator(driver);
    }

    @Test
    public void addTest() throws InterruptedException {
        calculator.clickButton("8");
        calculator.clickButton("+");
        calculator.clickButton("4");
        calculator.clickButton("=");
        calculator.expectCalculatorResultToEqual("12");
    }

    @Test
    public void subtractTest() throws InterruptedException {
        calculator.clickButton("8");
        calculator.clickButton("−");
        calculator.clickButton("4");
        calculator.clickButton("=");
        calculator.expectCalculatorResultToEqual("4");
    }

    @Test
    public void divideTest() throws InterruptedException {
        calculator.clickButton("8");
        calculator.clickButton("÷");
        calculator.clickButton("4");
        calculator.clickButton("=");
        calculator.expectCalculatorResultToEqual("2");
    }

    @Test
    public void multiplyTest() throws InterruptedException {
        calculator.clickButton("8");
        calculator.clickButton("×");
        calculator.clickButton("4");
        calculator.clickButton("=");
        calculator.expectCalculatorResultToEqual("32");
    }
}


