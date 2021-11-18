package com.herokuapp.theinternet.window;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTest() {
        log.info("Starting newWindowTest");

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        WindowsPage windows = welcomePage.clickMultipleWindowsLink();

        Assert.assertEquals(windows.getCurrentUrl(), windows.getPageUrl());

        windows.openNewWindow();

        NewWindowPage newPage = windows.switchToNewWindowPage();

        String pageSource = newPage.getCurrentPageSource();

        Assert.assertTrue(pageSource.contains("New Window"));
    }
}
