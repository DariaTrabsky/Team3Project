package tests;

import com.github.javafaker.Faker;
import data.pojo.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UserMgtDBPage;
import pages.UserMgtPage;
import utils.BrowserUtils;

import java.util.List;


public class UserMgtDBTest extends BaseTest {
    private UserMgtDBPage page;
    private UserMgtPage userMgtPage;

    @DataProvider(name = "role")
    public Object[] data() {
        return new String[]{"Mentor"};//"Student", "Instructor",
    }

    @BeforeMethod
    public void setUp() {
        page = new UserMgtDBPage(driver);
        userMgtPage = new UserMgtPage(driver);
        driver.get("http://automation.techleadacademy.io/#/usermgt");
    }

    @Test(testName = "US2003 - mew user's password format",
            description = "User's default password in database should be formatted as 'firstName.lastName$",
            dataProvider = "role")
    public void test(String role){
        String firstName = "Sally";
        String lastName = "White";
        String phone = "13135646";
        String email = "sallyw@email.com";

        userMgtPage.FillNewUserForm(
                firstName,
                lastName,
                phone,
                email,
                role);



        page.click(userMgtPage.mgtSubmitBtn);


        page.click(userMgtPage.mgtTableSubmitBtn);
        page.click(userMgtPage.mgtAccessDataBaseBtn);

        BrowserUtils.switchToWindow(driver);

        List<WebElement> password = userMgtPage.mgtDbTablePassword;
        int lastIndex = password.size() - 1;


        String newPassFormat = firstName + "." + lastName + "$";
        page.assertEquals(page.getText(password.get(lastIndex)),newPassFormat.toLowerCase());
    }

    @Test(testName = "US2004 - New user's password format using POJO",
            description = "User's default password in database should be formatted as 'firstName.lastName$",
            dataProvider = "role")
    public void test2004(String role) {

        Faker faker = new Faker();

        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(), faker.internet().emailAddress(),
                role
        );
        page.click(userMgtPage.mgtAccessDataBaseBtn);
        userMgtPage.addNewUserAndSwitchToUserDBPage(user);

        String newPassFormat = user.getFirstName()+"."+user.getLastName()+"$";
        List<WebElement> passwords = userMgtPage.mgtDbTablePassword;
        int lastIndex = passwords.size()-1;

        page.assertEquals(page.getText(passwords.get(lastIndex)),newPassFormat.toLowerCase());

    }
    @Test(testName = "US2005 - Delete option for new user", dataProvider = "role")
    public void test2005(String role){
        Faker faker = new Faker();
        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                role
        );
        page.click(userMgtPage.mgtAccessDataBaseBtn);
        userMgtPage.addNewUserAndSwitchToUserDBPage(user);
        Assert.assertTrue(page.mgtDTLastDeleteBtn.isDisplayed());
    }


}
