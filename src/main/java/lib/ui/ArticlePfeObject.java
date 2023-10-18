package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

public class ArticlePfeObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_CREATE_LIST_BUTTON,
            MY_LIST_NAME_INPUT,
            CRATE_MY_LIST_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CLEAR_ARTICLE_BUTTON;

    public ArticlePfeObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot found Title", 5);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getText();
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindsElement(
                    FOOTER_ELEMENT,
                    "Cannot find and of article",
                    40);
        } else {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find and of article",
                    40);
        }
    }

    public void addArticleToMyListAndroid(String name_of_folder) {

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
                CRATE_MY_LIST_BUTTON,
                "Cannot 'OK' button",
                5);
    }

    public void closeArticleAndroid() {
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

    public void addArticleToMyListIOS() {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Save to list button not found",
                5);
    }

    public void closeArticleIOS() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close button",
                20);

        this.waitForElementAndClick(
                CLEAR_ARTICLE_BUTTON,
                "Not found",
                3);
    }
}
