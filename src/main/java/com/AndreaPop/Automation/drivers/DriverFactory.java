package com.AndreaPop.Automation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
