package com.herokuapp.theinternet.checkbox;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoCheckboxesTest");

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        Assert.assertEquals(checkboxesPage.getCurrentUrl(), checkboxesPage.getPageUrl());

        checkboxesPage.selectAllCheckboxes();

        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"Not all checkboxes are checked");
        
    }
}
