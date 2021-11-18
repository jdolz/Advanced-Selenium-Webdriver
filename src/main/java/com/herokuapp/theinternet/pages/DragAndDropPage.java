package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/drag_and_drop";
    private By columnA = By.xpath("//*[@id='column-a']");
    private By columnB = By.xpath("//*[@id='column-b']");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void dragAToB(){
        performDragAndDrop(columnA, columnB);
    }


    public String getColumnAText() {
        return textFrom(columnA);
    }

    public String getColumnBText() {
        return textFrom(columnB);
    }
}
