package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword){
        searchPage.fillSearchFiled(keyword);
        searchPage.pressEnter();
        return new SearchResultSteps();
    }
}