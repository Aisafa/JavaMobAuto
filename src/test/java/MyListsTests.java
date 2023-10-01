import lib.CoreTestCase;
import lib.ui.ArticlePfeObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = new ArticlePfeObject(driver);
        ArticlePfeObject.waitForTitleElement();
        String article_title = ArticlePfeObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePfeObject.addArticleToMyList(name_of_folder);
        ArticlePfeObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete();
        MyListPageObject.waitForArticleToDisappearByTitle();

    }

}
