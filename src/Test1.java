import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test1 {

    private WebDriver driver;
    private String trello;
    private String email;
    private String signup;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        trello = "https://trello.com/signup";
        email = "email";
        signup = "signup";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumTestForm() {

        driver.get(trello);
        driver.findElement(By.id(email)).clear();
        driver.findElement(By.id(email)).sendKeys("test@test.pl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(signup));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(email)).clear();
        driver.findElement(By.id(email)).sendKeys("test");

        }

    @After
    public void tearDown(){

        driver.quit();

    }

}