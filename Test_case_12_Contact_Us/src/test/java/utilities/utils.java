package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class utils {

    public WebDriver driver;

    public utils(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public static class UtilsDriver{

        public static String BASE_URL = "https://advantageonlineshopping.com/#/";
        public static String CHROME_DRIVER_LOCATION = "chrome driver";

    }

}
