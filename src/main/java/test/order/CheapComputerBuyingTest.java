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
import test_data.CreditCardType;
import test_data.PaymentMethod;
import test_flow.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

import java.security.SecureRandom;

public class CheapComputerBuyingTest extends BaseTest implements Urls {

    private double allItemPrices = 0;
    @Description("Buying cheap computer with data set")
    @TmsLink("TC_001") @TmsLink("TC_005")
    @Test(
            groups = {"smoke"},
            dataProvider = "cheapCompsDataSet", description = "Buying Cheap Computer"
    )
    public void testCheapCompBuying(ComputerDataObject computerDataObject) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get(BASE_URL.concat("/build-your-cheap-own-computer"));
        int itemQuantity = new SecureRandom().nextInt(100) + 1;
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerDataObject, itemQuantity);
        allItemPrices = allItemPrices + orderComputerFlow.buildCompSpecAndAddToCart();
        orderComputerFlow.verifyShoppingCart(allItemPrices);
        orderComputerFlow.agreeTosAndCheckoutAsGuest();
        orderComputerFlow.inputBillingAddress();
        orderComputerFlow.inputShippingAddress();
        orderComputerFlow.selectShippingMethod();
        orderComputerFlow.selectPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderComputerFlow.inputPaymentInfo(CreditCardType.VISA);
        orderComputerFlow.confirmOrder();
        allItemPrices = 0;
    }

    @Issue("JIRA_001")
    @Test
    public void testSomething() {
        Assert.fail("Failed by....sth");
    }

    @DataProvider
    public ComputerDataObject[] cheapCompsDataSet(){
        String cheapCompDataListLocation = "/src/main/resources/test-data/order/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
    }

}
