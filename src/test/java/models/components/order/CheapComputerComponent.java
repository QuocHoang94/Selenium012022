package models.components.order;

import models.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".product-essential")
public class CheapComputerComponent extends ComputerEssentialComponent{
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public void selectProcessorType(String type) {
        System.out.println("selectProcessorType | CheapComputerComponent");
    }

    @Override
    public void selectRAMType(String type) {
        System.out.println("selectRAMType | CheapComputerComponent");
    }
}
