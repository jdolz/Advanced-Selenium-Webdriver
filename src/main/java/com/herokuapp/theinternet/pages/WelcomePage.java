package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLocator = By.xpath("//*[text()='Form Authentication']");
    private By checkboxesLocator = By.xpath("//*[text()='Checkboxes']");
    private By dropdownLocator = By.xpath("//*[text()='Dropdown']");
    private By javascriptAlertsLocator = By.xpath("//*[text()='JavaScript Alerts']");
    private By multipleWindowsLocator = By.xpath("//*[text()='Multiple Windows']");
    private By iframeLocator = By.xpath("//*[text()='WYSIWYG Editor']");
    private By keyPressesLocator = By.xpath("//*[text()='Key Presses']");
    private By fileUploaderLocator = By.xpath("//*[text()='File Upload']");
    private By dragAndDropLocator = By.xpath("//*[text()='Drag and Drop']");
    private By hoversLocator = By.xpath("//*[text()='Hovers']");
    private By slidersLocator = By.xpath("//*[text()='Horizontal Slider']");


    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking form authentication link on Welcome Page");
        click(formAuthenticationLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking checkboxes link on Welcome Page");
        click(checkboxesLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking dropdown link on Welcome Page");
        click(dropdownLocator);
        return new DropdownPage(driver, log);
    }

    public JavaScriptAlertsPage clickJsAlertsLink() {
        log.info("Clicking JsAlerts link on Welcome Page");
        click(javascriptAlertsLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLocator);
        return new WindowsPage(driver, log);
    }

    public IframePage clickIframeLink() {
        log.info("Clicking iframe link on Welcome Page");
        click(iframeLocator);
        return new IframePage(driver, log);
    }

    public KeyPressesPage clickKeyPressesLink() {
        log.info("Clicking keyPresses link on Welcome Page");
        click(keyPressesLocator);
        return new KeyPressesPage(driver, log);
    }

    public FileUploaderPage clickFileUploaderLink() {
        log.info("Clicking fileUploader link on Welcome Page");
        click(fileUploaderLocator);
        return new FileUploaderPage(driver, log);
    }

    public DragAndDropPage clickDragAndDropLink() {
        log.info("Clicking dragAndDrop link on Welcome Page");
        click(dragAndDropLocator);
        return new DragAndDropPage(driver, log);
    }

    public HoversPage clickHoversLink() {
        log.info("Clicking hovers link on Welcome Page");
        click(hoversLocator);
        return new HoversPage(driver, log);
    }

    public SlidersPage clickSlidersLink() {
        log.info("Clicking sliders link on Welcome Page");
        click(slidersLocator);
        return new SlidersPage(driver, log);
    }

}
