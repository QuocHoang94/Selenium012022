package models.components.global.header;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".header-logo")
public class LogoComponent extends Component {

    private final static By logoLinkSel = By.tagName("a");
    private final static By logoLinkImgSel = By.cssSelector("a img");

    public LogoComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement logoLinkElem(){
        return component.findElement(logoLinkSel);
    }

    public WebElement logoImgElem(){
        return component.findElement(logoLinkImgSel);
    }

}