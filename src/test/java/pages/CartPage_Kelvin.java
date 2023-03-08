package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage_Kelvin extends BasePage {
    public CartPage_Kelvin(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "btn btn_secondary btn_small cart_button")
    public WebElement removeBtn;
}