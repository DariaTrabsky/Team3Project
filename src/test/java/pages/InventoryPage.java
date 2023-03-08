package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
