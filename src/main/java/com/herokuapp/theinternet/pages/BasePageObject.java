package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    public  String currentUrl(){
        return driver.getCurrentUrl();
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected String textFrom(By locator) {
        return find(locator).getText() != null ? find(locator).getText() : find(locator).getAttribute("value");
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    protected void type(By locator, String text) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
        timeoutInSeconds = timeoutInSeconds != null ? timeoutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer... timeoutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }


}
