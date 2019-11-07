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
    private String password;
    private String redError;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        trello = "https://trello.com/signup";
        email = "email";
        signup = "signup";
        trelloError = "email-error";
        name = "name";
        password = "password";
        redError = "p.error-message";

    }

    @Test
    public void testForm1() {

        driver.get(trello);
        driver.findElement(By.id(email)).clear();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(email)).sendKeys("test@test.pl");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(signup)).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        driver.findElement(By.id(name)).sendKeys("Test test");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(password)).sendKeys("12345678");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.findElement(By.id(signup)).click();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        String expectedMessage = "E-mail jest już w użyciu przez niepotwierdzone konto. Możesz zalogować się lub odzyskać hasło, by je zresetować.";
        String errorMessage = driver.findElement(By.cssSelector(redError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }

    @Test
    public void testForm2() {

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
        String expectedMessage = "To nie wygląda na adres e-mail...";
        String errorMessage = driver.findElement(By.id(trelloError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }


    @After
    public void tearDown() {

        driver.quit();

    }
}
