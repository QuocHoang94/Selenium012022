package test.order;

import models.components.order.StandardComputerComponent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_flow.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

import java.time.Duration;

public class StandardComputerBuyingTest extends BaseTest implements Urls {
//    @Test(dataProvider = "standardCompsDataSet")
//    public void testStandardCompBuying(ComputerDataObject computerDataObject) {
//        driver.get(BASE_URL.concat("/build-your-own-computer"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("/build-your-own-computer"));
//        OrderComputerFlow<StandardComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerDataObject);
//        orderComputerFlow.buildCompSpecAndAddToCart();
//    }
//
//    @DataProvider
//    public ComputerDataObject[] standarCompsDataSet() {
//        String cheapCompDataListLocation = "src/test/resources/test-data/order/StandardComputerDataList.json";
//        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
//    }

    @Test(dataProvider = "standardCompsDataSet")
    public void testStandardCompBuying(ComputerDataObject computerDataObject) {
        driver.get(BASE_URL.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerDataObject);
        orderComputerFlow.buildCompSpecAndAddToCart();
    }

    @DataProvider
    public ComputerDataObject[] standardCompsDataSet(){
        String cheapCompDataListLocation = "/src/test/resources/test-data/order/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
    }
}
