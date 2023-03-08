package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

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

    @Test(testName = "US 304 - I need an option to see navigation menu",
            description = "When user clicks the button it should display following buttons: All items, About, Logout, eset app state")
    public void test304(){
        String user = "standard_user";
        String pass = "secret_sauce";
        login.usernameInputField.sendKeys(user);
        login.passwordInputField.sendKeys(pass);
        login.loginBtn.click();
        page.navigationBtn.click();

        page.naviAllItems.isDisplayed();
        page.naviAbout.isDisplayed();
        page.naviLogout.isDisplayed();
        page.naviResetAppState.isDisplayed();
    }
    @Test(testName = "US 305: Footer of the page", description =  "Footer of the page should be '© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy'")
    public void test305() {

        String user = "standard_user";
        String pass = "secret_sauce";
        login.usernameInputField.sendKeys(user);
        login.passwordInputField.sendKeys(pass);
        login.loginBtn.click();

        String expected = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        String actual = page.footerText.getText();
        Assert.assertEquals(expected, actual);
    }
    @Test(testName = "US306: Filter options",
            description = "When user clicks the filter it should have following options: Name (A to Z), Name (Z to A), Price (low to high),Price (high to low)")
    public void test306() {

        String user = "standard_user";
        String pass = "secret_sauce";
        login.usernameInputField.sendKeys(user);
        login.passwordInputField.sendKeys(pass);
        login.loginBtn.click();

        List<String> expectedFilterOptions = Arrays.asList("Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)");
        List<WebElement> elements = page.filterOption;
        for (int i = 0; i <= elements.size() - 1; i++) {
            System.out.println(elements.get(i).getText() + " - " + expectedFilterOptions.get(i));
            Assert.assertEquals(elements.get(i).getText(), expectedFilterOptions.get(i));
        }
    }
}
