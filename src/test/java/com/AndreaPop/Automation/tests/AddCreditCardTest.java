package com.AndreaPop.Automation.tests;

import com.AndreaPop.Automation.base.BaseTest;
import com.AndreaPop.Automation.pages.*;
import com.AndreaPop.Automation.utils.CSVReader;
import com.AndreaPop.Automation.utils.UserHelper;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class AddCreditCardTest extends BaseTest {
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

        CardsDashboard cd = homePage.openCardsDashboard();

        // Load card data from the CSV file
        List<Map<String, String>> cardsData = CSVReader.readCSV("src/main/resources/testdata/newCards.csv");

        if (cardsData.isEmpty()) {
            throw new RuntimeException("No card data found in CSV file.");
        }

        // Select a random card from the list
        Random random = new Random();
        Map<String, String> randomCard = cardsData.get(random.nextInt(cardsData.size()));

        // Create the NewAddressForm page object and fill in the form with CSV data
        // Click the add new card button to open the form
        cd.clickAddNew();

        // Fill out the form using data from the CSV record
        cd.enterCardName(randomCard.get("cardName"));
        cd.enterCradNumber(randomCard.get("cardNumber"));
        cd.setExpiryMonth(randomCard.get("expiryMonth"));
        cd.setExpiryYear(randomCard.get("expiryYear"));

        // Submit the new card
        cd.submit();
    }
}
