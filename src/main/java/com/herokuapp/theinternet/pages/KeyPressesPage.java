package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/key_presses";
    private By body = By.xpath("//body");
    private By resultTextLocator = By.xpath("//*[@id='result']");

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void pressKey(Keys key) {
        pressKey(body, key);
    }

    public String getResultText() {
        String text = textFrom(resultTextLocator);
        return text;
    }
}
