package BaseTest;

import Constants.AppConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.PropertyReader;
import utilities.Utility;

import java.time.LocalDate;
import java.util.Objects;

import static utilities.ExtentReportHelper.getReportObject;

public class TestBase {
    protected WebDriver driver;
    protected String browser;
    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();
    private static final ExtentReports reports = getReportObject();
    private static final Logger logger = LogManager.getLogger(TestBase.class);
    String executionMode;
    /*@BeforeSuite
    public void startTest(){
        executionMode = PropertyReader.getProperty(PropertyReader.GRID_URL).isEmpty() ? "Local Execution" : "Remote Execution";
        System.out.println(executionMode);
    }*/
    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(@Optional String browserName,ITestResult result){
        ExtentTest test = reports.createTest(result.getMethod().getMethodName());
        testLogger.set(test);
        testLogger.get().log(Status.INFO,"Execution started: " + LocalDate.now());
        //driver = DriverFactory.getDriver(browser);
        browser = Objects.requireNonNullElse(browserName, AppConstants.browser);
        //driver = DriverFactory.getDriver(Objects.requireNonNullElse(browserName, AppConstants.CHROME));
        if(browser.equalsIgnoreCase("Chrome")){
            driver = DriverFactory.getDriver(browser);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = DriverFactory.getDriver(browser);
        }else {
            driver = DriverFactory.getDriver("Remote");
        }
        driver.get(PropertyReader.getProperty("url"));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.isSuccess()){
            testLogger.get().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " is successful!!", ExtentColor.GREEN));
        }else {
            testLogger.get().log(Status.FAIL,"Test failed due to : " + result.getThrowable());
            String screenshot = Utility.getScreenshot(result.getMethod().getMethodName()+".jpg",driver);
            testLogger.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.Base64Image(screenshot)).build());
        }
        testLogger.get().log(Status.INFO,"Execution Stop Time : " + LocalDate.now());
        DriverFactory.quitDriver();
    }
    @AfterClass
    public void flushTestReport(){
        reports.flush();
    }
}
