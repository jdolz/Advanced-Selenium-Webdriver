package com.herokuapp.theinternet.login;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        takeScreenshot("WelcomePage opened");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        takeScreenshot("LoginPage opened");

        // Add new cookie
        Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
        loginPage.setCookie(ck);

        // enter username and password
        SecureAreaPage secureArea = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        takeScreenshot("SecurePage opened");

        // Get cookies
        String username = secureArea.getCookie("username");
        log.info("Username cookie: " + username);
        String session = secureArea.getCookie("rack.session");
        log.info("Session cookie: " + session);

        // verifications
        // new url
        Assert.assertEquals(secureArea.getCurrentUrl(), secureArea.getPageUrl());

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
