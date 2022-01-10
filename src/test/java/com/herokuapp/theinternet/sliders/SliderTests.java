package com.herokuapp.theinternet.sliders;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.SlidersPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTests extends TestUtilities {

    @Test
    public void sliderTests() {
        log.info("Starting SliderTests");

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        SlidersPage slidersPage = welcomePage.clickSlidersLink();

        Assert.assertEquals(slidersPage.getCurrentUrl(), slidersPage.getPageUrl());

        String value = "3.5";

        slidersPage.setSliderTo(value);

        String sliderValue = slidersPage.getSliderValue();
        Assert.assertTrue(sliderValue.equals(value), "Range not correct");

    }
}
