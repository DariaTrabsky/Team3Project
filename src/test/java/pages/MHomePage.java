package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MHomePage extends MBasePage {


    public MHomePage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement logInBtn;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement navigationBtn;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement naviAllItems;

    @FindBy(id = "about_sidebar_link")
    public WebElement naviAbout;

    @FindBy(id = "logout_sidebar_link")
    public WebElement naviLogout;

    @FindBy(id = "reset_sidebar_link")
    public WebElement naviResetAppState;

    @FindBy(className = "footer_copy")
    public WebElement footerText;

    @FindBy(className = "product_sort_container")
    public WebElement filterOption;
}


