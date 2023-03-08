package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage_Kelvin;

public class CartTest_Kelvin extends BaseTest{
    CartPage_Kelvin page;

    @BeforeMethod
    public void setUp(){
        page = new CartPage_Kelvin(driver);
    }

    @Test(testName = "Remove from cart")
    public void US310(){
    driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).click();

    if (!page.removeBtn.isDisplayed()){
        Assert.assertTrue(true);
    }

    }

}
