package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SlidersPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/horizontal_slider";

    private By rangeLocator = By.id("range");
    private By sliderLocator = By.tagName("input");


    public SlidersPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setSliderTo(String value) {

        int steps = (int) (Double.parseDouble(value) / 0.5);

        pressKey(sliderLocator, Keys.ENTER);
        for (int i = 0; i < steps; i++) {
            pressKey(sliderLocator, Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue(){
        return textFrom(rangeLocator);
    }

}
