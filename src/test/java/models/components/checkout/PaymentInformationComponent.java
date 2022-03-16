package models.components.checkout;

import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import test_data.CreditCardType;

@ComponentCssSelector(value = "#opc-payment_info")
public class PaymentInformationComponent extends Component {

    private static final By creditCardDropdownSel = By.cssSelector("#CreditCardType");
    private static final By cardHolderNameSel = By.cssSelector("#CardholderName");
    private static final By cardNumberSel = By.cssSelector("#CardNumber");
    private static final By cardExpiredMonthDropdownSel = By.cssSelector("#ExpireMonth");
    private static final By cardExpiredYearDropdownSel = By.cssSelector("#ExpireYear");
    private static final By cardCodeSel = By.cssSelector("#CardCode");
    private static final By purchaseNumSel = By.cssSelector("#PurchaseOrderNumber");
    private static final By continueBtnSel = By.cssSelector(".payment-info-next-step-button");

    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectCarType(CreditCardType creditCardType){
        Select select = new Select(component.findElement(creditCardDropdownSel));
        switch (creditCardType){
            case VISA:
                select.selectByVisibleText("Visa");
                break;
            case MASTER_CARD:
                select.selectByVisibleText("Master card");
                break;
            case DISCOVER:
                select.selectByVisibleText("Discover");
                break;
            case AMEX:
                select.selectByVisibleText("Amex");
                break;
            default:
                throw new IllegalArgumentException("Credit card type can't be null!");
        }
    }

    public void inputCardHolderName(String name){
        component.findElement(cardHolderNameSel).sendKeys(name);
    }

    public void inputCardNumber(String number){
        component.findElement(cardNumberSel).sendKeys(number);
    }

    public void inputExpiredMonth(String month){
        Select select = new Select(component.findElement(cardExpiredMonthDropdownSel));
        select.selectByValue(month);
    }

    public void inputExpiredYear(String year){
        Select select = new Select(component.findElement(cardExpiredYearDropdownSel));
        select.selectByVisibleText(year);
    }

    public void inputCardCode(String code){
        component.findElement(cardCodeSel).sendKeys(code);
    }

    public void inputPurchaseOrderNum(String number){
        component.findElement(purchaseNumSel).sendKeys(number);
    }

    public void clickOnContinueBtn(){
        WebElement continueBtnElem = component.findElement(continueBtnSel);
        continueBtnElem.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtnElem));
    }
}
