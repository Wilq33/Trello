import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Test1 {

    private WebDriver driver;
    private String trello;
    private String email;
    private String signup;
    private String trelloError;
    private String name;
    private WebElement element;
    private String password;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        trello = "https://trello.com/signup";
        email = "email";
        signup = "signup";
        trelloError = "email-error";
        name = "name";
        password = "password";

    }

    @Test
    public void testForm() {

        driver.get(trello);
        driver.findElement(By.id(email)).clear();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(email)).sendKeys("test@test.pl");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(signup)).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        driver.findElement(By.id(email)).clear();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(email)).sendKeys("test");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(name)).click();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        try {

            element = driver.findElement(By.id(trelloError));


            if(element.isDisplayed()){

                System.out.println("I can see the message");

            }else{

                System.out.println("I cannot see the message");
            }

            /*System.out.println(trelloError);*/
            /*public static void assertEquals("That doesn't look like an email address…", trelloError);*/
        }catch (Exception e){};
    }

    @After
    public void tearDown() {

        driver.quit();

    }
}
