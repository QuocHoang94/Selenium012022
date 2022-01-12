package models.pages;

import models.components.global.header.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HeaderComponent headerComp() {
        return findComponent(HeaderComponent.class, driver);
    }
}
