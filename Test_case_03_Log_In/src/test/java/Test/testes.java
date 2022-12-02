package Test;
import org.testng.annotations.Test;
import Step.FormSteps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;
public class testes {
    public ChromeDriver driver = new ChromeDriver();

    @BeforeSuite

    public void Config(){
        System.setProperty("webdriver.chrome.drive", Utilities.Utils.UtilsDriver.CHROME_DRIVER_LOCATION);
        driver.get(Utilities.Utils.UtilsDriver.BASE_URL);

    }


    @Test

    public void SendForm() throws InterruptedException {
        FormSteps actions = new FormSteps(driver);
        Thread.sleep(3000);
        actions.Click_user();
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actions.Click_username();
        Thread.sleep(3000);
        actions.Click_password();
        Thread.sleep(3000);
        actions.Chequeo();


    }

    @AfterSuite
    public void Clean() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
        driver.close();
    }




}
