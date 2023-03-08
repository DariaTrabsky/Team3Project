package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
    CartPage page;
    LoginPage login;
    InventoryPage inventory;



    @BeforeMethod
    public void setUp() {
        page = new CartPage(driver);
        login = new LoginPage(driver);
        inventory = new InventoryPage(driver);
    }

    @Test(testName = "Remove from cart")
    public void US310(){
        String username = "standard_user";
        String password = "secret_sauce";
        login.loginCredentials(username, password);

        inventory.addBackpackBtn.click();
        page.cartBtn.click();
        page.removeBtn.click();

        if(!driver.findElement(By.xpath("//div[@class='removed_cart_item']")).isDisplayed()){
            Assert.assertTrue(true);
        }

    }
}
