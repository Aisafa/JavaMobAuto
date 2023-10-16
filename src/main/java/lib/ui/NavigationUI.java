package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject {

    private static final String
        MY_LISTS_LINK = "id:org.wikipedia:id/nav_tab_reading_lists";


    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot found saved(my lists) button",
                5
        );
    }
}
