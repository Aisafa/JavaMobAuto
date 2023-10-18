package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePfeObject;

public class AndroidArticlePageObject extends ArticlePfeObject {

    static {
        TITLE = "xpath://*[@resource-id='pcs-edit-section-title-description']";
        FOOTER_ELEMENT = "xpath://*[contains(@text,'View article in browser')]";
        OPTIONS_BUTTON = "id:org.wikipedia:id/page_save";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to another reading list']";
        OPTIONS_CREATE_LIST_BUTTON = "id:org.wikipedia:id/create_button";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        CRATE_MY_LIST_BUTTON = "id:android:id/button1";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        CLEAR_ARTICLE_BUTTON = "id:org.wikipedia:id/search_close_btn";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

}
