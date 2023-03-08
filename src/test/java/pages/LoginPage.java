package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @FindBy(id = "user-name")
    public WebElement usernameInputField;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//img[@src='/static/media/sl-404.168b1cce.jpg']")
    public List<WebElement> problemUser  ;



   public void loginCredentials(String username, String password){
     usernameInputField.sendKeys(username);
     passwordInputField.sendKeys(password);
     loginBtn.click();

   }

    }


