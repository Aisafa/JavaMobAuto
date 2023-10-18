import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjetFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() throws InterruptedException {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonAndAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonAndToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);

        int amounts_of_search_result = SearchPageObject.getAmountOfArticle();
        assertTrue(
                "we found more than 0 result",
                amounts_of_search_result > 0);
    }

    @Test
    public void testAmountOfEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjetFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "HFBS43%^VSV";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResult();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }
}