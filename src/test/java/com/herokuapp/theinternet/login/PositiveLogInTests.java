package com.herokuapp.theinternet.login;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        // enter username and password
        SecureAreaPage secureArea = loginPage.logIn("tomsmith", "SuperSecretPassword!");

        // verifications
        // new url
        Assert.assertEquals(secureArea.currentUrl(), secureArea.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureArea.isLogOutButtonVisible(), "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureArea.getMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
