package Test;


//Libraries

import Step.FormSteps;
import Utilities.Recorder;
import Utilities.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TestVideo {
    //Logs test steps (pass, fail, skip, info)  in the HTML report
    public ExtentTest logger;
    //Generates HTML reports based on a path specified
    public ExtentReports extent;
    //Styles of the test report
    public ExtentSparkReporter spark;

    public ChromeDriver driver = new ChromeDriver();
    //take actual date
    LocalDateTime now = LocalDateTime.now();
    //separate the date for year, day, hour and minute
    String fst = "year" + now.getYear() + "day" + now.getDayOfYear() + "_hr" + now.getHour() + "_min" + now.getMinute();

    @BeforeSuite

    public void setting(){

        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.UtilsDriver.CHROME_DRIVER_LOCATION);
        //url of the page
        driver.get(Utils.UtilsDriver.BASE_URL);
        //generates HTML reports
        extent = new ExtentReports();
        //location report
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + fst + "TC02_Report.html");
        extent.attachReporter(spark);

        extent.setSystemInfo("Host Name", "Advantage");//page
        extent.setSystemInfo("Environment", "Stage");//envoriment
        extent.setSystemInfo("User Name", "Yuritzi");//user name
        spark.config().setDocumentTitle("QE Academy Report"); //title of our document
        // Name of the report
        spark.config().setReportName("Reporte TC02CreateAnAccount");
        // color of the Theme page (white)
        spark.config().setTheme(Theme.STANDARD);

    }

    @org.testng.annotations.Test

    public void submitForm() throws Exception {
        //Maximize windows
        driver.manage().window().maximize();

        //start record
        Recorder.startRecord("TC02");

        logger = extent.createTest("TC02-Create a new account");


        FormSteps actions = new FormSteps(driver);
        Thread.sleep(3000);
        actions.Click_user();
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actions.Click_username();
        Thread.sleep(1000);
        actions.Click_password();
        Thread.sleep(3000);
        actions.Chequeo();
        Thread.sleep(3000);
        Recorder.stopRecord();


    }

    @AfterMethod
    //To get the status of our tests and publish it in our report
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        //driver.quit();
    }
    @AfterTest
    public void captura() throws IOException {
        //Screenshot of the case
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File(".//test-output/"+fst+"_screenTC02.png"));
    }
    @AfterSuite
    public void Clean() throws InterruptedException {
        //to write or update test information to reporter
        extent.flush();
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.close();
    }
}
