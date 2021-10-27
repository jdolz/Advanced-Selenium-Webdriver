package com.herokuapp.theinternet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;


public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        String testName = context.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser, log);

        driver = driverFactory.createDriver();

        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}

