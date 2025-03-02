package com.AndreaPop.Automation.pages;

import com.AndreaPop.Automation.base.BasePage;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesDashboard extends BasePage {
    @FindBy(xpath = "/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-saved-address/div/app-address/mat-card/div/button")
    private WebElement addNewAddress;

    public AddressesDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewAddressForm clickAddNewAddress(){
        addNewAddress.click();
        return new NewAddressForm(driver);
    }
}
