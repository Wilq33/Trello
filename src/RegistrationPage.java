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

    @FindBy(css = "redError")
    private WebElement redError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public boolean isInitialized() {
        return email.isDisplayed();
    }

    public void enterData(String email, String name, String password) {
        this.email.clear();
        this.email.sendKeys(email);
        this.name.clear();
        this.name.sendKeys(name);
        this.password.clear();
        this.password.sendKeys(password);
        this.signup.click();

    }

    public void sameEmail(String email){

        this.email.clear();
        this.email.sendKeys(email);
        this.name.click();

    }
}