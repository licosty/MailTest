package mailpages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractTest {
    WebDriver driver;
    LoginPage loginPage;
    MailPage mailPage;

    @BeforeAll
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, url, node);
        driver = setupTestDriver.getDriver();

        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
