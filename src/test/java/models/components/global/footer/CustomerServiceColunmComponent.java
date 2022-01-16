package models.components.global.footer;

import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.customer-service")
public class CustomerServiceColunmComponent extends  FooterColumnComponent{
    public CustomerServiceColunmComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
