package com.AndreaPop.Automation.pages;

import com.AndreaPop.Automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

        // Elements  using pageFactory
        @FindBy(css = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-navbar > mat-toolbar > mat-toolbar-row > button:nth-child(1) > span.mat-button-wrapper")
        private WebElement sideMenu;

        @FindBy(id = "navbarAccount")
        private WebElement accountMenu;

        // Class constructor
        public HomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        //  Methods to interact with elements
        public void clickLoginButton() {
            WebElement button = waitForElementById("navbarLoginButton");
            button.click();
        }

        public LoginPage navigateToLogin() {
            accountMenu.click();
            clickLoginButton();

            return new LoginPage(driver);
        }

        public void openSideMenu() {
            sideMenu.click();
        }

        public CustomerFeedbackPage clickCustomerFeedback() {
            WebElement cfb = waitForElementByXPath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav/div/sidenav/mat-nav-list/a[1]");
            cfb.click();

            return new CustomerFeedbackPage(driver);
        }

        public AddressesDashboard openAddressesDashboard() {
            accountMenu.click();

            WebElement ordersAndPayments = waitForElementByXPath("//*[@id=\"mat-menu-panel-0\"]/div/button[2]");
            ordersAndPayments.click();

            WebElement savedAddresses = waitForElementByXPath("//*[@id=\"mat-menu-panel-3\"]/div/button[3]");
            savedAddresses.click();

            return new AddressesDashboard(driver);
        }

    public CardsDashboard openCardsDashboard() {
        accountMenu.click();

        WebElement ordersAndPayments = waitForElementByXPath("//*[@id=\"mat-menu-panel-0\"]/div/button[2]");
        ordersAndPayments.click();

        WebElement savedCards = waitForElementByXPath("//*[@id=\"mat-menu-panel-3\"]/div/button[4]");
        savedCards.click();

        return new CardsDashboard(driver);
    }
}
