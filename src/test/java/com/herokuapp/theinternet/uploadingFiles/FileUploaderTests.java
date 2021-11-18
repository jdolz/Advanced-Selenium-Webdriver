package com.herokuapp.theinternet.uploadingFiles;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTests extends TestUtilities {

    @Test
    public void fileUploaderTests() {
        log.info("Starting FileUploaderTests");

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        FileUploaderPage fileUploader = welcomePage.clickFileUploaderLink();

        Assert.assertEquals(fileUploader.getCurrentUrl(), fileUploader.getPageUrl());

        fileUploader.selectFile("meme.png");

        fileUploader.pushUploadButton();

        String editorText = fileUploader.getUploadedFilesNames();

        Assert.assertEquals(editorText, "meme.png");


    }
}
