package com.AndreaPop.Automation.base;

import com.AndreaPop.Automation.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod // Code in this method runs BEFORE every test
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://juice-shop.herokuapp.com");
    }

    @AfterMethod // Code in this method runs AFTER every test
    public  void tearDown() {
        DriverFactory.quitDriver();
    }
}
