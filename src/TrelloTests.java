import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        SignUpPage signUpPage = new SignUpPage(Driver.driverF);
        Assert.assertTrue(signUpPage.isInitialized());
        signUpPage.enterEmail("test@test.pl");

        WebDriverWait wait = new WebDriverWait(Driver.driverF, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));

        RegistrationPage registrationPage = new RegistrationPage(Driver.driverF);
        Assert.assertTrue(registrationPage.isInitialized());
        registrationPage.enterData("test@test.pl", "Test Test", "12345678");

        String expectedMessage = "E-mail jest już w użyciu przez niepotwierdzone konto. Możesz zalogować się lub odzyskać hasło, by je zresetować.";
        String errorMessage = Driver.driverF.findElement(By.cssSelector(redError)).getText();
        System.out.println(errorMessage);
        Assert.assertTrue("Your error message", errorMessage.contains(expectedMessage));

    }

    @Test
    public void testForm2() {

        //Test to check if you can change an email address to non-email text

        Driver.driverF.get(trello);
        SignUpPage signUpPage = new SignUpPage(Driver.driverF);
        Assert.assertTrue(signUpPage.isInitialized());
        signUpPage.enterEmail("test@test.pl");

        WebDriverWait wait = new WebDriverWait(Driver.driverF, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));

        RegistrationPage registrationPage = new RegistrationPage(Driver.driverF);
        Assert.assertTrue(registrationPage.isInitialized());
        registrationPage.sameEmail("test");

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
