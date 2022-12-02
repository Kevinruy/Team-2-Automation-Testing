package Test;
import Steps.FromStepsContactUs;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilities.utils;

public class FromTestContactUs {
    public ChromeDriver driver = new ChromeDriver();

    @BeforeSuite

    public void Settings() {
        System.setProperty("webdriver.chrome.driver", utils.UtilsDriver.CHROME_DRIVER_LOCATION);
        driver.get(utils.UtilsDriver.BASE_URL);
        driver.manage().window().maximize();
    }

    @Test

    public void fillContactUS() throws InterruptedException {

        FromStepsContactUs actions = new FromStepsContactUs(driver);
            Thread.sleep(5000);
            actions.contactUsBtn();
            actions.categorySelected();
            actions.productListSelected();
            actions.fillInformation();
            actions.sendBtn();
            Thread.sleep(2000);
            actions.continueBtn();
        }

    @AfterSuite
    public void clean(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}