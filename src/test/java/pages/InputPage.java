package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputPage extends BasePage {
    public InputPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "message")
    public WebElement inputEnterMessageField;
    @FindBy(name = "button1")
    public WebElement inputShowMessageBtn;
    @FindBy(name = "message1")
    public WebElement inputMessageText;
}
