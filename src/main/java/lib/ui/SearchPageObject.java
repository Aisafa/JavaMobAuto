package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String

            SEARCH_SKIP = "//*[contains(@text,'Skip')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            SEARCH_RESULT_LOCATOR = "//*[@resource-id='org.wikipedia:id/page_list_item_title']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results']";


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }


    private static String getResultSearchElement(String subString) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", subString);

    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_SKIP), "Cannot find skip button", 5);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking init element", 5);
    }

    public void waitForCancelButtonAndAppear() {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot found close batton", 5);
    }

    public void waitForCancelButtonAndToDisappear() {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot found close button", 5);
    }

    public void waitForSearchResultNotPresent() {
        this.waitForElementNotPresent(By.xpath(SEARCH_RESULT_LOCATOR), "Element exists still", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot found and click close button", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INIT_ELEMENT), search_line, "cannot find field", 5);
    }

    public void waitForResult(String subString) {
        String search_result_xpath = getResultSearchElement(subString);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + subString, 5);
    }

    public void clickByArticleWithSubstring(String subString) {
        String search_result_xpath = getResultSearchElement(subString);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + subString, 5);
    }

    public int getAmountOfArticle() {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_LOCATOR),
                "cannot find results ",
                5
        );
        return this.getAmountsElements(By.xpath(SEARCH_RESULT_LOCATOR));
    }

    public void waitForEmptyResult() {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot found empty text", 5);
    }

    public void assertThereIsNotResultOfSearch() {

        this.assertElementNotPresent(
                By.xpath(SEARCH_RESULT_LOCATOR),
                "We've not found some result  ");
    }
}
