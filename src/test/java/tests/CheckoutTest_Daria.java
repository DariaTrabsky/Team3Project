package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage_Daria;
import pages.InventoryPage_Daria;
import java.util.List;

public class CheckoutTest_Daria extends BaseTest {

    CheckoutPage_Daria page;
    InventoryPage_Daria InventoryPage;

    @BeforeMethod
    public void setUp() {
        page = new CheckoutPage_Daria(driver);
        InventoryPage = new InventoryPage_Daria(driver);
        driver.get("https://www.saucedemo.com/inventory.html");

    }

    @Test(testName = "US308: Checkout form should have following fields displayed where user can input their details: " +
            "First Name, Last Name, Zip")
    public void test001() throws InterruptedException {

        InventoryPage.userNameField.sendKeys("standard_user");
        InventoryPage.passwordField.sendKeys("secret_sauce");
        InventoryPage.loginBtn.click();
        InventoryPage.cartBtn.click();

        driver.findElement(By.id("checkout")).click();

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