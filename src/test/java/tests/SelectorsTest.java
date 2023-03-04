package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelectorsPage;

public class SelectorsTest extends BaseTest{
    SelectorsPage page;
    @BeforeMethod
    public void setUp(){
        page = new SelectorsPage(driver);
        //driver.navigate().to("http://automation.techleadacademy.io/#/home");
    }

    @Test(testName = "US001: verify red color ")
    public void test001(){
        page.click(page.selectors);
        page.click(page.redBtn);
        String expected = "Red";
        String actual = page.getText(page.yourFavoriteColorText);
        page.assertEquals(actual,expected);
    }
}
