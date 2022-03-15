package models.components.checkout;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-confirm_order")
public class ConfirmOrderComponent extends Component {
    public ConfirmOrderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
