package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/secure";

    private By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
    private By messageLocator = By.id("flash");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isLogOutButtonVisible() {
        return isDisplayed(logOutButtonLocator);
    }

    public String getMessage() {
        return textFrom(messageLocator);
    }
}
