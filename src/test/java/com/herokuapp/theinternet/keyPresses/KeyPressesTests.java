package com.herokuapp.theinternet.keyPresses;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {

    @Test
    public void keyPressesTests() {
        log.info("Starting KeyPressesTests");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        KeyPressesPage keyPresses = welcomePage.clickKeyPressesLink();

        Assert.assertEquals(keyPresses.getCurrentUrl(), keyPresses.getPageUrl());

        keyPresses.pressKey(Keys.ENTER);

        String pressedKey = keyPresses.getResultText();

        Assert.assertEquals(pressedKey, "You entered: ENTER");

    }

    @Test
    public void keyPressesWithActionsTests() {
        log.info("Starting KeyPressesTests");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        KeyPressesPage keyPresses = welcomePage.clickKeyPressesLink();

        Assert.assertEquals(keyPresses.getCurrentUrl(), keyPresses.getPageUrl());

        keyPresses.pressKeyWithActions(Keys.SPACE);

        String pressedKey = keyPresses.getResultText();

        Assert.assertEquals(pressedKey, "You entered: SPACE");

    }
}
