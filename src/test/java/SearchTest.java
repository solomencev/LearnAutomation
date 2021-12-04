import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

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
        assertTrue(resultRow.isDisplayed(), "Element is not displayed");
        assertEquals(resultRow.getText(), "WebDriver | Selenium", "Wrong text is displayed");
        assertEquals(resultRow.getAttribute("class"), "LC20lb MBeuO DKV0Md", "Wrong attribute is displayed");
        driver.quit();
    }
}