package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.pasteToSearchField(keyword);
        searchPage.clickSearchButtonorPressEnter();
        return new SearchResultSteps();
    }

    public SearchSteps openTooltip(){
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text){
        searchPage.assertThatVoiceSearchButtonTooltipContainsText(text);
        return this;
    }

}