package models.components.order;

import io.qameta.allure.Step;
import models.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseItemDetailsComponent extends Component {

    private final By barNotificationContentSel = By.cssSelector("#bar-notification p");
    private final By productPriceSel = By.cssSelector(".product-price");
    private final By productQuantitySel = By.cssSelector(".qty-input");
    private final By addToCartBtnSel = By.cssSelector(".add-to-cart-button");

    public BaseItemDetailsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double productPrice(){
        String productPriceText = component.findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceText);
    }

    @Step("Set product quantity as {quantity}")
    public void setProductQuantity(int quantity){
        WebElement productQuantityElem = component.findElement(productQuantitySel);
        productQuantityElem.clear();
        productQuantityElem.sendKeys(String.valueOf(quantity));
    }

    @Step("Click on [Add To Cart] button")
    public void clickOnAddToCartBtn(){
        component.findElement(addToCartBtnSel).click();
    }

    @Step("Wait until item added to cart")
    public void waitUntilItemAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String successAddToCartStr = "The product has been added to your shopping cart";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(barNotificationContentSel, successAddToCartStr));
    }


}
