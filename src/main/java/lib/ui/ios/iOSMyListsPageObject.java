package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class iOSMyListsPageObject extends MyListPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://XCUIElementTypeStaticText[@name='{FOLDER_NAME}']";
        ////XCUIElementTypeStaticText[@name="Sd"]
        ARTICLE_BY_TITLE = "xpath://XCUIElementTypeStaticText[@name='{ARTICLE_BY_TITLE}']";
        CLOSE_MODAL_WINDOW = "xpath://XCUIElementTypeButton[@name='Close']";
        DELETE_BUTTON = "xpath://XCUIElementTypeButton[@name='swipe action delete']";
        UNSAVE_BUTTON = "id:Unsave";
    }

    public iOSMyListsPageObject(AppiumDriver driver){
        super(driver);
    }
}
