package models.components.global.footer;

import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.follow-us")
public class FolllowUsColunmComponent extends FooterColumnComponent{
    public FolllowUsColunmComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
