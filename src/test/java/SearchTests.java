import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() throws InterruptedException {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForResult("Object-oriented programming language");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonAndAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonAndToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
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

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "HFBS43%^VSV";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResult();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }

    //Ex3.
    @Test
    public void testCancelSearchSeveralResults() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);

        int amounts_of_search_result = SearchPageObject.getAmountOfArticle();
        assertTrue(
                "we found more than 0 result",
                amounts_of_search_result > 0);

        SearchPageObject.waitForCancelButtonAndAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchResultNotPresent();
    }
}