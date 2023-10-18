package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            MY_LISTS_LINK,
            OPTION_OUTSIDE;


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

    public void clickOutside() {
        waitForElementAndClick(
                OPTION_OUTSIDE,
                "Cannon found article",
                2);
    }
}

