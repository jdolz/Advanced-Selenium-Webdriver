package com.herokuapp.theinternet;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

    //STATIC SLEEP (Explicit)
    protected void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name="files")
    protected static Object[][] files() {
        return new Object[][]{
                {1, "index.html"},
                {2, "logo.png"},
                {3, "text.txt"}
        };
    }

}
