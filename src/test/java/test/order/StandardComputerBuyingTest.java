package test.order;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import models.components.order.StandardComputerComponent;
import org.openqa.selenium.WebDriver;
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
    @Description("Buying standard computer with data set")
    @TmsLink("TC_002") @TmsLink("TC_003") @TmsLink("TC_004")
    @Test(dataProvider = "standardCompsDataSet", description = "Buying Cheap Computer")
    public void testStandardCompBuying(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver();
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
