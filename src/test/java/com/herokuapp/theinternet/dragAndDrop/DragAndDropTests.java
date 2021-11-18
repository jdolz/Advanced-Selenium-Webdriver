package com.herokuapp.theinternet.dragAndDrop;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAndDropTests() {
        log.info("Starting DragAndDropTests");

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        DragAndDropPage dragAndDrop = welcomePage.clickDragAndDropLink();

        Assert.assertEquals(dragAndDrop.getCurrentUrl(), dragAndDrop.getPageUrl());

        dragAndDrop.dragAToB();

        String columnAText = dragAndDrop.getColumnAText();
        Assert.assertEquals(columnAText, "B");

        String columnBText = dragAndDrop.getColumnBText();
        Assert.assertEquals(columnBText, "A");
    }
}
