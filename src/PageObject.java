import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public PageObject(WebDriver driver){
        Driver.driverF = driver;
        PageFactory.initElements(driver, this);
    }
}