package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BrowserUtils;

public class InventoryTest extends BaseTest {
    InventoryPage page;
    LoginPage login;

    @BeforeMethod
    public void setUp() {
        login = new LoginPage(driver);
        page = new InventoryPage(driver);
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Test(testName = "US307: Verify there is a social media button twitter")
    public void test001() {

        login.usernameInputField.sendKeys("standard_user");
        login.passwordInputField.sendKeys("secret_sauce");
        login.loginBtn.click();


        page.twitterBtn.click();
        BrowserUtils.switchToNewWindow(driver);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("twitter"));
    }

    @Test(testName = "US307_2: Verify there is a social media button facebook")
    public void test002() {

        login.usernameInputField.sendKeys("standard_user");
        login.passwordInputField.sendKeys("secret_sauce");
        login.loginBtn.click();


        page.facebookBtn.click();
        BrowserUtils.switchToNewWindow(driver);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("facebook"));
    }

    @Test(testName = "US307_3: Verify there is a social media button linkedIn")
    public void test003() {

        login.usernameInputField.sendKeys("standard_user");
        login.passwordInputField.sendKeys("secret_sauce");
        login.loginBtn.click();


        page.linkedinBtn.click();
        BrowserUtils.switchToNewWindow(driver);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("linkedin"));
    }

    @Test(testName = "Add to cart")
    public void US309() {
        String user = "standard_user";
        String pass = "secret_sauce";
        login.usernameInputField.sendKeys(user);
        login.passwordInputField.sendKeys(pass);
        login.loginBtn.click();


        page.addBackpackBtn.click();
        Assert.assertTrue(page.cartBadge.isDisplayed());
    }
}
