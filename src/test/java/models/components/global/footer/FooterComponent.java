package models.components.global.footer;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".footer")
public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public InformationColunmComponent informationColunmComponent(){
        return findComponent(InformationColunmComponent.class, driver);
    }
    public CustomerServiceColunmComponent customerServiceColunmComponent(){
        return findComponent(CustomerServiceColunmComponent.class, driver);
    }
    public AccountColunmComponent accountColunmComponent(){
        return findComponent(AccountColunmComponent.class, driver);
    }
    public FolllowUsColunmComponent folllowUsColunmComponent(){
        return findComponent(FolllowUsColunmComponent.class, driver);
    }
}
