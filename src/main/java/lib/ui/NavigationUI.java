package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String
        MY_LISTS_LINK = "org.wikipedia:id/nav_tab_reading_lists",
        OPTION_OUTSIDE = "org.wikipedia:id/touch_outside";


    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                By.id(MY_LISTS_LINK),
                "Cannot found saved(my lists) button",
                5
        );
    }

    public void clickOutside() {
    waitForElementAndClick(
            By.id(OPTION_OUTSIDE),
            "Cannon found article",
            2);
}
}
