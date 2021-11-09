package com.herokuapp.theinternet.window;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTest() {
        log.info("Starting newWindowTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        WindowsPage windows = welcomePage.clickMultipleWindowsLink();

        Assert.assertEquals(windows.currentUrl(), windows.getPageUrl());

        windows.openNewWindow();

        NewWindowPage newPage = windows.switchToNewWindowPage();

        log.info("Hey " + newPage.getWindowText());
        Assert.assertTrue(newPage.getWindowText().equals("New Window"));
    }
}
