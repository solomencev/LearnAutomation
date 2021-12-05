package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;

import java.io.File;

public abstract class BaseTest {

    private static WebDriver driver;
    SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void SetUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
        driver.get("https://www.google.com/");
        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"selenium"}, {"selenium javascript"}};
    }
}