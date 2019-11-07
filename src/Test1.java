import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

    private WebDriver driver;
    private String trello;
    private String email;
    private String signup;
    private String trelloError;
    private String name;
    private WebElement element;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        trello = "https://trello.com/signup";
        email = "email";
        signup = "signup";
        trelloError = "email-error";
        name = "name";
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    @Test
    public void testForm() {

        driver.get(trello);
        driver.findElement(By.id(email)).clear();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.id(email)).sendKeys("test@test.pl");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.id(signup)).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.id(email)).clear();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.id(email)).sendKeys("test");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.id(name)).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

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
