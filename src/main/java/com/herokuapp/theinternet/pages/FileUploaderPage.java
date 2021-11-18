package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/upload";
    private By choseFileFieldLocator = By.xpath("//*[@id='file-upload']");
    private By uploadButtonLocator = By.xpath("//*[@id='file-submit']");
    private By uploadedFilesLocator = By.xpath("//*[@id='uploaded-files']");


    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void pushUploadButton() {
        click(uploadButtonLocator);
    }

    public void selectFile(String fileName) {
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(choseFileFieldLocator, filePath);
    }

    public String getUploadedFilesNames(){
        String names = textFrom(uploadedFilesLocator);
        return names;
    }
}
