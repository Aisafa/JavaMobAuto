import lib.CoreTestCase;
import lib.ui.ArticlePfeObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjetFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = ArticlePageObjectFactory.get(driver);
        ArticlePfeObject.waitForTitleElement();
        String article_title = ArticlePfeObject.getArticleTitle();

        assertEquals(
                "Text not equals",
                "Java (programming language)",
                article_title);
    }

    @Test
    public void testSwipeArticleTitle() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePfeObject ArticlePfeObject = ArticlePageObjectFactory.get(driver);
        ArticlePfeObject.waitForTitleElement();
        ArticlePfeObject.swipeToFooter();
    }

}
