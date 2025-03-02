package com.AndreaPop.Automation.tests;

import com.AndreaPop.Automation.base.BaseTest;
import com.AndreaPop.Automation.pages.HomePage;
import com.AndreaPop.Automation.pages.LoginPage;
import com.AndreaPop.Automation.pages.RegisterPage;
import com.AndreaPop.Automation.utils.UserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test()
    public void loginWithValidUser () {
        // Generates unique user to login
        Map<String,String> generatedUserData = UserHelper.GenerateNewUserData();
        String email = generatedUserData.get("email");
        String password = generatedUserData.get("password");

        // Open the homepage
        HomePage homePage = new HomePage(driver);

        // Dismiss overlay that appears
        homePage.dismissOverlayIfVisible();

        // Navigate to login page
        LoginPage loginPage = homePage.navigateToLogin();

        // Navigate to register page
        RegisterPage registerPage = loginPage.clickRegisterLink();

        // Enter user details
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterPasswordConfirmation(password);
        registerPage.clickSecurityQuestionDropDown();
        registerPage.selectMotherMaidenNameQuestionFromDropDown();
        registerPage.enterSecurityAnswer("Mother of Tests");

        // Register
        loginPage = registerPage.clickRegister();

        // Wait for login page to reload
        loginPage.waitForElementsToLoad();

        // Login with newly registered user
        loginPage.login(email, password);

        // Verify that the title of the page is as expected (The home page)
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, "OWASP Juice Shop");
    }
}


