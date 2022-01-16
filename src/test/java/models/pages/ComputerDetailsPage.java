package models.pages;

import models.components.order.ComputerEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerDetailsPage extends BasePage {
    public ComputerDetailsPage(WebDriver driver) {
        super(driver);
    }

    public <T extends ComputerEssentialComponent> T computerEssentialComp(Class<T> computerEssentialCompClass) {
        return findComponent(computerEssentialCompClass, driver);
    }
}
