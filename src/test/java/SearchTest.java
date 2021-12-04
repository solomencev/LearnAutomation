import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;

public class SearchTest {

    @Test
    public void TestOpenGoogleInChrome(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.cssSelector("input[name='q']"));
        searchField.clear();
        searchField.sendKeys("selenium webdriver");
        searchField.sendKeys(Keys.RETURN);
        WebElement resultRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        assertThat(resultRow.isDisplayed()).as("Element is not displayed").isTrue();
        assertThat(resultRow.getText()).as("Wrong text is displayed").isEqualTo("WebDriver | Selenium");
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute is displayed").contains("LC20lb MBeuO DKV0Md");
        driver.quit();
    }
}