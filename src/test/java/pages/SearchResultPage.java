package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {
    private By ResultRow = By.xpath("//div[@class='g']//h3");

    public SearchResultPage() {
        super();
    }

    public void AssertThatTopResultContainsCorrectText(String expected) {
        WebElement resultRowElement = driver.findElement(ResultRow);
        assertThat(resultRowElement.isDisplayed()).as("Element is not displayed").isTrue();
        assertThat(resultRowElement.getText()).as("Wrong text is displayed").isEqualTo(expected);

    }

    public void AssertThatTopResultContainsCorrectProperAttributeText(String expected) {
        WebElement resultRowElement = driver.findElement(ResultRow);
        assertThat(resultRowElement.getAttribute("class")).as("Wrong attribute is displayed").contains(expected);

    }
}