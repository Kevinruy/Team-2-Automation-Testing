package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormePages
{
    protected ChromeDriver driver;

    public FormePages(ChromeDriver dirver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "first-name") //es como se identifica dentro de la pagina
    public WebElement firstname; //es el nombre con el que yo lo identifico en mi codigo

    @FindBy(id = "last-name")
    public WebElement lastname;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    public WebElement submit_button;

    @FindBy(xpath = "//div[contains(text(),'The form was successfully submitted!')]")
    public WebElement alertSuccess;



}
