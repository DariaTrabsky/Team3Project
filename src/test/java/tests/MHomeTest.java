package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MHomePage;

public class MHomeTest extends MBaseTest {
    MHomePage page;
    @BeforeMethod
    public void setUp(){
        page = new MHomePage(driver);

        page.userNameField.sendKeys("standard_user");
        page.passwordField.sendKeys("secret_sauce");
        page.logInBtn.click();
    }

    @Test(testName = "US 305: Footer of the page", description =  "Footer of the page should be '© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy'")
    public void test305(){

        String expected ="© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        String actual = page.footerText.getText();
        Assert.assertEquals(expected, actual);
    }
    @Test(testName = "US306: Filter options", description = "When user clicks the filter it should have following options: Name (A to Z), Name (Z to A), Price (low to high),Price (high to low)")
    public void test306(){
        page.filterOption.click();
        Select select = new Select(page.filterOption);

    }
    @Test(testName = "US304: navigation menu", description = " When user clicks the button it should display following buttons:All items, About, About, Reset app state")
    public void test304(){
        page.navigationBtn.click();
        Assert.assertTrue(page.naviAllItems.isEnabled());
        Assert.assertTrue(page.naviAbout.isEnabled());
        Assert.assertTrue(page.naviLogout.isEnabled());
        Assert.assertTrue(page.naviResetAppState.isEnabled());
    }

}
