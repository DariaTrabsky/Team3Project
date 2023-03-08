package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//li[@class='social_twitter']")
    public WebElement twitterBtn;

    @FindBy(xpath = "//li[@class='social_facebook']")
    public WebElement facebookBtn;

    @FindBy(xpath = "//li[@class='social_linkedin']")
    public WebElement linkedinBtn;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addBackpackBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement cartBadge;

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

    @FindBy(xpath = "//select[@class='product_sort_container']/option")
    public List<WebElement> filterOption;


}
