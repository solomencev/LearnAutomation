package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='v7W49e']//div[@class='g']//h3")
    private WebElement ResultRow;

    @FindBy(xpath = "//div[@class='hlcw0c']//div[@class='g']//h3")
    private List<WebElement> ResultRows;

    public SearchResultPage() {
        super();
    }

    public void AssertThatTopResultContainsCorrectText(String expected) {
        wait.until(ExpectedConditions.visibilityOfAllElements(ResultRows));
        assertThat(ResultRows.stream().map(e->e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text is displayed").contains(expected);
    }

    public void AssertThatTopResultContainsCorrectProperAttributeText(String expected) {
        assertThat(ResultRow.getAttribute("class")).as("Wrong attribute is displayed").contains(expected);
    }
}