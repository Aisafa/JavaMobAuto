package lib.ui;

import io.appium.java_client.AppiumDriver;

public class SearchPageObject extends MainPageObject {

    private static final String

            SEARCH_SKIP = "xpath://*[contains(@text,'Skip')]",
            SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
            SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            SEARCH_RESULT_LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']",
            SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results']",
            SEARCH_ARTICLE_OF_POSITION =  "xpath://android.view.ViewGroup[{POSITION}]",
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{TITLE}' or @text='{DESCRIPTION}']";


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }


    protected static String getResultSearchElement(String subString) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", subString);
    }

    private static String getElementPositionFromSearchResult(String position) {
        return SEARCH_ARTICLE_OF_POSITION.replace("{POSITION}", position);
    }

    protected static String getTitleAndDescriptionElement(String title, String description) {
        return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL.replace("{TITLE}", title).replace("{DESCRIPTION}", description);
    }

    public void waitForElementByTitleAndDescription (String title, String description) {
        String search_result_xpath = getTitleAndDescriptionElement(title, description);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title ana description " + title, 5) ;
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_SKIP, "Cannot find skip button", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking init element", 5);
    }

    public void waitForCancelButtonAndAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot found close batton", 5);
    }

    public void waitForCancelButtonAndToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Cannot found close button", 5);
    }

    public void waitForSearchResultNotPresent() {
        this.waitForElementNotPresent(SEARCH_RESULT_LOCATOR, "Element exists still", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot found and click close button", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INIT_ELEMENT, search_line, "cannot find field", 5);
    }

    public void waitForResult(String subString) {
        String search_result_xpath = getResultSearchElement(subString);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search result with substring " + subString, 5);
    }

    public void clickByArticleWithSubstring(String subString) {
        String search_result_xpath = getResultSearchElement(subString);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search result with substring " + subString, 5);
    }

    public void clickByArticleOfPosition(String position) {
        String search_result_xpath = getElementPositionFromSearchResult(position);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + position, 5);
    }

    public int getAmountOfArticle() {
        this.waitForElementPresent(
                SEARCH_RESULT_LOCATOR,
                "cannot find results ",
                5
        );
        return this.getAmountsElements(SEARCH_RESULT_LOCATOR);
    }

    public void waitForEmptyResult() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot found empty text", 5);
    }

    public void assertThereIsNotResultOfSearch() {

        this.assertElementNotPresent(
                SEARCH_RESULT_LOCATOR,
                "We've not found some result  ");
    }
}
