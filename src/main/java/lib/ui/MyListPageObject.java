package lib.ui;

import io.appium.java_client.AppiumDriver;

public class MyListPageObject extends MainPageObject {

    public MyListPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            FOLDER_BY_NAME_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE = "id:org.wikipedia:id/page_list_item_container";

    private static String getFolderXpathByNAme(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByNAme(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find created folder button",
                5);
    }

    public void waitForArticleToAppearByTitle() {
        this.waitForElementPresent(
                ARTICLE_BY_TITLE,
                "Cannot my saved article",
                5);
    }

    public void waitForArticleToDisappearByTitle() {
        this.waitForElementNotPresent(
                ARTICLE_BY_TITLE,
                "Cannot my saved article",
                5);
    }

    public void swipeByArticleToDelete() {
        this.swipeElementToLeft(
                ARTICLE_BY_TITLE,
                "Cannot swipe to left");
    }
}