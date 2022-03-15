package models.components.checkout;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-shipping_method")
public class ShippingMethodComponent extends Component {

    public ShippingMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
