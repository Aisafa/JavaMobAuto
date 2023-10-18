import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStarterTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {

        if (Platform.getInstance().isAndroid()) {
            return;
        }

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNext();
        WelcomePage.waitForNewWaysText();
        WelcomePage.clickNext();
        WelcomePage.clickNext();
        WelcomePage.clickGetStartedButton();
    }
}
