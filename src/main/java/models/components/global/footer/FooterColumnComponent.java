package models.components.global.footer;

import models.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterColumnComponent extends Component {

    private static final By headerSel = By.tagName("h3");
    private static final By linkSel = By.cssSelector("li a");

    public FooterColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement headerElem(){
        return component.findElement(headerSel);
    }

    public List<WebElement> linkElems(){
        return component.findElements(linkSel);
    }

}
