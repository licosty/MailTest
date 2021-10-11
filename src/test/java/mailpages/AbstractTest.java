package mailpages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractTest {
    WebDriver driver;
    LoginPage loginPage;
    MailPage mailPage;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("url"));
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
