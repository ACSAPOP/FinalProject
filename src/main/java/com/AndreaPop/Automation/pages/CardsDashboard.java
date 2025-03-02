package com.AndreaPop.Automation.pages;

import com.AndreaPop.Automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CardsDashboard extends BasePage {
    @FindBy(xpath = "//*[@id=\"mat-expansion-panel-header-0\"]")
    private WebElement addNew;

    @FindBy(xpath = "//*[@id=\"mat-input-9\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"mat-input-10\"]")
    private WebElement numberInput;

    @FindBy(xpath = "//*[@id=\"mat-input-11\"]")
    private WebElement monthInput;

    @FindBy(xpath = "//*[@id=\"mat-input-12\"]")
    private WebElement yearInput;

    @FindBy(xpath = "//*[@id=\"submitButton\"]")
    private WebElement buttonSubmit;

    public CardsDashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddNew(){
        addNew.click();
    }

    public void enterCardName(String cardName){
        nameInput.sendKeys(cardName);
    }

    public void enterCradNumber(String cardNumber){
        numberInput.sendKeys(cardNumber);
    }

    public void setExpiryMonth(String valueToSelect){
        // Wrap it with the Select class
        Select dropdown = new Select(monthInput);

        dropdown.selectByValue(valueToSelect);

    }

    public void setExpiryYear(String valueToSelect){
        // Wrap it with the Select class
        Select dropdown = new Select(yearInput);

        dropdown.selectByValue(valueToSelect);
    }

    public void submit(){
        buttonSubmit.click();
    }
}
