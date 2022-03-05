package models.components.order;

import models.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class ComputerEssentialComponent extends BaseItemDetailComponent {

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract void selectProcessorType(String type);

    public abstract void selectRAMType(String type);

    protected void selectCompSpecOption(String option) {
        String selectorString = "//label[contains(text(),\"" + option + "\")]";
        By optionSel = By.xpath(selectorString);
        WebElement optionElem = component.findElement(optionSel);
        optionElem.click();
    }
}
