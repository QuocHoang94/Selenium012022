package models.pages;

import models.components.cart.CartItemRowComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItemRowComponent> cartItemRowComponents(){
        return findComponents(CartItemRowComponent.class, driver);
    }

}
