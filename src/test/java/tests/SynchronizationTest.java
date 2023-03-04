package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SynchronizationPage;

public class SynchronizationTest extends BaseTest{
    SynchronizationPage page;
    @BeforeMethod
    public void setUp(){
        page = new SynchronizationPage(driver);
        driver.get("http://automation.techleadacademy.io/#/synchronization");
    }
    @Test(testName = "Alert")
    public void test005(){

        page.click(page.synchronizationDisplayAlertBtn);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
