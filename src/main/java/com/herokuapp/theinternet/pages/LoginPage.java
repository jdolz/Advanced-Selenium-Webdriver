package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/login";

    private By usernameLocator = By.xpath("//*[@id = 'username']");
    private By passwordLocator = By.xpath("//*[@id = 'password']");
    private By logInButtonLocator = By.xpath("//*[@class = 'radius' and @type = 'submit']");
    private By messageLocator = By.id("flash");


    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(usernameLocator, username);
        type(passwordLocator, password);
        waitFor(ExpectedConditions.elementToBeClickable(logInButtonLocator),10);
        click(logInButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public String getMessage() {
        waitForVisibilityOf(messageLocator,5);
        return textFrom(messageLocator);
    }
}
