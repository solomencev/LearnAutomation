import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {


    @Test(dataProvider = "dataProvider")
    public void TestOpenGoogleInChrome1(String text) {
        WebElement searchField = driver.findElement(By.cssSelector("input[name='q']"));
        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
        WebElement resultRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        assertThat(resultRow.isDisplayed()).as("Element is not displayed").isTrue();
        assertThat(resultRow.getText()).as("Wrong text is displayed").isEqualTo("Пишем автотест с использованием Selenium Webdriver");
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute is displayed").contains("LC20lb MBeuO DKV0Md");
    }
}