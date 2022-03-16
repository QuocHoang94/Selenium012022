package models.components.checkout;

import io.qameta.allure.Step;
import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ComponentCssSelector(value = "#opc-shipping_method")
public class ShippingMethodComponent extends Component {

    private final static By continueBtnSel = By.cssSelector(".shipping-method-next-step-button");

    public ShippingMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step(value = "Select shipping method as {shippingMethod}")
    public void selectShippingMethod(String shippingMethod){
        component
                .findElement(By.xpath("//label[contains(text(), \"" + shippingMethod + "\")]"))
                .click();
    }

    public void clickOnContinueBtn(){
        WebElement continueBtnElem = component.findElement(continueBtnSel);
        continueBtnElem.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtnElem));
    }
}
