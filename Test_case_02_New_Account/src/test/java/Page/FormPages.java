package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPages {
    protected ChromeDriver driver;
    public FormPages(ChromeDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);

    }
    //Icon user
    @FindBy(xpath = "//a[@id='hrefUserIcon']")
    public WebElement user;

    // Create a new count
    @FindBy (xpath = "//a[@translate=\"CREATE_NEW_ACCOUNT\"]")
    public WebElement account;

    //ACCOUNT DETAILS
    @FindBy(xpath = "//input[@name='usernameRegisterPage']")
    public  WebElement username;

    @FindBy(xpath = "//input[@name='emailRegisterPage']")
    public  WebElement email;

    @FindBy(xpath = "//input[@name='passwordRegisterPage']")
    public  WebElement password;

    @FindBy(xpath = " //input[@name='confirm_passwordRegisterPage']")
    public  WebElement repassword;

    //PERSONAL DETAILS
    @FindBy(xpath = "//input[@name='first_nameRegisterPage']")
    public  WebElement name;

    @FindBy(xpath = "//input[@name='last_nameRegisterPage']")
    public  WebElement lastname;

    @FindBy(xpath = "//input[@name='phone_numberRegisterPage']")
    public  WebElement phoneNumber;

    //ADDRESS DETAILS
    @FindBy(xpath = "//select[@name='countryListboxRegisterPage']")
    public  WebElement country;

    @FindBy(xpath = "//input[@name='cityRegisterPage']")
    public  WebElement city;

    @FindBy(xpath = "//input[@name='addressRegisterPage']")
    public  WebElement address;

    @FindBy(xpath = "//input[@name='state_/_province_/_regionRegisterPage']")
    public  WebElement state;

    @FindBy(xpath = "//input[@name='postal_codeRegisterPage']")
    public  WebElement cp;

    //Checkbox "I Agree..."
    @FindBy(xpath = "//input[@name='i_agree']")
    public  WebElement checkbox;

    //Button register
    @FindBy(xpath = "//button[normalize-space()='REGISTER']")
    public  WebElement register;
    //User register
    @FindBy(xpath = "//a[@id='menuUserLink']")
    public WebElement useregister;
}
