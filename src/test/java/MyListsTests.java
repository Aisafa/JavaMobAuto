import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePfeObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjetFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = ArticlePageObjectFactory.get(driver);
        ArticlePfeObject.waitForTitleElement();
        String article_title = ArticlePfeObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            ArticlePfeObject.addArticleToMyListAndroid(name_of_folder);
        } else {
            ArticlePfeObject.addArticleToMyListIOS();
        }
        if (Platform.getInstance().isAndroid()){
            ArticlePfeObject.closeArticleAndroid();
        } else {
            ArticlePfeObject.closeArticleIOS();
        }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
            MyListPageObject.waitForArticleToAppearByTitle(article_title);
            MyListPageObject.swipeByArticleToDelete(article_title);
            MyListPageObject.waitForArticleToDisappearByTitle(article_title);
        } else {
            MyListPageObject.closeModalWindow();
            MyListPageObject.waitForArticleToAppearByTitle(article_title);
            MyListPageObject.swipeByArticleToDelete(article_title);
            MyListPageObject.waitForArticleToDisappearByTitle(article_title);
        }
    }
}
