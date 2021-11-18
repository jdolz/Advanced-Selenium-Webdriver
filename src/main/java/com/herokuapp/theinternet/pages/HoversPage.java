package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoversPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/hovers";
    private By avatarLocator = By.xpath("//*[@class='figure']");
    private By viewProfileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");

    public HoversPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void openUsersProfile(int i) {
        List<WebElement> avatars = findAll(avatarLocator);
        WebElement specificUserAvatar = avatars.get(i - 1);
        hoverOverElement(specificUserAvatar);
        specificUserAvatar.findElement(viewProfileLinkLocator).click();
    }
}
