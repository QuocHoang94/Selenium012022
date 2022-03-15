package models.components.cart;

import io.qameta.allure.Step;
import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentCssSelector(value = ".cart-footer .totals")
public class TotalComponent extends Component {

    private final static By priceTableRowsSel = By.cssSelector("table tr");
    private final static By priceTypeSel = By.cssSelector(".cart-total-left");
    private final static By priceValueSel = By.cssSelector(".cart-total-right");
    private final static By tosSel = By.cssSelector("#termsofservice");
    private final static By checkoutBtnSel = By.cssSelector("#checkout");

    public TotalComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step(value = "Verify checkout prices")
    public Map<String, Double> priceCategories(){
        Map<String, Double> priceCategories = new HashMap<>();
        List<WebElement> priceTableRowElems = component.findElements(priceTableRowsSel);
        for (WebElement tableRowElem : priceTableRowElems) {
            WebElement priceTypeElem = tableRowElem.findElement(priceTypeSel);
            WebElement priceValueElem = tableRowElem.findElement(priceValueSel);
            String priceType = priceTypeElem.getText().trim();
            double priceValue = Double.parseDouble(priceValueElem.getText().trim());
            priceCategories.put(priceType, priceValue);
        }
        return priceCategories;
    }

    public TotalComponent agreeTOS(){
        component.findElement(tosSel).click();
        return this;
    }

    public void clickOnCheckoutBtn(){
        component.findElement(checkoutBtnSel).click();
    }
}
