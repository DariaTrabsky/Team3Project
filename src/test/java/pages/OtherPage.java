package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherPage extends BasePage{
    public OtherPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "toggle-btn")
    public WebElement toggleBtn;
    @FindBy(id = "btn-status")
    public WebElement displayBtn;



}
