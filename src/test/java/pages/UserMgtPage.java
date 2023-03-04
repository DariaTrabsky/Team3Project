package pages;

import data.pojo.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class UserMgtPage extends BasePage {
    public WebElement mgtDTLastDeleteBtn;

    public UserMgtPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Firstname")
    public WebElement mgtFirstNameField;
    @FindBy(id = "Lastname")
    public WebElement mgtLastNameField;
    @FindBy(id = "Phonenumber")
    public WebElement mgtPhonenumberField;
    @FindBy(id = "Email")
    public WebElement mgtEmailField;
    @FindBy(id = "Select-role")
    public WebElement mgtRoleField;
    @FindBy(id = "submit-btn")
    public WebElement mgtSubmitBtn;
    @FindBy(xpath = "//td[1]")
    public WebElement mgtTemTableFirstName;
    @FindBy(xpath = "//td[2]")
    public WebElement mgtTemTableLastName;
    @FindBy(xpath = "//td[3]")
    public WebElement mgtTemTablePhonenumber;
    @FindBy(xpath = "//td[4]")
    public WebElement mgtTemTableEmail;
    @FindBy(xpath = "//td[5]")
    public WebElement mgtTemTableRole;

    @FindBy(id = "access-db-btn")
    public WebElement mgtAccessDataBaseBtn;

    @FindBy(id = "clear-btn")
    public WebElement mgtClearBtn;

    @FindBy(id = "submit-table-btn")
    public WebElement mgtTableSubmitBtn;
    @FindBy(xpath = "//table[@id='list-table']//td")
    public List<WebElement> mgtDbTableObtion;

    @FindBy(xpath = "//td[6]")
    public List<WebElement> mgtDbTablePassword;

    @FindBy(xpath = "//td[7]")
    public List<WebElement> getMgtDbTableDeleteAllBtn;

    public void FillNewUserForm(String fName, String lName, String phone, String emailInput, String roleInput) {
        mgtFirstNameField.sendKeys(fName);
        mgtLastNameField.sendKeys(lName);
        mgtPhonenumberField.sendKeys(phone);
        mgtEmailField.sendKeys(emailInput);
        mgtRoleField.sendKeys(roleInput);
        mgtSubmitBtn.click();
    }
    public void addNewUserAndSwitchToUserDBPage(User user) {
        FillNewUserForm(user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getRole());
        mgtSubmitBtn.click();
        mgtTableSubmitBtn.click();
        mgtAccessDataBaseBtn.click();
        BrowserUtils.switchToWindow(driver);
    }
}
