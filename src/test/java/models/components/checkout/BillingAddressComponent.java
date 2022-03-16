package models.components.checkout;

import io.qameta.allure.Step;
import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

@ComponentCssSelector(value = "#opc-billing")
public class BillingAddressComponent extends Component {

    private final static By inputAddressDropdownSel = By.id("billing-address-select");
    private final static By firstnameSel = By.id("BillingNewAddress_FirstName");
    private final static By lastnameSel = By.id("BillingNewAddress_LastName");
    private final static By emailSel = By.id("BillingNewAddress_Email");
    private final static By selectCountryDropdownSel = By.id("BillingNewAddress_CountryId");
    private final static By selectStateDropdownSel = By.id("BillingNewAddress_StateProvinceId");
    private final static By citySel = By.id("BillingNewAddress_City");
    private final static By add1Sel = By.id("BillingNewAddress_Address1");
    private final static By zipCodeSel = By.id("BillingNewAddress_ZipPostalCode");
    private final static By phoneNoSel = By.id("BillingNewAddress_PhoneNumber");
    private final static By continueBtnSel = By.cssSelector(".new-address-next-step-button");

    public BillingAddressComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step(value = "select input new address")
    public void selectInputNewAddress(){
        if(!component.findElements(inputAddressDropdownSel).isEmpty()){
            Select select = new Select(component.findElement(inputAddressDropdownSel));
            select.selectByVisibleText("New Address");
        }
    }

    @Step(value = "Input firstname as {firstname}")
    public void inputFirstname(String firstname){
        component.findElement(firstnameSel).sendKeys(firstname);
    }

    @Step(value = "Input lastname as {lastname}")
    public void inputLastname(String lastname){
        component.findElement(lastnameSel).sendKeys(lastname);
    }

    @Step(value = "Input email as {email}")
    public void inputEmail(String email){
        component.findElement(emailSel).sendKeys(email);
    }

    @Step(value = "Select country as {country}")
    public void selectCountry(String country){
        Select select = new Select(component.findElement(selectCountryDropdownSel));
        select.selectByVisibleText(country);

        // TODO: wait until country value loaded
    }

    @Step(value = "Select state/province as {state}")
    public void selectState(String state){
        Select select = new Select(component.findElement(selectStateDropdownSel));
        select.selectByVisibleText(state);
    }

    @Step(value = "Input city as {city}")
    public void inputCity(String city){
        component.findElement(citySel).sendKeys(city);
    }

    @Step(value = "Input add1 as {add1}")
    public void inputAdd1(String add1){
        component.findElement(add1Sel).sendKeys(add1);
    }

    @Step(value = "Input zipcode as {zipcode}")
    public void inputZIPCode(String zipcode){
        component.findElement(zipCodeSel).sendKeys(zipcode);
    }

    @Step(value = "Input phoneNo as {phoneNo}")
    public void inputPhoneNo(String phoneNo){
        component.findElement(phoneNoSel).sendKeys(phoneNo);
    }

    @Step(value = "Click on continue button")
    public void clickOnContinueBtn(){
        WebElement continueBtnElem = component.findElement(continueBtnSel);
        continueBtnElem.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtnElem));
    }
}
