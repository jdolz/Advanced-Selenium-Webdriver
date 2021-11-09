package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/windows";
    private By clickHereLocator = By.xpath("//*[text()='Click Here']");

    public WindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void openNewWindow() {
        click(clickHereLocator);
    }

    public NewWindowPage switchToNewWindowPage() {
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);
    }
}
