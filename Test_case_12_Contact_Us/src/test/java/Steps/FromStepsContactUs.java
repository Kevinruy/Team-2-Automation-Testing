package Steps;
import Page.FromPagesContactUs;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FromStepsContactUs extends FromPagesContactUs {
    public FromStepsContactUs(ChromeDriver driver){
        super(driver);
    }
    public void contactUsBtn(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        this.contactUsBtn.click();
    }
    public void categorySelected(){

        this.categoryList.click();
        this.categoryListProduct.isDisplayed();
        this.categoryListProduct.click();
    }

    public void productListSelected(){

        this.productListBox.click();
        this.productListBoxItem.click();
        this.productListBoxItem.click();
    }



    public void fillInformation(){

        this.emailContactUs.click();
        String EMAIL = "test@test.com";
        this.emailContactUs.sendKeys(EMAIL);
        this.subjectContactUs.click();
        String SUBJECT = "I Need Support on this WebPage";
        this.subjectContactUs.sendKeys(SUBJECT);
    }


    public void sendBtn(){
        this.sendBtn.isDisplayed();
        this.sendBtn.click();
    }



    public void continueBtn(){
        this.continueBtn.isDisplayed();
        //this.continueBtn.click();
    }

}

