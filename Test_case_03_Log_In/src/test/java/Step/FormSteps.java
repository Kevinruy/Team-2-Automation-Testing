package Step;
import Page.FormPages;
import org.openqa.selenium.chrome.ChromeDriver;
public class FormSteps extends FormPages {


    public FormSteps(ChromeDriver driver){
        super (driver);
    }
    public void Click_username() {
        String user_ = "kevin_ruy";
        this.Username.click();
        this.Username.sendKeys(user_);
    }
    public void Click_user() {
        this.Userlogo.click();
    }

    public void Click_password() {
        String password_ = "Dedos123";
        this.Passwordd.click();
        this.Passwordd.sendKeys(password_);
        this.signinbutton.click();

    }
    public void Chequeo() throws InterruptedException {

        this.Userlogo.click();
        Thread.sleep(1000);
        this.Myaccount.click();
    }
}
