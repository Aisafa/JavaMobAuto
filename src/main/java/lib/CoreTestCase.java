package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

import java.net.URL;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "iOS";
    private static final String PLATFORM_ANDROID = "Android";

    protected AppiumDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = this.getCapabilitiesPlatformEnv();

        driver = new AndroidDriver(new URL(AppiumUrl), capabilities);
        this.rotateScreenPortrait();
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

    private DesiredCapabilities getCapabilitiesPlatformEnv() throws Exception {

        String platform = System.getenv("platform");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Nexus5");
            capabilities.setCapability("platformVersion", "11.0");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:appPackage", "org.wikipedia");
            capabilities.setCapability("appium:appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/aisafa/JavaMobAuto/JavaAppiumAuto/apks/org.wikipedia.apk");
        } else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("appium:deviceName", "iPhone 15");
            capabilities.setCapability("appium:platformVersion", "17.0");
            capabilities.setCapability("appium:app", "/Users/aisafa/JavaMobAuto/JavaAppiumAuto/apks/wiki.app");
            capabilities.setCapability("appium:automationName", "XCUITest");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value" + platform);
        }
        return capabilities;
    }
}