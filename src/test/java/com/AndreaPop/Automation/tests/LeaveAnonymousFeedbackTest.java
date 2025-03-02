package com.AndreaPop.Automation.tests;

import com.AndreaPop.Automation.base.BaseTest;
import com.AndreaPop.Automation.pages.CustomerFeedbackPage;
import com.AndreaPop.Automation.pages.HomePage;
import org.testng.annotations.Test;

public class LeaveAnonymousFeedbackTest extends BaseTest {
    @Test()
    public  void leaveFeedbackTest(){
        // Open the home page
        HomePage homePage = new HomePage(driver);

        // Dismiss overlay
        homePage.dismissOverlayIfVisible();

        // Open sidemenu
        homePage.openSideMenu();

        // Open customer feedback form
        CustomerFeedbackPage cfp = homePage.clickCustomerFeedback();

        // Solve captcha
        cfp.solveCapcha();

        // Write feedback
        cfp.writeComment("This is a test comment");

        // Set rating (clicks slider to enable submit button)
        cfp.setRating();

        // Submit feedback, if rating didn't work this won't either
        cfp.submit();
    }
}
