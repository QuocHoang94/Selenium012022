package models.pages;

import models.Component;
import models.components.global.footer.FooterComponent;
import models.components.global.header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage extends Component {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName().toLowerCase();
        if(browserName.equals("safari")){
            driver.manage().window().maximize();
        }
    }

    public FooterComponent footerComponent(){
        return findComponent(FooterComponent.class, driver);
    }

    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class, driver);
    }
}
