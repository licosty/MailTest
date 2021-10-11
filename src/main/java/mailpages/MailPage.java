package mailpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage {
    private WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMailBtn() {
        WebElement mailBtn = driver.findElement(By.xpath("//a[@role='link']"));
        mailBtn.click();
    }

    public void findEmail(String search_text) {
        WebElement searchField = driver.findElement(By.xpath("//input[@data-lego='react']"));
        searchField.sendKeys(search_text);
        searchField.sendKeys(Keys.ENTER);
    }

    public int getCountEmailByTopic(String topic) {
        return driver.findElements(By.xpath("//span[@title='" + topic + "']")).size();
    }

    public void inputAddressTo(String emailAddress) {
        WebElement fieldAddressTo = driver.findElement(
                By.xpath("//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField ComposeRecipients-ToField tst-field-to']" +
                        "//div[@class='composeYabbles']"));
        fieldAddressTo.sendKeys(emailAddress);
    }

    public void inputTopic(String topic) {
        WebElement fieldAddressTo = driver.findElement(By.xpath("//input[@name='subject']"));
        fieldAddressTo.sendKeys(topic);
    }

    public void inputEmailText(String text) {
        WebElement fieldAddressTo = driver.findElement(By.xpath("//div[@role='textbox']"));
        fieldAddressTo.sendKeys(text);
    }

    public void openEmail(String topic) {
        WebElement email = driver.findElement(By.xpath("//span[@title='" + topic + "']"));
        email.click();
    }

    public String getEmailText() {
        WebElement textBox = driver.findElement(By.xpath("//div[contains(@class, 'MessageBody__body')]/div"));
        return textBox.getText();
    }

    public void removeEmailByTopic(String topic) {
        findEmail(topic);
        WebElement mail = driver.findElement(By.xpath("//span[@title='" + topic + "']"));
        mail.click();
        WebElement removeBtn = driver.findElement(By.xpath("//div[contains(@title, 'Удалить')]"));
        removeBtn.click();
    }

    public void clearSearchRequest() {
        WebElement clearSearch = driver.findElement(By.xpath("//div[@class='search-input__right-buttons']/button"));
        clearSearch.click();
    }

    public void filterByInboxFolder() {
        WebElement folderBtn = driver.findElement(By.xpath("//div[@class='mail-AdvancedSearch']/button[3]"));
        folderBtn.click();
        WebElement inboxFilterBtn = driver.findElement(By.xpath("//div[@role='listbox'][@tabindex='0']/div[1]"));
        if (!inboxFilterBtn.getAttribute("class").contains("menu__item_checked_yes"))
            inboxFilterBtn.click();
    }

    public void createNewEmail(String to, String topic, String text) {
        WebElement writeEmailBtn = driver.findElement(By.xpath("//a[contains(@title, 'Написать')]"));
        writeEmailBtn.click();
        inputAddressTo(to);
        inputTopic(topic);
        inputEmailText(text);
        WebElement sendEmailBtn = driver.findElement(By.xpath("//button[contains(@class, 'Button2_pin_circle-circle Button2_view_default Button2_size_l')]"));
        sendEmailBtn.click();
    }
}
