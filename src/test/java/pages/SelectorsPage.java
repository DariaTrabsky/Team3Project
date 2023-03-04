package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectorsPage extends BasePage{
    public SelectorsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='Selectors']")
    public WebElement selectors;

    @FindBy(id = "red-color")
    public WebElement redBtn;

    @FindBy(className = "yellow-color")
    public WebElement yellowBtn;

    @FindBy(xpath = "//span[text()='Red']")
    public WebElement yourFavoriteColorText;



}
