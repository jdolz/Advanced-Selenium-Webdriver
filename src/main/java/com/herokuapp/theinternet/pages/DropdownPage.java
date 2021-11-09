package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/dropdown";
    private By selectLocator = By.xpath("//*[@id='dropdown']");
    private String optionLocator = "//*[@id='dropdown']/option[@value='{}']";

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void selectOption(int option) {
        log.info("Running selectOption");
//        click(selectLocator);
//        click(By.xpath(optionLocator.replace("{}", String.valueOf(option))));
        WebElement dropdownElement = find(selectLocator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(String.valueOf(option));
    }

    public boolean isOptionSelected(int option) {
        log.info("Running isOptionSelected");
        WebElement dropdownElement = find(selectLocator);
        Select dropdown = new Select(dropdownElement);
        dropdown.getFirstSelectedOption().getText();

        return find(By.xpath(optionLocator.replace("{}", String.valueOf(option)))).isSelected();
    }
}
