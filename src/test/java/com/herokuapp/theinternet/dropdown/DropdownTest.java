package com.herokuapp.theinternet.dropdown;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities {

    @Test
    public void clickDropdownTest() {
        log.info("Starting selectingDropdownTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        Assert.assertEquals(dropdownPage.currentUrl(), dropdownPage.getPageUrl());

        dropdownPage.selectOption(2);

        Assert.assertTrue(dropdownPage.isOptionSelected(2),"Not selected");

    }
}
