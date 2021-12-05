package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']//h3")
    private WebElement ResultRow;

    public SearchResultPage() {
        super();
    }

    public void AssertThatTopResultContainsCorrectText(String expected) {
        assertThat(ResultRow.isDisplayed()).as("Element is not displayed").isTrue();
        assertThat(ResultRow.getText()).as("Wrong text is displayed").isEqualTo(expected);
    }

    public void AssertThatTopResultContainsCorrectProperAttributeText(String expected) {
        assertThat(ResultRow.getAttribute("class")).as("Wrong attribute is displayed").contains(expected);
    }
}