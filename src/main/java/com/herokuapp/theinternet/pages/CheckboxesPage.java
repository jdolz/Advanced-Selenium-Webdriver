package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/checkboxes";
    private By checkbox = By.xpath("//input[@type='checkboxes']");

    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void selectAllCheckboxes() {
        log.info("Checking all checkboxes");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean areAllCheckboxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

}
