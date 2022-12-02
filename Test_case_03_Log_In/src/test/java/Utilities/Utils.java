package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {
    public WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static class UtilsDriver{
        public static String BASE_URL = "https://www.advantageonlineshopping.com/#/";
        public static String CHROME_DRIVER_LOCATION = "chromedriver";


    }


}
