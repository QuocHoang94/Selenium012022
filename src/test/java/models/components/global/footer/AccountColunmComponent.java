package models.components.global.footer;

import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.my-account")
public class AccountColunmComponent extends FooterColumnComponent{
    public AccountColunmComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
