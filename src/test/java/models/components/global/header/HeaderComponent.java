package models.components.global.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderComponent {

    private final WebDriver driver;
    private static final By componentSel = By.cssSelector(".header");
    private WebElement component;

    private static final By searchInputSel = By.cssSelector("form input");
    private static final By searchInputBtnSel = By.cssSelector(".search-box-button");
    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        component = driver.findElement(componentSel);
    }

    public WebElement searchInputElem(){
        return this.component.findElement(searchInputSel);
    }

    public WebElement searchInputBtn(){
        return this.component.findElement(searchInputBtnSel);
    }
}
