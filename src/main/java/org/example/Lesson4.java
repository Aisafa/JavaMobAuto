package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Lesson4 {


    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nexus5");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "Users/aisafa/JavaMobAuto/JavaAppiumAuto/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Not found",
                20);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSaveTwoArticlesToMyList() {

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot found search line",
                2);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot found search line input field",
                2);

        waitForElementAndClick(
                By.xpath("//android.view.ViewGroup[2]"),
                "Cannon found article search results",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save to list button not found",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save to list button not found",
                2);

        waitForElementAndClick(
                By.xpath("//*[@text='Add to another reading list']"),
                "Cannot found add list button",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/create_button"),
                "Cannot found create new list",
                2);

        String name_of_folder = "Learning programming";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot input field Name ot this list",
                2);

        waitForElementAndClick(
                By.id("android:id/button1"),
                "Cannot 'OK' button",
                2);

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close button",
                2);

        waitForElementAndClick(
                By.xpath("//android.view.ViewGroup[3]"),
                "Cannon found article search results",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save to list button not found",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save to list button not found",
                2);

        waitForElementAndClick(
                By.xpath("//*[@text='Add to another reading list']"),
                "Cannot found add list button",
                2);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][@text='" + name_of_folder + "']"),
                "Cannot find created folder button",
                2);


        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close button",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Not found",
                2);

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close button",
                2);

        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot found saved(my lists) button",
                2);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][@text='" + name_of_folder + "']"),
                "Cannot find created folder button",
                2);

        waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot my created folder",
                2);

        swipeElementToLeft(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='JavaScript']"),
                "Cannot swipe to left");

        waitForElementAndClick(
                By.id("org.wikipedia:id/touch_outside"),
                "Cannon found article",
                2);

        waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot my created folder",
                2);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][1]"),
                "Cannon found article",
                2);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']" +
                        "//*[@text='Java (programming language)']"),
                "Title not found",
                2);
    }

    @Test
    public void testAssertTitle() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found",
                3);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Not found",
                20);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']" +
                        "//*[@text='Object-oriented programming language']"),
                "Not fund",
                5);

        elementShouldBeVisible(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']"),
                "Title not found"
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.sendKeys(value);
        return element;
    }

    protected void swipeElementToLeft(By by, String error_message) {
        RemoteWebElement carousel = (RemoteWebElement) waitForElementPresent(
                by,
                error_message,
                15);

        driver.executeScript("gesture: swipe", Map.of(
                "elementId",
                carousel.getId(),
                "percentage",
                60,
                "direction",
                "left"));
    }

    private void elementShouldBeVisible(By by, String error_message)
    {
        driver.findElement(by);
        ExpectedConditions.presenceOfElementLocated(by);
    }
}
