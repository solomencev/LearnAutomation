package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchFiled;

    @FindBy(name = "btnk")
    private WebElement searchButton;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.XDyW0e")
    private WebElement searchByVoiceButton;

    public SearchPage() {
        super();
    }

    public void fillSearchFiled(String text) {
        searchFiled.clear();
        searchFiled.sendKeys(text);
    }

    public void pasteToSearchField(String text){
        pasteTextToElementFromClipboard(searchFiled, text);
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

    public void moveToVoiceSearchButton(){
        builder.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceSearchButtonTooltipContainsText(String text){
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + "was not found]").isNotZero();
    }
}