package Step;

import Page.FormPages;
import Utilities.json;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSteps extends FormPages {
    public FormSteps(ChromeDriver driver)  {
        //Call constructor of parent's class
        super(driver);
    }

    //Create an instance of json class and we pass the path
    json js= new json("src/test/java/resources/jsonfile.json");

    //Click icono usuario
    public void ClickUser(){
        this.user.click();
    }
    //Click en create a new account
    public void ClickAccount(){

        this.account.click();
    }

    //ACCOUNT DETAILS
    public void writeNameUser() {
        //Access our element called name_u from our json file
        String name_u=js.getDato("name_u");
        this.username.sendKeys(name_u);
    }
    public void writeEmail() {
        String email_user=js.getDato("email");
        this.email.sendKeys(email_user);
    }
    public void writePassword() {
        String password_user=js.getDato("password");
        this.password.sendKeys(password_user);
    }
    public void rewritePassword() {
        String password_re=js.getDato("repassword");
        this.repassword.sendKeys(password_re);
    }

    //PERSONAL DETAILS
    public void writeFirstName(){
        String first_name=js.getDato("firstname");
        this.name.sendKeys(first_name);
    }
    public void writeLastName() {
        String last_name=js.getDato("lastname");
        this.lastname.sendKeys(last_name);
    }
    public void writePhone() {
        String phone=js.getDato("phone");
        this.phoneNumber.sendKeys(phone);
    }

    //ADDRESS DETAILS
    public void writeCountry() {
        String country_c=js.getDato("country");
        this.country.sendKeys(country_c);
    }
    public void writeCity() {
        String city_c=js.getDato("city");
        this.city.sendKeys(city_c);
    }
    public void writeAddress() {
        String address_c=js.getDato("address");
        this.address.sendKeys(address_c);
    }
    public void writeState() {
        String state_c=js.getDato("state");
        this.state.sendKeys(state_c);
    }
    public void writeCP() {
        String codigo=js.getDato("cp");
        this.cp.sendKeys(codigo);
    }

    //Click register button
    public void clickRegister() {
        this.register.click();
    }

    //Select Checkbox "I agree"
    public void SelectCheckbox()
    {
        this.checkbox.click();
    }
}
