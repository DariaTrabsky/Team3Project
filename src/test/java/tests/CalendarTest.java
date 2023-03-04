package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarTest extends BaseTest {
    CalendarPage page;
    @BeforeMethod
    public void setUp(){
        page = new CalendarPage(driver);
//        driver.get("http://automation.techleadacademy.io/#/calendar");
    }
    @Test(testName = "US1015: Choosing date from calendar",groups = "smoke")
    public void test1015(){

        page.click(page.calendarBtn);
        page.endDateInputField.click();
        page.calendarTomorrowDate.click();
        page.submitBtn.click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        LocalDate current = LocalDate.now();
        String currentDate = formatter.format(current);
        String tomorrowDate = formatter.format(current.plusDays(1));

        String expectedDate = "There are 1 days between " + currentDate + " and " + tomorrowDate + "";
        String actualDate = driver.findElement(By.id("num-days")).getText();

        Assert.assertEquals(actualDate, expectedDate);
    }
    @Test(testName = "US1017: Choosing date from the calendar. End date test.",description = "text contains selected date.")
    public void test016(){

        page.endDateInputField.click();
        page.calendarTomorrowDate.click();
        page.submitBtn.click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

        String currentDate = formatter.format(LocalDate.now());
        String tomorrowDate = formatter.format(LocalDate.now().plusDays(1));

        String expectedText = "There are 1 days between " + currentDate + " and " + tomorrowDate + "";
        String actualDate = page.resultText.getText();

        Assert.assertEquals(actualDate, expectedText);
    }
}
