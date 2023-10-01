package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePfeObject extends MainPageObject {

    private static final String
            TITLE = "//*[@resource-id='pcs-edit-section-title-description']",
            FOOTER_ELEMENT = "//*[contains(@text,'View article in browser')]",
            OPTIONS_BUTTON = "org.wikipedia:id/page_save",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to another reading list']",
            OPTIONS_CREATE_LIST_BUTTON = "org.wikipedia:id/create_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_SAVED_LIST_BUTTON = "//*[@resource-id='org.wikipedia:id/item_title'][@text='{name_of_folder}']",
            MY_LIST_OK_BUTTON = "android:id/button1",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            CLEAR_ARTICLE_BUTTON = "org.wikipedia:id/search_close_btn";

    public ArticlePfeObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(By.xpath(TITLE), "Cannot found Title", 5);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getText();
    }

    private static String getMySavedListName(String name_of_folder) {
        return MY_SAVED_LIST_BUTTON.replace("{name_of_folder}", name_of_folder);
    }

    public void swipeToFooter() {
        this.swipeUpToFindsElement(
                By.xpath(FOOTER_ELEMENT), "Cannot find and of article", 10);
    }

    public void addArticleToMyNewList(String name_of_folder) {

        this.waitForElementAndClick(
                By.id(OPTIONS_BUTTON),
                "Save to list button not found",
                5);

        this.waitForElementAndClick(
                By.id(OPTIONS_BUTTON),
                "Save to list button not found",
                5);

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot found add list button",
                5
        );

        this.waitForElementAndClick(
                By.id(OPTIONS_CREATE_LIST_BUTTON),
                "Cannot found create new list",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot input field Name ot this list",
                5
        );

        this.waitForElementAndClick(
                By.id(MY_LIST_OK_BUTTON),
                "Cannot 'OK' button",
                5
        );
    }

    public void addArticleToMyExistsList(String name_of_folder) {

        this.waitForElementAndClick(
                By.id(OPTIONS_BUTTON),
                "Save to list button not found",
                5);

        this.waitForElementAndClick(
                By.id(OPTIONS_BUTTON),
                "Save to list button not found",
                5);

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot found add list button",
                5
        );

        String search_result_xpath = getMySavedListName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(search_result_xpath),
                "Cannot found add list button" + name_of_folder,
                5
        );

    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close button",
                20
        );
    }

    public void clearSearchResult() {
        this.waitForElementAndClick(
                By.id(CLEAR_ARTICLE_BUTTON),
                "Not found",
                3
        );
    }

    public void closeArticleAndCloseSearchPage() {
        closeArticle();
        clearSearchResult();

        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close button",
                20
        );
    }

    public void elementShouldBeVisible() {
        this.elementShouldBeVisible(By.xpath("//*[@resource-id='org.wikipedia:id/page_contents_container']"),
                "Title not found");

    }
}
