package models.components.order;

import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent {
    public static final By productAttributeSel = By.xpath("//select[contains(@id,'product_attribute')]");
    public static final int PROCESSOR_DROPDOWN_INDEX = 0;
    public static final int RAM_DROPDOWN_INDEX = 1;

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public void selectProcessorType(String prefixValue) {
        WebElement processorDropdownElem = component.findElements(productAttributeSel).get(PROCESSOR_DROPDOWN_INDEX);
        selectOption(processorDropdownElem, prefixValue);
    }

    @Override
    public void selectRAMType(String prefixValue) {
        WebElement ramDropdownElem = component.findElements(productAttributeSel).get(RAM_DROPDOWN_INDEX);
        selectOption(ramDropdownElem, prefixValue);
    }

    private void selectOption(WebElement dropdownElem, String prefixValue){
        Select select = new Select(dropdownElem);
        /*
        2.2 GHz
        1. Get all option texts : 2.2 GHz Intel Pentium Core....; 2.5GHz Intel Pentium Core.....
        2. Get the option which starts with the prefix
        3. Get FULL text of that option
        4. selectBuyVisibleText(FULL)
        * */
//        Get all options
        List<WebElement> allOptions = select.getOptions();
        String fullStrOption = null;
        for (WebElement option : allOptions) {
            String currentOptionText = option.getText();
            String optionText = option.getText().trim().replace(" ", ""); // 2.2GHzIntel Pentium Core
            if (optionText.startsWith(prefixValue)) {
                fullStrOption = currentOptionText;
                break;
            }
        }
        if (fullStrOption == null) {
            throw new IllegalArgumentException("[ERR] the option " + prefixValue + "is not in the dropdown");
        }

        select.selectByVisibleText(fullStrOption);
    }
}
