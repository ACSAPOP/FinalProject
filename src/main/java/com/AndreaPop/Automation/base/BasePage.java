package com.AndreaPop.Automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public void dismissOverlayIfVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Adjust the XPath if the button text is different or use another locator strategy
        WebElement dismissButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")
        ));

        if (dismissButton.isDisplayed()) {
            dismissButton.click();
        }
    }

    public WebElement waitForElementById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        return wait.until(ExpectedConditions.elementToBeClickable(
                By.id(id)
        ));
    }

    public WebElement waitForElementByXPath(String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        return wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(xPath)
        ));
    }
}
