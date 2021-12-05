package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchFiled;

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
}