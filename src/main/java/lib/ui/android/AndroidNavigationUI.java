package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

    static {
        MY_LISTS_LINK = "id:org.wikipedia:id/nav_tab_reading_lists";
        OPTION_OUTSIDE = "org.wikipedia:id/touch_outside";
    }

    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
