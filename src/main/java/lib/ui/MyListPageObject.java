package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject {

    public MyListPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            FOLDER_BY_NAME_TPL = "//*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE = "org.wikipedia:id/page_list_item_container",
            ARTICLE_BY_TITLE_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{SUBSTRING}']";

    private static String getFolderXpathByNAme(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    protected static String getResultSearchElement(String subString) {
        return ARTICLE_BY_TITLE_SUBSTRING_TPL.replace("{SUBSTRING}", subString);
    }

    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByNAme(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "Cannot find created folder button",
                5
        );
    }

    public void openSavedArticle(String subString) {
        String search_result_xpath = getResultSearchElement(subString);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot  click my saved article " + subString, 5);
    }

    public void waitForArticleToAppearByTitle() {
        this.waitForElementPresent(
                By.id(ARTICLE_BY_TITLE),
                "Cannot my saved article",
                5
        );
    }

    public void waitForArticleToDisappearByTitle() {
        this.waitForElementNotPresent(
                By.id(ARTICLE_BY_TITLE),
                "Cannot my saved article",
                5
        );
    }

    public void swipeByArticleToDelete(String subString) {
        String search_result_xpath = getResultSearchElement(subString);
        this.swipeElementToLeft(By.xpath(search_result_xpath),
                "Cannot swipe to left");
    }

}
