import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "signup")
    private WebElement signup;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    @FindBy(id = "signup")
    private WebElement submitButton;
}