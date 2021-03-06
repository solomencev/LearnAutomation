package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


    @Test(dataProvider = "dataProvider")
    public void TestOpenGoogleInChrome1(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Selenium")
                .verifyThatTopResultContainsProperAttributeText("LC20lb MBeuO DKV0Md");
    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle(){
        steps.openTooltip()
                .verifyThatTooltipContainsProperText("Голосовой поиск");
    }
}