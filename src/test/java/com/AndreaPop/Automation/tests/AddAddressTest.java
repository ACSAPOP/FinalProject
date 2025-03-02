package com.AndreaPop.Automation.tests;

import com.AndreaPop.Automation.base.BaseTest;
import com.AndreaPop.Automation.pages.*;
import com.AndreaPop.Automation.utils.CSVReader;
import com.AndreaPop.Automation.utils.UserHelper;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class AddAddressTest extends BaseTest {
    @Test
    public void addNewAddress() {
        Map<String,String> generatedUserData = UserHelper.GenerateNewUserData();
        String email = generatedUserData.get("email");
        String password = generatedUserData.get("password");

        HomePage homePage = new HomePage(driver);
        homePage.dismissOverlayIfVisible();

        LoginPage loginPage = homePage.navigateToLogin();
        RegisterPage registerPage = loginPage.clickRegisterLink();

        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterPasswordConfirmation(password);
        registerPage.clickSecurityQuestionDropDown();
        registerPage.selectMotherMaidenNameQuestionFromDropDown();
        registerPage.enterSecurityAnswer("Mother of Tests");

        loginPage = registerPage.clickRegister();
        loginPage.waitForElementsToLoad();
        homePage = loginPage.login(email, password);

        // Navigate to address dashboard
        AddressesDashboard ad = homePage.openAddressesDashboard();

        // Navigate to new address form
        NewAddressForm naf = ad.clickAddNewAddress();

        // Load address data from CSV using your CSVReader helper
        List<Map<String, String>> addresses = CSVReader.readCSV("src/main/resources/testdata/newAddress.csv");

        if (addresses.isEmpty()) {
            throw new RuntimeException("No address data found in CSV file.");
        }

        // Select a random address from the list
        Random random = new Random();
        Map<String, String> randomAddress = addresses.get(random.nextInt(addresses.size()));

        // Create the NewAddressForm page object and fill in the form with CSV data
        naf.addNewAddress(
                randomAddress.get("country"),
                randomAddress.get("name"),
                randomAddress.get("mobile"),
                randomAddress.get("zip"),
                randomAddress.get("address"),
                randomAddress.get("city"),
                randomAddress.get("state")
        );
    }
}
