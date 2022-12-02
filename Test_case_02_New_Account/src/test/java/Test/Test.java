package Test;

//Libraries
import Page.FormPages;
import Step.FormSteps;
import Utilities.Recorder;
import Utilities.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Test {
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

            //building an object of formSteps class to acces to its methods
            FormSteps pasos= new FormSteps(driver);
            //building an object of formPages class to acces to its methods
            FormPages element= new FormPages(driver);

            //explicit wait: is used to tell the Web Driver to wait for certain condition
            WebDriverWait wait= new WebDriverWait(driver, 20);
            // wait until find user icon
            wait.until(ExpectedConditions.visibilityOf(element.user));
            //Click user icon
            pasos.ClickUser();
            //suspend execution for a specified period
            Thread.sleep(3000);
           //Click on "Create a nwe count"
            pasos.ClickAccount();
            //implicit wait: is used to tell the web driver to wait for a certain amount of time
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            //FILL FORM

            //Account details
            pasos.writeNameUser();
            pasos.writeEmail();
            pasos.writePassword();
            pasos.rewritePassword();

             //Personal details
            pasos.writeFirstName();
            pasos.writeLastName();
            pasos.writePhone();

            //Address details
            pasos.writeCountry();
            pasos.writeCity();
            pasos.writeAddress();
            pasos.writeState();
            pasos.writeCP();

            //Select checkbox
            pasos.SelectCheckbox();

            //explicit wait
            WebDriverWait wait3= new WebDriverWait(driver, 10);
            //wait until find button register
            wait3.until(ExpectedConditions.visibilityOf(element.register));

            //Click register button
            pasos.clickRegister();
            //implicit wait
            /*
            WebDriverWait wait4= new WebDriverWait(driver, 20);
            // wait until find user icon
            wait4.until(ExpectedConditions.visibilityOf(pasos.useregister));*/
            Thread.sleep(3000);
            //Stop recorder
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
        public void Clean()
        {
       //to write or update test information to reporter
        extent.flush();
        driver.manage().deleteAllCookies();
        driver.close();
         }
}
