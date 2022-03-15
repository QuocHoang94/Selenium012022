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

    public InformationColumnComponent informationColumnComp(){
        return findComponent(InformationColumnComponent.class, driver);
    }

    public CustomerServiceColumnComponent customerServiceColumnComp(){
        return findComponent(CustomerServiceColumnComponent.class, driver);
    }

    public AccountColumnComponent accountColumnComp(){
        return findComponent(AccountColumnComponent.class, driver);
    }

    public FollowUsColumnComponent followUsColumnComponent(){
        return findComponent(FollowUsColumnComponent.class, driver);
    }

}
