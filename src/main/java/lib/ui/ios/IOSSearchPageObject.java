package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_SKIP = "xpath://XCUIElementTypeStaticText[@name='Skip']";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "id:Очистить текст";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath:(//XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')])[1]";
        SEARCH_RESULT_LOCATOR = "xpath://XCUIElementTypeStaticText";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='Ничего не найдено']";
        SEARCH_ARTICLE_OF_POSITION = "xpath://android.view.ViewGroup[{POSITION}]";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{TITLE}' or @text='{DESCRIPTION}']";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
