package com.herokuapp.theinternet.login;

import com.herokuapp.theinternet.CsvDataProviders;
import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLogInTests extends TestUtilities {

    //    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeTest(Map<String, String> testData) {
        //Data
        String no = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting negativeTest #" + no + " - " + description);

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        takeScreenshot("Welcome page");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        // enter username and password
        loginPage.logIn(username, password);

        // Verification
        Assert.assertEquals(loginPage.getCurrentUrl(), loginPage.getPageUrl());

        String actualErrorMessage = loginPage.getMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }
}
