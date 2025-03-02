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

public class LoginPage extends BasePage {
    //Define elements using PageFactory
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id ="password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "newCustomerLink")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Methods to interact with elements
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public RegisterPage clickRegisterLink(){
        registerLink.click();
        return new RegisterPage(driver);
    }

    public void waitForElementsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("email")
        ));
    }

    public HomePage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();

        //Assume successful login directs to HomePage
        return new HomePage(driver);
    }
}
