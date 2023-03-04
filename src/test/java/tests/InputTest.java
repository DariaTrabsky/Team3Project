package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InputPage;

public class InputTest extends BaseTest{
    InputPage page;
    @BeforeMethod
    public void setUp(){
        page = new InputPage(driver);
        driver.get("http://automation.techleadacademy.io/#/inputs");

    }
    @Test(testName = "US401")
    public void test401(){

        String expected = "Test";
        page.sendKeys(page.inputEnterMessageField,expected);
        page.click(page.inputShowMessageBtn);
        String actual = page.getText(page.inputMessageText);
        Assert.assertEquals(actual, expected);
    }
    @Test(testName = "US402: Verify message appears")
    public void test402(){
        String message = "Hello World!";
        page.sendKeys(page.inputEnterMessageField, message);
        page.click(page.inputShowMessageBtn);
        String actual = page.getText(page.inputMessageText);
        Assert.assertEquals(message, actual);
    }
}
