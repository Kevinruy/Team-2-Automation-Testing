package Test;

import Steps.FromStepsContactUs;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Recorder;
import utilities.utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


public class Evidence {
    public ExtentTest logger;
    public ExtentReports extent;
    public ExtentSparkReporter spark;

    public ChromeDriver driver = new ChromeDriver();

    LocalDateTime now = LocalDateTime.now();
    String fst = "year" + now.getYear() + "day" + now.getDayOfYear() + "_hr" + now.getHour() + "_min" + now.getMinute();

    @BeforeSuite
    public void setting() {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", utils.UtilsDriver.CHROME_DRIVER_LOCATION);
        driver.get(utils.UtilsDriver.BASE_URL);
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-out/" + fst + "Report.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "Advantage");
        extent.setSystemInfo("Environment", "Stage");
        extent.setSystemInfo("User Name", "Rosario");
        spark.config().setDocumentTitle("QE Academy Report");
        // Name of the report
        spark.config().setReportName("Contact Us TC12");
        // Dark Theme por si quieres
        spark.config().setTheme(Theme.STANDARD);
    }



    @Test(testName = "Submit a WebForm")
    public void submitForm() throws Exception {
        // Todo pertenece a form page
        logger = extent.createTest("Check fill in the black");
        Recorder.startRecord("TC12-ContactUs");
        driver.manage().window().maximize();
        FromStepsContactUs actions = new FromStepsContactUs(driver);
        Thread.sleep(5000);
        actions.contactUsBtn();
        actions.categorySelected();
        actions.productListSelected();
        actions.fillInformation();
        actions.sendBtn();
        actions.continueBtn();
        Thread.sleep(3000);
        Recorder.stopRecord();
    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        } else if(result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        //driver.quit();

    }
    @AfterTest
    public void captura() throws IOException {
        //Screenshot of the case
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File(".//test-out/"+fst+"_screenTC12.png"));
    }


    @AfterSuite
    public void cleanUp(){
        extent.flush();
        driver.manage().deleteAllCookies();
        driver.close();
    }



}
