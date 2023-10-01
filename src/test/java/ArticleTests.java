import lib.CoreTestCase;
import lib.ui.ArticlePfeObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = new ArticlePfeObject(driver);
        ArticlePfeObject.waitForTitleElement();
        String article_title = ArticlePfeObject.getArticleTitle();

        assertEquals(
                "Text not equals",
                "Object-oriented programming language",
                article_title);
    }

    @Test
    public void testSwipeArticleTitle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        ArticlePfeObject ArticlePfeObject = new ArticlePfeObject(driver);
        ArticlePfeObject.waitForTitleElement();
        ArticlePfeObject.swipeToFooter();
    }

    /*EX:6*/
    @Test
    public void testAssertTitle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = new ArticlePfeObject(driver);
        String article_title = ArticlePfeObject.getArticleTitle();
        ArticlePfeObject.elementShouldBeVisible();
    }
}
