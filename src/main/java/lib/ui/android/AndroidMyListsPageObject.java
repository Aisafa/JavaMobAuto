package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class AndroidMyListsPageObject extends MyListPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE = "id:org.wikipedia:id/page_list_item_container";
    }

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
