package test.order;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import models.components.order.CheapComputerComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_flow.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

public class CheapComputerBuyingTest extends BaseTest implements Urls {

    @Description("Buying cheap computer with data set")
    @TmsLink("TC_001") @TmsLink("TC_005")
    @Test(dataProvider = "cheapCompsDataSet", description = "Buying Cheap Computer")
    public void testCheapCompBuying(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver();
        driver.get(BASE_URL.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerDataObject);
        orderComputerFlow.buildCompSpecAndAddToCart();
    }

    @Issue("JIRA_001")
    @Test
    public void testSomething() {
        Assert.fail("Failed by....sth");
    }

    @DataProvider
    public ComputerDataObject[] cheapCompsDataSet(){
        String cheapCompDataListLocation = "/src/test/resources/test-data/order/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
    }
}
