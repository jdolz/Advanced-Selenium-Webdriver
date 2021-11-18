package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/tinymce";
    private By editorLocator = By.xpath("//*[@id='tinymce']");
    private By frame = By.tagName("iframe");

    public IframePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String getEditorText() {
        switchToFrame(frame);
        String text = textFrom(editorLocator);
        return text;
    }
}
