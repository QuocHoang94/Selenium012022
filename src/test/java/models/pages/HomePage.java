package models.pages;

import models.components.global.header.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HeaderComponent headerComp(){
        return new HeaderComponent(this.driver);
    }
}
