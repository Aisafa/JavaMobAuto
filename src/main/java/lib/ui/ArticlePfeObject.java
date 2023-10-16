package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePfeObject extends MainPageObject {

    private static final String
            TITLE = "xpath://*[@resource-id='pcs-edit-section-title-description']",
            FOOTER_ELEMENT = "xpath://*[contains(@text,'View article in browser')]",
            OPTIONS_BUTTON = "id:org.wikipedia:id/page_save",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to another reading list']",
            OPTIONS_CREATE_LIST_BUTTON = "id:org.wikipedia:id/create_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "id:android:id/button1",
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            CLEAR_ARTICLE_BUTTON = "id:org.wikipedia:id/search_close_btn";

    public ArticlePfeObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot found Title", 5);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getText();
    }

    public void swipeToFooter() {
        this.swipeUpToFindsElement(
                FOOTER_ELEMENT,
                "Cannot find and of article",
                10);
    }

    public void addArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Save to list button not found",
                5);

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Save to list button not found",
                5);

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot found add list button",
                5);

        this.waitForElementAndClick(
                OPTIONS_CREATE_LIST_BUTTON,
                "Cannot found create new list",
                5);

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot input field Name ot this list",
                5);

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot 'OK' button",
                5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close button",
                20);

        this.waitForElementAndClick(
                CLEAR_ARTICLE_BUTTON,
                "Not found",
                3);

        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close button",
                20);
    }
}
