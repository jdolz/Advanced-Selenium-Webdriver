package com.herokuapp.theinternet.iFrames;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.IframePage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTests extends TestUtilities {

    @Test
    public void iframeTests() {
        log.info("Starting IframeTests");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        IframePage iframe = welcomePage.clickIframeLink();

        Assert.assertEquals(iframe.getCurrentUrl(), iframe.getPageUrl());

        String editorText = iframe.getEditorText();

        Assert.assertEquals(editorText, "Your content goes here.");


    }
}
