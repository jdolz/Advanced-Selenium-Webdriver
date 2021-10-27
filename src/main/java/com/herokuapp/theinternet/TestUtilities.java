package com.herokuapp.theinternet;

public class TestUtilities extends BaseTest {

    //STATIC SLEEP (Explicit)
    protected void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
