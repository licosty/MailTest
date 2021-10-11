package mailpages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends AbstractTest {

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        loginPage.clickAccountMenuBtn();
        String user = loginPage.getUserName();

        Assertions.assertEquals(ConfProperties.getProperty("login"), user);
    }
}
