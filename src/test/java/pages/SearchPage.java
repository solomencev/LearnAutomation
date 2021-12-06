package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchFiled;

    @FindBy(name = "btnk")
    private WebElement searchButton;

    public SearchPage() {
        super();
    }

    public void fillSearchFiled(String text) {
        searchFiled.clear();
        searchFiled.sendKeys(text);
    }

    public void pressEnter() {
        searchFiled.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonorPressEnter() throws InterruptedException {
        if(isElementFound(By.name("btnk"), 3)){
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
        }
        else {
            pressEnter();
        }
    }
}