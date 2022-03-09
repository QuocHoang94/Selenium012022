package test_flow.order;

import models.components.order.ComputerEssentialComponent;
import models.components.order.StandardComputerComponent;
import models.pages.ComputerDetailsPage;
import org.openqa.selenium.WebDriver;
import test_data.ComputerDataObject;

public class OrderComputerFlow<T extends ComputerEssentialComponent> {

    private final WebDriver driver;
    private final Class<T> computerEssentialComponent;
    private final ComputerDataObject computerDataObject;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent, ComputerDataObject computerDataObject) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
        this.computerDataObject = computerDataObject;

    }

    public void buildCompSpecAndAddToCart() {
        ComputerDetailsPage computerDetailsPage = new ComputerDetailsPage(driver);
        T compEssentialComponent =
                computerDetailsPage.computerEssentialComp(computerEssentialComponent);

        compEssentialComponent.selectProcessorType(computerDataObject.getProcessorType());
        compEssentialComponent.selectRAMType(computerDataObject.getRam());
        compEssentialComponent.setProductQuantity(55);
        compEssentialComponent.selectHDD(computerDataObject.getHdd());
        if (computerDataObject.getOs() != null) {
            compEssentialComponent.selectOS(computerDataObject.getOs());
        }

        compEssentialComponent.clickOnAddToCartBtn();

        // Wait until the item added to cart
        compEssentialComponent.waitUntilItemAddedToCart();

        //Then navigate to shopping cart
        computerDetailsPage.headerComp().clickOnShoppingCartLink();

    }
}
