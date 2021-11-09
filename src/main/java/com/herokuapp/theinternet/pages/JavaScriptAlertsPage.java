package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/javascript_alerts";
    private By jsAlertTest = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
    private By jsConfirmTest = By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']");
    private By jsPromptTest = By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']");


    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void openJsAlert(){
        click(jsAlertTest);
    }

    


}
