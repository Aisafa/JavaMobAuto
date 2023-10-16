package iOS;

import lib.iOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStarterTest extends iOSTestCase {

    @Test
    public void testPassThroughWelcome() {

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNext();
        WelcomePage.waitForNewWaysText();
        WelcomePage.clickNext();
        WelcomePage.clickNext();
        WelcomePage.clickGetStartedButton();

    }
}
