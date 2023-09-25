package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FirstTest {
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
    public void firstTest() throws InterruptedException {

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found",
                20);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Not found",
                20);
    }

    @Test
    public void testCancelSearch() {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Not found",
                5);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Not found",
                20);

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field ",
                5);

        //        WebElement close_btn = waitForElementAndClick(
        //                By.id("org.wikipedia:id/search_close_btn"),
        //                "Not found",
        //                3
        //        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "X Not found",
                5);
    }

    @Test
    public void testCompareArticleTitle() {
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

        WebElement title_element = waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']//*[@text='Java (programming language)']"),
                "Title Java not found",
                5);

        String text = title_element.getText();

        Assert.assertEquals(
                "Text not equals",
                "Java (programming language)",
                text);

        text.equals("Java");

    }

    @Test
    public void testSwipeArticleTitle() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found",
                3);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Appium",
                "Not found",
                20);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Automation for Apps']"),
                "Not found",
                5);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']"),
                "Title Java not found",
                5);

        swipeUpToFindsElement(
                By.xpath("//*[contains(@text,'View article in browser')]"),
                "Test error message",
                10);

    }

    @Test
    public void saveFirstArticleToMyList() {
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

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']//*[@text='Java (programming language)']"),
                "Title Java not found",
                5);

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save to list button not found",
                5);

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save to list button not found",
                5);

        waitForElementAndClick(
                By.xpath("//*[@text='Add to another reading list']"),
                "Cannot found add list button",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/create_button"),
                "Cannot found create new list",
                5
        );
        String name_of_folder = "Learning programming";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot input field Name ot this list",
                5
        );

        waitForElementAndClick(
                By.id("android:id/button1"),
                "Cannot 'OK' button",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close button",
                20
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Not found",
                3
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close button",
                20
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot found saved(my lists) button",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][@text='"+ name_of_folder + "']"),
                "Cannot find created folder button",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot my created folder",
                5
        );

        swipeElementToLeft(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot swipe to left"
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot my saved article",
                5
        );

    }
    @Test
    public void testAmountOfNotEmptySearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found",
                5);

        String search_line = "Linkin Park Discography";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Not found",
                15);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        waitForElementPresent(
                By.xpath(search_result_locator),
                "cannot find results " + search_line,
                5
        );

        int amounts_of_search_result = getAmountsElements(
                By.xpath(search_result_locator)
        );
        Assert.assertTrue(
                "we found more than 0 result",
                amounts_of_search_result > 0
        );

    }

    @Test

    public void testAmountOfSearch ()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found",
                5);

        String search_line = "Java";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Not found",
                15);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String empty_result_label = "//*[@text='No results']";

        waitForElementPresent(
                By.xpath(empty_result_label),
                "cannot empty label " + search_line,
                10
        );

        assertElementNotPresent(
                By.xpath(search_result_locator),
                "we've found some result" + search_line
        );
    }

    @Test
    public void testSearchArticleBackground()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found",
                3);

        String search_line = "Java";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Not found",
                20);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']" +
                        "//*[@text='Object-oriented programming language']"),
                "Cannot found article",
                5);

        driver.runAppInBackground(2);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']" +
                        "//*[@text='Object-oriented programming language']"),
                "Cannot found article after returning from background",
                5);
    }

    @Test
    public void testChangeScreenOrientationOnSearchResult()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Not found search line",
                3);

        String search_line = "Java";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Not found input for searching",
                20);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']" +
                        "//*[@text='Object-oriented programming language']"),
                "Cannot found article",
                5);

        String titleBeforeRotation = waitForElementAndGetAttribute(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']//*[@text='Java (programming language)']"),
                "Text",
                "Title not found",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String titleAfterRotation = waitForElementAndGetAttribute(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']//*[@text='Java (programming language)']"),
                "Text",
                "Title not found",
                15
        );

        Assert.assertEquals(
                "not equals",
                titleBeforeRotation,
                titleAfterRotation
        );
        driver.rotate(ScreenOrientation.PORTRAIT);

        String titleAfterSecondRotation = waitForElementAndGetAttribute(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']//*[@text='Java (programming language)']"),
                "Text",
                "Title not found",
                15
        );

        Assert.assertEquals(
                "not equals",
                titleBeforeRotation,
                titleAfterSecondRotation
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

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.clear();
        return element;
    }

    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action.
                press(x, start_y).
                waitAction().
                moveTo(x, end_y).
                release().
                perform();
    }

    protected void swipeUpQuick() {
        swipeUp(200);
    }

    protected void swipeUpToFindsElement(By by, String error_message, int max_swipes) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swiped > max_swipes) {
                waitForElementPresent(by, "cannot find element by swipe \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
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

    private int getAmountsElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_elements = getAmountsElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + "supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds )
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getText();

    }
}