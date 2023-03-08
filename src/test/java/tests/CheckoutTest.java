package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;

public class CheckoutTest extends BaseTest {

    CheckoutPage page;
    pages.InventoryPage InventoryPage;
    LoginPage login;
    CartPage cart;

    @BeforeMethod
    public void setUp() {
        cart = new CartPage(driver);
        login = new LoginPage(driver);
        page = new CheckoutPage(driver);
        InventoryPage = new InventoryPage(driver);
        driver.get("https://www.saucedemo.com/inventory.html");

    }

    @Test(testName = "US308: Checkout form should have following fields displayed where user can input their details: " +
            "First Name, Last Name, Zip")
    public void test001() throws InterruptedException {

        login.usernameInputField.sendKeys("standard_user");
        login.passwordInputField.sendKeys("secret_sauce");
        login.loginBtn.click();
        cart.cartBtn.click();

        cart.checkoutBtn.click();

        List<WebElement> checkoutFormFields = page.formFields;
        for (int i = 0; i < checkoutFormFields.size(); i++) {
            if (checkoutFormFields.get(i).getAttribute("placeholder").contains("First Name")) {
                Assert.assertTrue(true);
            } else if (checkoutFormFields.get(i).getAttribute("placeholder").contains("Last Name")) {
                Assert.assertTrue(true);
            } else if (checkoutFormFields.get(i).getAttribute("placeholder").contains("Zip")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }
}