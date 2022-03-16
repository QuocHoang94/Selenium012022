package test.order;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import models.components.order.StandardComputerComponent;
import org.openqa.selenium.WebDriver;
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

public class StandardComputerBuyingTest extends BaseTest implements Urls {

    private double allItemPrices = 0;

    @Description("Buying standard computer with data set")
    @TmsLink("TC_002") @TmsLink("TC_003") @TmsLink("TC_004")
    @Test(dataProvider = "standardCompsDataSet", description = "Buying Cheap Computer")
    public void testStandardCompBuying(ComputerDataObject computerDataObject) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get(BASE_URL.concat("/build-your-own-computer"));
        int itemQuantity = new SecureRandom().nextInt(100) + 1;
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerDataObject, itemQuantity);
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

    @DataProvider
    public ComputerDataObject[] standardCompsDataSet(){
        String cheapCompDataListLocation = "/src/test/resources/test-data/order/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
    }
}
