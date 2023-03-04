package tests;

import com.github.javafaker.Faker;
import data.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UserMgtPage;
import utils.BrowserUtils;

import java.util.List;

public class UserMgtTest extends BaseTest {
    UserMgtPage page;

    @DataProvider(name = "role")
    public Object[] data() {
        return new String []{"Mentor"};
    }//, "Student", "Instructor"


    @BeforeMethod
    public void setUp() {
        page = new UserMgtPage(driver);
        driver.findElement(By.xpath("//*[text()='User-Mgt']")).click();
    }

    @Test(testName = "US1010: Staging table view",
            description = "Verify temp table is getting populated",
            dataProvider = "role")
    public void test01(String role) {
        //Using Faker to populate fake data
        Faker faker = new Faker();
        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                role);

        //adding user to the table
        page.FillNewUserForm(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getRole());

        page.assertEquals(page.getText(page.mgtTemTableFirstName), user.getFirstName());
//        Assert.assertEquals(page.mgtTemTableFirstName.getText(), user.getFirstName());
        Assert.assertEquals(page.mgtTemTableLastName.getText(), user.getLastName());
        Assert.assertEquals(page.mgtTemTablePhonenumber.getText(), user.getPhone());
        Assert.assertEquals(page.mgtTemTableEmail.getText(), user.getEmail());
        Assert.assertEquals(page.mgtTemTableRole.getText(), role);
    }

    @Test(testName = "US1010: Staging table view - DB check", dataProvider = "role")
    public void test02(String role) {
        //Using Faker to populate fake data
        //driver.get("http://automation.techleadacademy.io/#/usermgt");
        Faker faker = new Faker();
        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                role);

        //adding user to the table
       page.FillNewUserForm(
               user.getFirstName(),
               user.getLastName(),
               user.getPhone(),
               user.getEmail(),
               user.getRole());
//        page.mgtAccessDataBaseBtn.click();
        page.click(page.mgtAccessDataBaseBtn);

        //switch to DB window using BrowserUtils
        BrowserUtils.switchToWindow(driver);

        //validate user email doesn't exist
        String xpath = "//td[text()='" + user.getEmail() + "']";

        //using list to avoid NoSuchElementException, which would stop the execution and not reach Assertion
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        Assert.assertEquals(elementList.size(), 0);
    }
    @Test(testName = "US1011: Clear staging table option", dataProvider = "role")
    public void test1011(String role) {
        //One way -Using Faker to populate fake data
        Faker faker = new Faker();

        //Second way - using POJO
        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                role);

        //adding user to the table
        page.FillNewUserForm(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getRole());

        page.mgtClearBtn.click();
        List<WebElement> dataCount = page.mgtDbTableObtion;
        Assert.assertEquals(dataCount.size(), 0);
    }

    @Test(testName = "US1012: Adding a new user to DB.", dataProvider = "role", groups = "smoke")
    public void test004(String role) {
        //driver.get("http://automation.techleadacademy.io/#/usermgt");
        Faker faker = new Faker();
        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                role);
        page.FillNewUserForm(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getRole());
        page.mgtSubmitBtn.click();
        page.mgtTableSubmitBtn.click();
        page.mgtAccessDataBaseBtn.click();
        BrowserUtils.switchToWindow(driver);


        List<WebElement> elementList = driver.findElements(By.xpath("//td[5]"));
        boolean isPresent = true;
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(user.getEmail())) {
                isPresent = true;
                break;
            }
        }
        Assert.assertEquals(isPresent, true);
    }
}
