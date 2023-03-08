package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage_Kelvin;

import java.util.List;

public class LoginTest_Kelvin extends BaseTest{
    LoginPage_Kelvin page;

    @BeforeMethod
    public void setUp(){
        page = new LoginPage_Kelvin(driver);
    }

    @Test(testName = "problem_user log in")
    public void US303(){
        String user = "problem_user";
        String pass = "secret_sauce";
        page.usernameField.sendKeys(user);
        page.passwordField.sendKeys(pass);
        page.loginBtn.click();

        String image = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg";
        List<WebElement> itemImage = driver.findElements(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']"));
        System.out.println(driver.findElement(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']")).getAttribute("src"));
        for (WebElement each : itemImage){
            Assert.assertEquals(each.getAttribute("src"), image);
        }


    }

    @Test(testName = "Add to cart")
    public void US309(){
        String user = "standard_user";
        String pass = "secret_sauce";
        page.usernameField.sendKeys(user);
        page.passwordField.sendKeys(pass);
        page.loginBtn.click();


        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed());

    }
}
