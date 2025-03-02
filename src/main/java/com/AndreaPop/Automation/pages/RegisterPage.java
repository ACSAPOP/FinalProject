package com.AndreaPop.Automation.pages;

import com.AndreaPop.Automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage {

    @FindBy(id = "emailControl")
    private WebElement emailControl;

    @FindBy(id = "passwordControl")
    private WebElement passwordControl;

    @FindBy(id = "repeatPasswordControl")
    private WebElement repeatPasswordControl;

    @FindBy(xpath = "//*[@id=\"registration-form\"]/div[1]/mat-form-field[1]/div/div[1]/div[3]")
    private WebElement questionSelector;

    @FindBy(id = "securityAnswerControl")
    private WebElement securityAnswerControl;

    // Constructor
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailControl.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordControl.sendKeys(password);
    }

    public void enterPasswordConfirmation(String passwordConfirmation) {
        repeatPasswordControl.sendKeys(passwordConfirmation);
    }

    public void clickSecurityQuestionDropDown() {
        questionSelector.click();
    }

    public void selectMotherMaidenNameQuestionFromDropDown() {
        WebElement element = waitForElementById("mat-option-5");
        element.click();
    }

    public void enterSecurityAnswer(String answer) {
        securityAnswerControl.sendKeys(answer);
    }

    public LoginPage clickRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the overlay is not visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cdk-overlay-0")));

        // Now attempt to click the register button
        driver.findElement(By.id("registerButton")).click();
        return new LoginPage(driver);
    }
}
