package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    public WebElement removeBtn;

    @FindBy(xpath = " //a[@class='shopping_cart_link']")
    public WebElement cartBtn;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

}
