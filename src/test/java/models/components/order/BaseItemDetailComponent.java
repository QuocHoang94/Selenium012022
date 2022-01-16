package models.components.order;

import models.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemDetailComponent extends Component {
    public BaseItemDetailComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
