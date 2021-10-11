package mailpages;

import org.junit.jupiter.api.*;

public class MailPageTest extends AbstractTest {
    @BeforeAll
    public void login() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        loginPage.clickAccountMenuBtn();
        mailPage.clickMailBtn();
    }

    @Test
    public void countMailsTest() {
        try {
            mailPage.findEmail(ConfProperties.getProperty("topic_search"));
            mailPage.filterByInboxFolder();
            Thread.sleep(1000);

            int countOfEmail = mailPage.getCountEmailByTopic(ConfProperties.getProperty("topic_search"));

            Assertions.assertEquals(3, countOfEmail);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendEmailTest() {
        try {
            mailPage.findEmail(ConfProperties.getProperty("topic_search"));
            mailPage.filterByInboxFolder();

            Thread.sleep(1000);

            int countOfEmail = mailPage.getCountEmailByTopic(ConfProperties.getProperty("topic_search"));
            mailPage.createNewEmail(
                    ConfProperties.getProperty("login"),
                    ConfProperties.getProperty("topic_with_author"),
                    "Количество писем: " + countOfEmail);

            Thread.sleep(1000);

            mailPage.clearSearchRequest();
            mailPage.findEmail(ConfProperties.getProperty("topic_search"));

            Thread.sleep(1000);

            mailPage.openEmail(ConfProperties.getProperty("topic_with_author"));
            String emailText = mailPage.getEmailText();
            mailPage.removeEmailByTopic(ConfProperties.getProperty("topic_with_author"));
            mailPage.clearSearchRequest();

            Assertions.assertEquals("Количество писем: 3", emailText);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
