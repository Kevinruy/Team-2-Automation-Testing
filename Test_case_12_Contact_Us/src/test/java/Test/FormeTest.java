package Test;

import Steps.FormSteps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilities.utils;

public class FormeTest {

    public ChromeDriver driver = new ChromeDriver();

    @BeforeSuite
    public void Settings(){
        System.setProperty("webdriver.chrome.driver", utils.UtilsDriver.CHROME_DRIVER_LOCATION);
        driver.get(utils.UtilsDriver.BASE_URL);
        driver.manage().window().maximize();


    }



    @Test
    public void submit() {

        FormSteps actions = new FormSteps(driver);

        actions.InsertFirstname();
        actions.InsertLastName();
        actions.ButtomSubmit();



    }
     @AfterSuite

    public void clean(){
        driver.manage().deleteAllCookies();
        driver.close();
     }

}
