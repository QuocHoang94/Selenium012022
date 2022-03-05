package test.order;

import driver.DriverFactory;
import models.components.order.CheapComputerComponent;
import models.components.order.StandardComputerComponent;
import models.pages.ComputerDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;
import url.Urls;

/*TODO: This is NOT the final test Method | Need to create details flow*/
public class BuyingComputerTest extends BaseTest implements Urls {

    @Test
    public void testStandardCompBuying() throws InterruptedException {
        driver.get(BASE_URL.concat("/build-your-own-computer"));

        ComputerDetailsPage computerDetailsPage = new ComputerDetailsPage(driver);
        StandardComputerComponent standardComputerComp =
                computerDetailsPage.computerEssentialComp(StandardComputerComponent.class);

        StandardComputerComponent standardComputerComponent =
                computerDetailsPage.computerEssentialComp(StandardComputerComponent.class);

        standardComputerComp.selectProcessorType("2.2GHz");
        Thread.sleep(2000);
        standardComputerComp.selectRAMType("8GB");
        Thread.sleep(2000);
        System.out.println(standardComputerComp.productPrice());
        standardComputerComp.setProductQuantity(55);
        Thread.sleep(2000);
        standardComputerComp.clickOnAddToCartBtn();
        /*GSON*/
        /*JSON*/
    }
}
