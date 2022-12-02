package Test;

import Page.FormPages;


import Step.FormSteps;
import Utilities.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.json.JSONObject;
import java.util.concurrent.TimeUnit;

public class FormTests {
    public ChromeDriver driver = new ChromeDriver();

    JSONObject ob = new JSONObject();

    //getting first and last name

    @BeforeSuite

    public void config() {
        System.setProperty("webdriver.chrome.driver", Utils.UtilsDriver.CHROME_DRIVER_LOCATION);
        driver.get(Utils.UtilsDriver.BASE_URL);

    }

    @Test
    public void enviar() throws InterruptedException {
        FormSteps paso = new FormSteps(driver);
        FormPages page= new FormPages(driver);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
       WebDriverWait wait= new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(page.user));
        paso.ClickUser();

      Thread.sleep(3000);

       paso.ClickAccount();
       // Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //AACOUNT DETAILS

       paso.writeNameUser();
       paso.writeEmail();
       paso.writePassword();
       paso.rewritePassword();

       //PERSONAL DETAILS
        paso.writeFirstName();
        paso.writeLastName();
        paso.writePhone();

        //ADDRESS DETAILS
        paso.writeCountry();
        paso.writeCity();
        paso.writeAddress();
        paso.writeState();
        paso.writeCP();

        //SELECT CHECK BOX
        paso.SelectCheckbox();

        //PAUSA
        WebDriverWait wait3= new WebDriverWait(driver, 10);
        wait3.until(ExpectedConditions.visibilityOf(paso.register));
        paso.clickRegister();
        //CLICK REGISTER

        paso.clickRegister();

    }
}
