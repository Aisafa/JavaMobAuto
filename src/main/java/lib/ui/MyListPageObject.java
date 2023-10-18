package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListPageObject extends MainPageObject {

    public MyListPageObject(AppiumDriver driver) {
        super(driver);
    }

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE,
            CLOSE_MODAL_WINDOW,
            DELETE_BUTTON,
            UNSAVE_BUTTON;

    private static String getFolderXpathByNAme(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE.replace("{ARTICLE_BY_TITLE}", article_title);
    }

    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByNAme(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find created folder button",
                5);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find my saved article",
                5);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "my saved article is located",
                5);
    }

    public void swipeByArticleToDelete(String article_title) {
        if (Platform.getInstance().isAndroid()) {
            String article_xpath = getSavedArticleXpathByTitle(article_title);
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article");
        } else {
            String article_xpath = getSavedArticleXpathByTitle(article_title);
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article");

            this.clickElementToDeleteButton(
                    DELETE_BUTTON,
                    "Cannot find delete button",
                    5);
        }
    }

    public void closeModalWindow() {
        this.waitForElementAndClick(
                CLOSE_MODAL_WINDOW,
                "cannot found modal window",
                5);
    }
}