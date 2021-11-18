package com.herokuapp.theinternet.alerts;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlerts = welcomePage.clickJsAlertsLink();

        Assert.assertEquals(javaScriptAlerts.getCurrentUrl(), javaScriptAlerts.getPageUrl());

        javaScriptAlerts.openJsAlert();

        String alertMessage = javaScriptAlerts.getAlertText();

        javaScriptAlerts.acceptAlert();

        String result = javaScriptAlerts.getResultText();

        Assert.assertTrue(alertMessage.equals("I am a JS Alert"));

        Assert.assertTrue(result.equals("You successfully clicked an alert"));

    }


    @Test
    public void jsConfirmTest() {
        log.info("Starting jsConfirmTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlerts = welcomePage.clickJsAlertsLink();

        Assert.assertEquals(javaScriptAlerts.getCurrentUrl(), javaScriptAlerts.getPageUrl());

        javaScriptAlerts.openJsConfirm();

        String alertMessage = javaScriptAlerts.getAlertText();

        javaScriptAlerts.acceptAlert();

        String positiveResult = javaScriptAlerts.getResultText();

        javaScriptAlerts.openJsConfirm();

        javaScriptAlerts.dismissAlert();

        String negativeResult = javaScriptAlerts.getResultText();

        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"));

        Assert.assertTrue(positiveResult.equals("You clicked: Ok"));

        Assert.assertTrue(negativeResult.equals("You clicked: Cancel"));

    }

    @Test
    public void jsPromptTest() {
        log.info("Starting jsPromptTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlerts = welcomePage.clickJsAlertsLink();

        Assert.assertEquals(javaScriptAlerts.getCurrentUrl(), javaScriptAlerts.getPageUrl());

        javaScriptAlerts.openJsPrompt();

        String alertMessage = javaScriptAlerts.getAlertText();

        javaScriptAlerts.typeTextIntoAlert("Hey Joe");

        String resultMessage = javaScriptAlerts.getResultText();

        Assert.assertTrue(alertMessage.equals("I am a JS prompt"));

        Assert.assertTrue(resultMessage.equals("You entered: Hey Joe"));

    }
}
