package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FormPages {

    protected ChromeDriver driver;

    public FormPages(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='menuUser']") //Es como se identifca dentro de la página
    public WebElement Userlogo; //Es el nombre con el que yo lo identifico en mi codigo


    @FindBy(xpath = "//body/login-modal[1]/div[1]/div[1]/div[3]/sec-form[1]/sec-view[1]/div[1]/input[1]")
    public WebElement Username;

    @FindBy(xpath = "/html/body/login-modal/div/div/div[3]/sec-form/sec-view[2]/div/input")
    public WebElement Passwordd;

    @FindBy(xpath = "//button[@id= 'sign_in_btnundefined']")
    public WebElement signinbutton;

    @FindBy(xpath = "//*[@id=\"loginMiniTitle\"]/label[1]")
    public WebElement Myaccount;


}