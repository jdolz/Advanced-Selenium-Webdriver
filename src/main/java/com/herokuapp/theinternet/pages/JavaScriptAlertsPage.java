package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/javascript_alerts";
    private By jsAlertTest = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
    private By jsConfirmTest = By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']");
    private By jsPromptTest = By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']");
    private By resultLocator = By.xpath("//*[@id='result']");

    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void openJsAlert() {
        click(jsAlertTest);
    }

    public void openJsConfirm() {
        click(jsConfirmTest);
    }

    public void openJsPrompt() {
        click(jsPromptTest);
    }

    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        return alertText;
    }

    public void typeTextIntoAlert(String text) {
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        String resultText = textFrom(resultLocator);
        return resultText;
    }

    public void acceptAlert() {
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = switchToAlert();
        alert.dismiss();
    }

}
