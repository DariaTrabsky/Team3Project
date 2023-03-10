package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class LoginTest extends BaseTest {
    LoginPage page;
    @BeforeMethod
    public void setUp() {
        page = new LoginPage(driver);
    }

    @Test(testName = "US301", description = "Verify password")
    public void test301(){
        String username = "standard_user";
        String password = "secret_sauce";

        page.loginCredentials(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");


    }

    @Test(testName = "US302", description = "verify locked out message")
    public void test302() {
        String username = "locked_out_user";
        String password = "secret_sauce";

        page.loginCredentials(username, password);


        String expected = "Epic sadface: Sorry, this user has been locked out.";
        String actual = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(actual, expected);
    }

    @Test(testName = "problem_user log in")
    public void US303(){
        String user = "problem_user";
        String pass = "secret_sauce";
        page.usernameInputField.sendKeys(user);
        page.passwordInputField.sendKeys(pass);
        page.loginBtn.click();

        String image = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg";
        List<WebElement> itemImage = page.problemUser;
        System.out.println(page.problemUser);
        for (WebElement each : itemImage){
            Assert.assertEquals(each.getAttribute("src"), image);
        }
    }
}
