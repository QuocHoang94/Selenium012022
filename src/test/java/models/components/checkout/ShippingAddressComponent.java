package models.components.checkout;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-shipping")
public class ShippingAddressComponent extends Component {
    public ShippingAddressComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
