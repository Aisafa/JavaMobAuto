package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();

        this.rotateScreenPortrait();
//        this.skipWelcomePageIosApp();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void backgroundApp() {
        driver.runAppInBackground(Duration.ofSeconds(2));
    }

//    private void skipWelcomePageIosApp() {
//        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
//        WelcomePageObject.clickSkip();
//    }
}