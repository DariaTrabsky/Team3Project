package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage{
  public CalendarPage(WebDriver driver){
    super(driver);
    PageFactory.initElements(driver,this);
  }
  @FindBy(xpath = "//a[text()='Calendar']")
  public WebElement calendarBtn;
  @FindBy(xpath = "(//input[@type='text'])[2]")
  public WebElement endDateInputField;
  @FindBy(xpath = "//div[contains(@class, 'selected')]/following-sibling::div")
  public WebElement calendarTomorrowDate;
  @FindBy(xpath = "//button[text()='Submit']")
  public WebElement submitBtn;
  @FindBy(id = "num-days")
  public WebElement resultText;
}
