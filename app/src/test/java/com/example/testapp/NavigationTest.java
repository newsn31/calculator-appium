package com.example.testapp;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class NavigationTest {

    WebDriver driver;
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
    }

    @Test
    public void navTest() throws InterruptedException {
        WebElement element = driver.findElement((By.xpath("//android.widget.ImageButton[@content-desc='More options']")));
        Thread.sleep(TIMEOUT_OUT);
        element.click();
        element = driver.findElement((By.xpath("//android.widget.TextView[@text='Open source licenses']")));
        Thread.sleep(TIMEOUT_OUT);
        element.click();
        Thread.sleep(TIMEOUT_OUT);

        element = driver.findElement((By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")));
        element.click();
        Thread.sleep(TIMEOUT_OUT);
    }
}
