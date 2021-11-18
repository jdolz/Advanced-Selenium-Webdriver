package com.herokuapp.theinternet.iFrames;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.IframePage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTests extends TestUtilities {

    @Test
    public void iframeTests() {
        log.info("Starting IframeTests");

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        welcomePage.scrollToBottom();

        IframePage iframe = welcomePage.clickIframeLink();

        Assert.assertEquals(iframe.getCurrentUrl(), iframe.getPageUrl());

        String editorText = iframe.getEditorText();

        Assert.assertEquals(editorText, "Your content goes here.");


    }
}
