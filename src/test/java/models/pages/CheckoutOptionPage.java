package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOptionPage extends BasePage {

    private final static By checkoutAsGuestBtnSel = By.cssSelector("input[class*=\"checkout-as-guest-button\"]");

    public CheckoutOptionPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckoutAsGuestBtn(){
        component.findElement(checkoutAsGuestBtnSel).click();
    }
}
