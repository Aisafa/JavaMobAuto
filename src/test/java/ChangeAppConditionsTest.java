import lib.CoreTestCase;
import lib.ui.ArticlePfeObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjetFactory;
import org.junit.Test;

public class ChangeAppConditionsTest extends CoreTestCase {

    @Test
    public void testSearchArticleBackground() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForResult("Java (programming language)");
        this.backgroundApp();
        SearchPageObject.waitForResult("Java (programming language)");
    }

    @Test
    public void testChangeScreenOrientationOnSearchResult() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = ArticlePageObjectFactory.get(driver);
        String titleBeforeRotation = ArticlePfeObject.getArticleTitle();

        this.rotateScreenLandscape();
        String titleAfterRotation = ArticlePfeObject.getArticleTitle();
        assertEquals(
                "not equals",
                titleBeforeRotation,
                titleAfterRotation);

        this.rotateScreenPortrait();
        String titleAfterSecondRotation = ArticlePfeObject.getArticleTitle();
        assertEquals(
                "not equals",
                titleBeforeRotation,
                titleAfterSecondRotation);
    }
}
