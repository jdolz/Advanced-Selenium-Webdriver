package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLocator = By.xpath("//*[text()='Form Authentication']");
    private By checkboxesLocator = By.xpath("//*[text()='Checkboxes']");
    private By dropdownLocator = By.xpath("//*[text()='Dropdown']");
    private By javascriptAlertsLocator = By.xpath("//*[text()='JavaScript Alerts']");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking form authentication link on Welcome Page");
        click(formAuthenticationLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking checkboxes link on Welcome Page");
        click(checkboxesLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking dropdown link on Welcome Page");
        click(dropdownLocator);
        return new DropdownPage(driver, log);
    }

    public JavaScriptAlertsPage clickJsAlertsLink() {
        log.info("Clicking JsAlerts link on Welcome Page");
        click(javascriptAlertsLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

}
