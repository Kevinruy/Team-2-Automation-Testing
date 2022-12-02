package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class Utils {
    public WebDriver driver;

    public Utils(WebDriver driver){
        //Inicializamos el web driver en cada testcase
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
    public static  class  UtilsDriver{
        public static String BASE_URL="https://www.advantageonlineshopping.com/#/";
        public static String CHROME_DRIVER_LOCATION="Chromedriver";


    }
}
