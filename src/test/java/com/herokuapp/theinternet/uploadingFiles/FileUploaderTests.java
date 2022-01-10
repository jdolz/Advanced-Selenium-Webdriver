package com.herokuapp.theinternet.uploadingFiles;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTests extends TestUtilities {

    @Test(dataProvider ="files")
    public void fileUploaderTests(int testNum, String fileName) {
        log.info("Starting FileUploaderTests number: " + testNum);

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        FileUploaderPage fileUploader = welcomePage.clickFileUploaderLink();

        Assert.assertEquals(fileUploader.getCurrentUrl(), fileUploader.getPageUrl());

        fileUploader.selectFile(fileName);

        fileUploader.pushUploadButton();

        String editorText = fileUploader.getUploadedFilesNames();

        Assert.assertEquals(editorText, fileName);


    }
}
