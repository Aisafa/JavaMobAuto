package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {


    private static final String
    STEP_LEARN_MORE_LINK = "id:Свободная энциклопедия",
    STEP_NEW_WAYS_LINK = "id:Новые способы изучения",
    NEXT_BUTTON = "name:Далее",
    START_BUTTON = "name:Начать";


    public WelcomePageObject(AppiumDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Свободная'", 5);
    }

    public void waitForNewWaysText(){
        this.waitForElementPresent(STEP_NEW_WAYS_LINK, "Cannot find Способы изучения", 5);
    }

    public void clickNext(){
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find and click Next", 5);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(START_BUTTON, "Cannot find and click start", 5);
    }
}
