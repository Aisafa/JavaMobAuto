package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePfeObject;

public class iOSArticlePageObject extends ArticlePfeObject {

    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='View article in browser']";
        OPTIONS_BUTTON = "id:Save for later";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Add “Java (programming language)” to a reading list?']";
        OPTIONS_CREATE_LIST_BUTTON = "name:Create a new list";
        MY_LIST_NAME_INPUT = "id:Reading list name";
        CRATE_MY_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        CLEAR_ARTICLE_BUTTON = "id:Cancel";
    }

    public iOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
