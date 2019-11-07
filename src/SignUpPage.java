import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SignUpPage extends PageObject {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "signup")
    private WebElement signup;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return email.isDisplayed();
    }

    public void enterEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
        this.signup.click();
    }
}
