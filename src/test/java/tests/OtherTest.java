package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OtherPage;

public class OtherTest extends BaseTest {
    OtherPage page;
    @BeforeMethod
    public void setUp(){
        page = new OtherPage(driver);
        driver.get("http://automation.techleadacademy.io/#/others");

    }
    @Test(testName = "US2001 - Disabled button is working as expected")
    public void test2001(){


        page.click(page.toggleBtn);
        Assert.assertTrue(page.displayBtn.isDisplayed());

    }
}
