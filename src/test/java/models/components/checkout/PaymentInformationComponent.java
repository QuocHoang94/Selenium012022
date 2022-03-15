package models.components.checkout;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-payment_info")
public class PaymentInformationComponent extends Component {
    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
