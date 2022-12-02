package Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FromPagesContactUs {

    protected ChromeDriver driver;

    public FromPagesContactUs(ChromeDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath= "//a[contains(text(),'CONTACT US')]") //link text del contact us
    public WebElement contactUsBtn;

    @FindBy(name = "categoryListboxContactUs") //se posiciona sobre las categorias
    public WebElement categoryList;
    @FindBy(xpath = "//option[. = 'Laptops']") //esta es la opcion dentro del dropdown
    public WebElement categoryListProduct;

    @FindBy(name = "productListboxContactUs") //esta es la opcion para darle click al dropdown del producto
    public WebElement productListBox;

    @FindBy(xpath = "//option[. = 'HP Chromebook 14 G1(ENERGY STAR)']") //esta es la opcion del producto dentro del dropdown
    public WebElement productListBoxItem;

    @FindBy(name = "emailContactUs") //este es el campo de email en el formulario
    public WebElement emailContactUs;

    @FindBy(name = "subjectTextareaContactUs") //este es el campo de subject en el formulario
    public WebElement subjectContactUs;

    @FindBy(id = "send_btnundefined") //este es el boton de enviar
    public WebElement  sendBtn;

   @FindBy(linkText = "CONTINUE SHOPPING") //este es el boton de continue to shopping
   public WebElement continueBtn;

}
