package models.components.checkout;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-payment_method")
public class PaymentMethodComponent extends Component {
    public PaymentMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
