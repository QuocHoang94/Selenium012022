package models.components.order;

import models.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemDetailComponent extends Component {

    private final By productPriceSel = By.cssSelector(".product-price");
    private final By productQuantitySel = By.cssSelector(".qty-input");
    private final By addToCartBtnSel = By.cssSelector(".add-to-cart-button");

    public BaseItemDetailComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double productPrice() {
        String productPriceText = component.findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceText);
    }

    // bye short int long
    public void setProductQuantity(int quantity) {
        WebElement productQuantityElem = component.findElement(productQuantitySel);
        productQuantityElem.clear();
        productQuantityElem.sendKeys(String.valueOf(quantity));
    }

    public void clickOnAddToCartBtn() {
        component.findElement(addToCartBtnSel).click();
    }
}
