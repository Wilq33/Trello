import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends PageObject {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "signup")
    private WebElement signup;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "trelloError")
    private WebElement trelloError;

    @FindBy(id = "redError")
    private WebElement redError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public boolean isInitialized() {
        return password.isDisplayed();
    }
}