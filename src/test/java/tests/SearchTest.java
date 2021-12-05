package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {


    @Test(dataProvider = "dataProvider")
    public void TestOpenGoogleInChrome1(String text) {
        SearchPage searchPage = new SearchPage();
        searchPage.fillSearchFiled(text);
        searchPage.pressEnter();

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.AssertThatTopResultContainsCorrectText("Selenium");
        searchResultPage.AssertThatTopResultContainsCorrectProperAttributeText("LC20lb MBeuO DKV0Md");
    }
}