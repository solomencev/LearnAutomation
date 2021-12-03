import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {

    @Test
    public void TestOpenYouTubeInIE(){
        File file = new File("src/test/resources/");
        System.setProperty("webdriver.chrome.driver", "D:/LearnAutomation/src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}