package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private static final By usernameSel = By.id("username");
    private static final By passwordSel = By.cssSelector("#password");
    private static final By loginBtnSel = By.cssSelector("#login button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameSel() {
        return this.driver.findElement(usernameSel);
    }

    public WebElement passwordSel() {
        return this.driver.findElement(passwordSel);
    }

    // Main interaction methods
    public LoginPage inputUsername(String username) {
        usernameSel().sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordSel().sendKeys(password);
        return this;
    }

    public void clickOnLoginBtn() {
        driver.findElement(loginBtnSel).click();
    }
}
