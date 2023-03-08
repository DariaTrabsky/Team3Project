package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage_Daria extends BasePage {

    public InventoryPage_Daria(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "user-name")
    public WebElement userNameField;
    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//li[@class='social_twitter']")
    public WebElement twitterBtn;

    @FindBy(xpath = "//li[@class='social_facebook']")
    public WebElement facebookBtn;

    @FindBy(xpath = "//li[@class='social_linkedin']")
    public WebElement linkedinBtn;

    @FindBy(xpath = " //a[@class='shopping_cart_link']")
    public WebElement cartBtn;
}
