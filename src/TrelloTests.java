import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;
import org.openqa.selenium.WebDriver;

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
        Driver.driverF = new FirefoxDriver();
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

        //Test to check if you can create another account using already registered e-mail address

        Driver.driverF.get(trello);
        Driver.driverF.findElement(By.id(email)).clear();
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(email)).sendKeys("test@test.pl");
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(signup)).click();
        WebDriverWait wait = new WebDriverWait(Driver.driverF, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        Driver.driverF.findElement(By.id(name)).sendKeys("Test test");
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(password)).sendKeys("12345678");
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(signup)).click();
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        String expectedMessage = "E-mail jest już w użyciu przez niepotwierdzone konto. Możesz zalogować się lub odzyskać hasło, by je zresetować.";
        String errorMessage = Driver.driverF.findElement(By.cssSelector(redError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }

    @Test
    public void testForm2() {

        //Test to check if you can create

        Driver.driverF.get(trello);
        Driver.driverF.findElement(By.id(email)).clear();
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(email)).sendKeys("test@test.pl");
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(signup)).click();
        WebDriverWait wait = new WebDriverWait(Driver.driverF, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        Driver.driverF.findElement(By.id(email)).clear();
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(email)).sendKeys("test");
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        Driver.driverF.findElement(By.id(name)).click();
        Driver.driverF.manage().timeouts().implicitlyWait(5, SECONDS);
        String expectedMessage = "To nie wygląda na adres e-mail...";
        String errorMessage = Driver.driverF.findElement(By.id(trelloError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }

    @After
    public void tearDown() {

        Driver.driverF.quit();

    }
}
