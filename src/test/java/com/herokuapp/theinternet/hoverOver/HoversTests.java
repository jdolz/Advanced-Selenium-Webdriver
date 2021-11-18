package com.herokuapp.theinternet.hoverOver;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {

    @Test
    public void hoversTests() {
        log.info("Starting HoversTests");

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        HoversPage hovers = welcomePage.clickHoversLink();

        Assert.assertEquals(hovers.getCurrentUrl(), hovers.getPageUrl());

        hovers.openUsersProfile(2);

        Assert.assertTrue(hovers.getCurrentUrl().contains("/users/2"));


    }
}
