package com.herokuapp.theinternet.checkbox;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoCheckboxesTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver,log);
        welcomePage.openPage();

        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        Assert.assertEquals(checkboxesPage.currentUrl(), checkboxesPage.getPageUrl());

        checkboxesPage.selectAllCheckboxes();

        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"Not all checkboxes are checked");
        
    }
}
