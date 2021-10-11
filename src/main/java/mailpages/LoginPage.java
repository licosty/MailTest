package mailpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLogin(String login) {
        WebElement loginField = driver.findElement(By.id("passp-field-login"));
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(By.name("passwd"));
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.id("passp:sign-in"));
        loginBtn.click();
    }

    public String getUserName() {
        WebElement userName = driver.findElement(By.className("user-account__subname"));
        return userName.getText();
    }

    public void clickAccountMenuBtn() {
        WebElement accountMenuBtn = driver.findElement(
                By.xpath("//*[contains(@class, 'user-account user-account_has-ticker_yes ')]"));
        accountMenuBtn.click();
    }
}
