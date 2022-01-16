package models.components.global.header;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header")
public class HeaderComponent extends Component {

    private static final By searchInputSel = By.cssSelector("form input");
    private static final By searchInputBtnSel = By.cssSelector(".search-box-button");
    private static final By allLinkSel = By.tagName("a");

    public HeaderComponent(WebDriver driver, WebElement element) {
        super(driver, element);
        this.driver = driver;
    }

    public WebElement searchInputElem() {
        System.out.println(this.component);
        return this.component.findElement(searchInputSel);
    }

    public WebElement searchInputBtn() {
        return this.component.findElement(searchInputBtnSel);
    }

    public int allLinksNumber() {
        return this.component.findElements(allLinkSel).size();
    }
}
