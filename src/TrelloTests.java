import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TrelloTests {

    private String trello;
    private String email;
    private String signup;
    private String trelloError;
    private String name;
    private String password;
    private String redError;


    @Before
    public void setUp() {
        Driver.driver = new FirefoxDriver();
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

        Driver.driver.get(trello);
        Driver.driver.findElement(By.id(email)).clear();
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(email)).sendKeys("test@test.pl");
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(signup)).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        Driver.driver.findElement(By.id(name)).sendKeys("Test test");
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(password)).sendKeys("12345678");
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(signup)).click();
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        String expectedMessage = "E-mail jest już w użyciu przez niepotwierdzone konto. Możesz zalogować się lub odzyskać hasło, by je zresetować.";
        String errorMessage = Driver.driver.findElement(By.cssSelector(redError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }

    @Test
    public void testForm2() {

        Driver.driver.get(trello);
        Driver.driver.findElement(By.id(email)).clear();
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(email)).sendKeys("test@test.pl");
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(signup)).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        Driver.driver.findElement(By.id(email)).clear();
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(email)).sendKeys("test");
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driver.findElement(By.id(name)).click();
        Driver.driver.manage().timeouts().implicitlyWait(5, SECONDS);
        String expectedMessage = "To nie wygląda na adres e-mail...";
        String errorMessage = Driver.driver.findElement(By.id(trelloError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }

    @After
    public void tearDown() {

        Driver.driver.quit();

    }
}
