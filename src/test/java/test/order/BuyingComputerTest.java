package test.order;

import driver.DriverFactory;
import models.components.order.CheapComputerComponent;
import models.components.order.StandardComputerComponent;
import models.pages.ComputerDetailsPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class BuyingComputerTest implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL.concat("/build-your-cheap-own-computer"));

        ComputerDetailsPage computerDetailsPage = new ComputerDetailsPage(driver);
        CheapComputerComponent cheapComputerComponent =
        computerDetailsPage.computerEssentialComp(CheapComputerComponent.class);

        cheapComputerComponent.selectProcessorType("Hoangabzzzz");
        cheapComputerComponent.selectRAMType("Hoangabzzzz");
        StandardComputerComponent standardComputerComponent =
                computerDetailsPage.computerEssentialComp(StandardComputerComponent.class);

        standardComputerComponent.selectProcessorType("autocard");
        standardComputerComponent.selectRAMType("autocard");

    }
}
