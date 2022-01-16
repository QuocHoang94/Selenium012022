package models.components.order;

import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class ComputerEssentialComponent extends BaseItemDetailComponent {

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract  void selectProcessorType(String type);
    public abstract  void selectRAMType(String type);
}
