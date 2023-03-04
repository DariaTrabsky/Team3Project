package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ExtentManager {
    WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    public void createReport() {

        extentReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");

        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("My Report");
        spark.config().setReportName("Report Custom Name");
        extentReports.attachReporter(spark);
    }

    @AfterSuite
    public void closeReporter( ) {
        extentReports.flush();
    }

    @BeforeMethod
    public ExtentTest createTestReport(WebDriver driver, Method method) {
        this.driver = driver;
        extentTest = extentReports.createTest(getCustomTestDescription(method));
        longTestGroups(method);
        return extentTest;
    }
    @AfterMethod
    public void closeTestReport(ITestResult result){
        //This will capture the result of the Test and log to extentTest report
        if (result.getStatus()==ITestResult.SUCCESS){
            extentTest.pass("TEST PASSED");
        }else if (result.getStatus()==ITestResult.FAILURE){
            extentTest.fail("TEST FAILED");
            logScreenshot("False");
            extentTest.fail(result.getThrowable());
        }else if (result.getStatus()==ITestResult.SKIP){
            extentTest.skip("TEST SKIPPED");
            extentTest.fail(result.getThrowable());
        }
    }

    public void longTestGroups(Method method) {
        Test testClass = method.getAnnotation(Test.class);
        for (String e : testClass.groups()) {
            extentTest.assignCategory(e);
        }
    }

    public String getCustomTestName(Method method) {
        Test testClass = method.getAnnotation(Test.class);
        if (testClass.testName().length() > 0)
            return testClass.testName();
        return method.getName();

    }

    public String getCustomTestDescription(Method method) {
        Test testClass = method.getAnnotation(Test.class);
        if (testClass.description().length() > 0)
            return testClass.testName();
        return method.getName();
    }

    public void logScreenshot(String title) {
        extentTest.info(title, MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.takeScreenshots(driver)).build());
    }
    public void logScreenshot(){
        if (ConfigReader.readProperty("configuration.properties","takeScreenshots").equalsIgnoreCase("true"))

        extentTest.info(MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.takeScreenshots(driver)).build());
    }

    public void logInfo(String info) {
        extentTest.info(info);
    }

    public void LocatorInfo(String msg, WebElement element) {

        String str = element.toString();

        extentTest.info(msg + "->" + str.substring(str.indexOf("->")+2, str.length()-1));

    }
}
