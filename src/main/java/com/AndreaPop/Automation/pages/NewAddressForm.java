package com.AndreaPop.Automation.pages;

import com.AndreaPop.Automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressForm extends BasePage {

    @FindBy(xpath = "//*[@id=\"mat-input-9\"]")
    private WebElement countryInput;

    @FindBy(xpath = "//*[@id=\"mat-input-10\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"mat-input-11\"]")
    private WebElement mobileInput;

    @FindBy(xpath = "//*[@id=\"mat-input-12\"]")
    private WebElement zipInput;

    @FindBy(xpath = "//*[@id=\"address\"]")
    private WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"mat-input-14\"]")
    private WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"mat-input-15\"]")
    private WebElement stateInput;

    @FindBy(xpath = "//*[@id=\"submitButton\"]")
    private WebElement submit;

    public NewAddressForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress(String country, String name, String mobile, String zip, String address, String city, String state){
        countryInput.sendKeys(country);
        nameInput.sendKeys(name);
        mobileInput.sendKeys(mobile);
        zipInput.sendKeys(zip);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        submit.click();
    }
}
