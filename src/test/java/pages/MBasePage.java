package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.MBaseTest;
import utils.ConfigReader;

import static java.lang.Thread.sleep;

public class MBasePage extends MBaseTest {
    public MBasePage(WebDriver driver){
        this.driver = driver;
    }
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 2; i++) {
            try {
                if (i % 2 == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                    if (ConfigReader.readProperty("configuration.properties","takeScreenshots").equalsIgnoreCase("true"))
                        MBaseTest.reportManager.logScreenshot();
                } else {
                    sleep(600);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendKeys(WebElement element, String inputText){
        MBaseTest.reportManager.LocatorInfo("Entered text: " + inputText + " ", element);
        highlightElement(element);
        element.sendKeys(inputText);
    }

    public String getText(WebElement element){
        MBaseTest.reportManager.LocatorInfo("Retrieved TEXT: ", element);
        highlightElement(element);
        return element.getText();
    }
    public void click(WebElement element){
        MBaseTest.reportManager.LocatorInfo("Clicked on a BUTTON: ", element);
        highlightElement(element);
        waitFprClickability(element);
        element.click();
    }
    public void assertEquals(String actual, String expected){
         MBaseTest.reportManager.logInfo("Expected: " + expected);
         MBaseTest.reportManager.logInfo("Actual: " + actual);
        Assert.assertEquals(actual, expected);
    }
    public void waitFprClickability(WebElement element  ){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
