package Steps;

import Page.FormePages;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSteps extends FormePages{


    public FormSteps(ChromeDriver driver){
         super(driver);

    }
    public void InsertFirstname() {

       // FormePages mainPage = new FormePages() // Creacion de un constructor

        String FIRST_NAME = "Rosario";
        this.firstname.sendKeys(FIRST_NAME);
    }


    public void InsertLastName() {

        String LASTNAME = "Inzunza";

    this.lastname.sendKeys(LASTNAME);

    }
    public void VerifyAlertSuccess(){

        this.alertSuccess.isDisplayed();

    }

    public void ButtomSubmit() {

        this.submit_button.click();

    }


}
