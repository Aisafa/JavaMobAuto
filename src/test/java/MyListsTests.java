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
        String name_of_folder = "Learning programming";
        ArticlePfeObject.addArticleToMyNewList(name_of_folder);
        ArticlePfeObject.closeArticleAndCloseSearchPage();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete("1");
        MyListPageObject.waitForArticleToDisappearByTitle();
    }

    /*EX5*/
    @Test
    public void testSaveTwoArticlesToMyList() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePfeObject ArticlePfeObject = new ArticlePfeObject(driver);
        ArticlePfeObject.waitForTitleElement();
        String article_title1 = ArticlePfeObject.getArticleTitle();

        String name_of_folder = "Learning programming";
        ArticlePfeObject.addArticleToMyNewList(name_of_folder);
        ArticlePfeObject.closeArticle();

        SearchPageObject.clickByArticleOfPosition("3");
        String article_title_2 = ArticlePfeObject.getArticleTitle();

        ArticlePfeObject.addArticleToMyExistsList(name_of_folder);
        ArticlePfeObject.closeArticleAndCloseSearchPage();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title1);

        NavigationUI.clickOutside();

        MyListPageObject.waitForArticleToAppearByTitle();
        MyListPageObject.openSavedArticle(article_title_2);

        String actual_article_title = ArticlePfeObject.getArticleTitle();

        assertEquals(
                "Text not equals",
                article_title_2,
                actual_article_title);
    }
}
