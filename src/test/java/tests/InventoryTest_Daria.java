package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage_Daria;
import utils.BrowserUtils;

public class InventoryTest_Daria extends BaseTest {
    InventoryPage_Daria page;
    @BeforeMethod
    public void setUp() {
        page= new InventoryPage_Daria(driver);
        driver.get("https://www.saucedemo.com/inventory.html");
    }
    @Test(testName = "US307: Verify there is a social media button twitter")
    public void test001() {

        page.userNameField.sendKeys("standard_user");
        page.passwordField.sendKeys("secret_sauce");
        page.loginBtn.click();


        page.twitterBtn.click();
        BrowserUtils.switchToNewWindow(driver);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("twitter"));
      }
        @Test(testName = "US307_2: Verify there is a social media button facebook")
        public void test002() {

        page.userNameField.sendKeys("standard_user");
        page.passwordField.sendKeys("secret_sauce");
        page.loginBtn.click();


        page.facebookBtn.click();
        BrowserUtils.switchToNewWindow(driver);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("facebook"));
        }

        @Test(testName = "US307_3: Verify there is a social media button linkedIn")
        public void test003() {

        page.userNameField.sendKeys("standard_user");
        page.passwordField.sendKeys("secret_sauce");
        page.loginBtn.click();


        page.linkedinBtn.click();
        BrowserUtils.switchToNewWindow(driver);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("linkedin"));
    }
}
