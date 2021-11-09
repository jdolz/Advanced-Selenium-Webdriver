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

        Assert.assertEquals(javaScriptAlerts.currentUrl(), javaScriptAlerts.getPageUrl());





    }
}
