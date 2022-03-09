package models.pages;

import models.Component;
import models.components.global.footer.FooterComponent;
import models.components.global.header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {

    protected WebDriver driver;

    public BasePage(WebDriver  driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public FooterComponent footerComponent(){
        return findComponent(FooterComponent.class, driver);
    }
    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class, driver);
    }
}
