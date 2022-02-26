package test.global;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.BaseTest;
import url.Urls;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginUserPass extends BaseTest implements Urls {
    private static final By userNameLogin = By.id("login");
    private static final By passwordLogin = By.id("password");
    private static final By buttonLogin = By.xpath("//button[contains(text(),'Log in')]");
    private static final By buttonInventory = By.xpath("//a[@id='result_app_1']");
    private static final By buttonProducts = By.xpath("//header/nav[1]/div[1]/div[2]/button[1]");
    private static final By buttonProductElem = By.xpath("//a[contains(text(),'Products')]");
    private static final By createProduct = By.xpath("//button[contains(text(),'Create')]");
    private static final By productName = By.xpath("//*[@name='name']");
    private static final By unitOfMeasure = By.xpath("//input[@class='o_input ui-autocomplete-input']");
    private static final By salesPrice = By.xpath("//input[@class='o_input']");
    private static final By cost = By.xpath("//div[@name='standard_price']//input[@class='o_input']");
    private static final By productCategory = By.xpath("//div[@name='categ_id']//input[@class='o_input ui-autocomplete-input']");
    private static final By internalReference = By.xpath("//input[@name='default_code']");
    private static final By barcode = By.xpath("//input[@name='barcode']");
    private static final By internalNote = By.xpath("//div[@class='note-editable odoo-editor-editable']");
    private static final By selectInventory = By.xpath("//div[@class='o_notebook_headers']//a[text()='Inventory']");
    private static final By buttonSubmitImg = By.xpath("//div[@class='o_form_image_controls']//button[@title='Edit']");
    private static final By btnSaveProduct = By.xpath("//div[@class='o_form_buttons_edit']//button[@title='Save record']");
    private String productNameToSearch = "";
    private static final By productSearch = By.xpath("//i[@title='Remove']");
    private static final By contentSearch = By.xpath("//div[@class='o_searchview_input_container']//input[@class='o_searchview_input']");
    private static final By selectProductSearch = By.xpath("//div[@class='o_kanban_image mr-1']");



    public WebElement usernameLog() {
        return this.driver.findElement(userNameLogin);
    }

    public WebElement passwordLog() {
        return this.driver.findElement(passwordLogin);
    }

    public WebElement submitBtn() {
        return this.driver.findElement(buttonLogin);
    }

    public WebElement submitBtnInventory() {
        return this.driver.findElement(buttonInventory);
    }

    public WebElement clickBtnProducts() {
        return this.driver.findElement(buttonProducts);
    }

    public WebElement clickBtnProductElem() {
        return this.driver.findElement(buttonProductElem);
    }

    public WebElement createNewProduct() {
        return this.driver.findElement(createProduct);
    }

    public WebElement typeProductName() {
        return this.driver.findElement(productName);
    }

    public WebElement selectUnitOfMeasure() {
        return this.driver.findElement(unitOfMeasure);
    }

    public WebElement salePriceColumn() {
        return this.driver.findElement(salesPrice);
    }

    public WebElement costColumn() {
        return this.driver.findElement(cost);
    }

    public WebElement productCategoryColumn() {
        return this.driver.findElement(productCategory);
    }

    public WebElement internalReference() {
        return this.driver.findElement(internalReference);
    }

    public WebElement barcodeColumn() {
        return this.driver.findElement(barcode);
    }

    public WebElement internalNote() {
        return this.driver.findElement(internalNote);
    }

    public WebElement selectInventoryColumn() {
        return this.driver.findElement(selectInventory);
    }

    public WebElement submitImgProduct() {
        return this.driver.findElement(buttonSubmitImg);
    }

    public WebElement saveProductBtn() {
        return this.driver.findElement(btnSaveProduct);
    }


    public WebElement btnCloseSearchProduct() {
        return this.driver.findElement(productSearch);
    }

    public WebElement searchProductFollowName() {
        return this.driver.findElement(contentSearch);
    }

    public WebElement selectProduct() {
        return this.driver.findElement(selectProductSearch);
    }

    public int generateRandomInt() {
        int min = 1;
        int max = 3;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

    public String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;

    }


    public String randomUnits() {
        String[] units = {"mm", "g", "cm", "in³", "in", "oz", "fl oz (US)", "ft²", "Hours", "ft", "lb", "qt (US)", "Units",
                "Days", "m", "m²", "L", "kg", "gal (US)", "Dozens"};
        Random r = new Random();
        int randomNumber = r.nextInt(units.length);
        return units[randomNumber];
    }

    public String randomProductName(){
        String[] names = {"ONEset","Vortex Bottle","Terra Shsave","Swish Wallet","Onovo Supply","Sharpy Knife",
        "Towlee","Rhino Case","Mono","Handy Mop"};
        Random r = new Random();
        int randomNumber = r.nextInt(names.length);
        productNameToSearch = names[randomNumber];
        return names[randomNumber];
    }

    public String randomProductCategory() {
        String[] units = {"All", "All / Expenses", "All / Saleable"};
        Random r = new Random();
        int randomNumber = r.nextInt(units.length);
        return units[randomNumber];
    }

    public String randomNumber() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high - low) + low;
        String value;
        return value = String.valueOf(result);
    }

    @Test(priority = 0)
    public void testFormLogin() {
        driver.get(BASE_URL.concat(LOGIN_FORM));
        try {
            usernameLog().sendKeys("user@aspireapp.com");
            passwordLog().sendKeys("@sp1r3app");
            submitBtn().click();
            submitBtnInventory().click();
            clickBtnProducts().click();
            clickBtnProductElem().click();
            createNewProduct().click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void testProduct() {
        driver.get(BASE_URL.concat(PRODUCT_PAGE));
        try {
            typeProductName().sendKeys(randomProductName());


            Select productType = new Select(driver.findElement(By.xpath("//*[@name='detailed_type']")));
            productType.selectByIndex(3);
            WebDriverWait wait = new WebDriverWait(driver, 2);
            selectUnitOfMeasure().click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'ui-id-1')]")));
            selectUnitOfMeasure().clear();
            selectUnitOfMeasure().sendKeys(randomUnits());

            //click outside
            driver.findElement(By.xpath("//html")).click();

            Thread.sleep(1000);
            salePriceColumn().clear();
            salePriceColumn().sendKeys(randomNumber());

            //cost
            Thread.sleep(1000);
            costColumn().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            costColumn().sendKeys(randomNumber());

            //Product Category
            WebDriverWait waitCategory = new WebDriverWait(driver, 2);
            productCategoryColumn().click();
            waitCategory.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'ui-id-3')]")));
            productCategoryColumn().clear();
            productCategoryColumn().sendKeys(randomProductCategory());
            driver.findElement(By.xpath("//html")).click();

            //Internal Reference
            internalReference().sendKeys(generateRandomString());
            //Barcode
            barcodeColumn().sendKeys(generateRandomString());
            //Internal Notes
            internalNote().sendKeys(generateRandomString());


            //Inventory
            selectInventoryColumn().click();
            driver.findElement(By.xpath("//html")).click();

            // upload img

            //save product
            saveProductBtn().click();
            clickBtnProducts().click();
            clickBtnProductElem().click();
            System.out.println("My value " + productNameToSearch);

            btnCloseSearchProduct().click();
            searchProductFollowName().sendKeys(productNameToSearch+ "\n");
            selectProduct().click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





