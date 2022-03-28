package models.components.order;

import io.qameta.allure.Step;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent {

    public static final By productAttributeSel = By.xpath("//select[contains(@id, 'product_attribute')]");
    public static final int PROCESSOR_DROPDOWN_INDEX = 0;
    public static final int RAM_DROPDOWN_INDEX = 1;

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    @Step("Select processor type as {prefixValue}")
    public String selectProcessorType(String prefixValue) {
        WebElement processorDropdownElem = component.findElements(productAttributeSel).get(PROCESSOR_DROPDOWN_INDEX);
        return selectOption(processorDropdownElem, prefixValue);
    }

    @Override
    @Step("Select RAM type as {prefixValue}")
    public String selectRAMType(String prefixValue) {
        WebElement ramDropdownElem = component.findElements(productAttributeSel).get(RAM_DROPDOWN_INDEX);
        return selectOption(ramDropdownElem, prefixValue);
    }

    private String selectOption(WebElement dropdownElem, String prefixValue){
        Select select = new Select(dropdownElem);
        List<WebElement> allOptions = select.getOptions();
        String fullStrOption = null;
        for (WebElement option : allOptions) {
            String currentOptionText = option.getText();
            String optionText = currentOptionText.trim().replaceAll(" ", ""); // 2.2GHzIntelPentiumCore
            if(optionText.startsWith(prefixValue)){
                fullStrOption = currentOptionText;
                break;
            }
        }

        if(fullStrOption == null){
            throw new IllegalArgumentException("[ERR] the option " + prefixValue + " is not in the dropdown!");
        }

        select.selectByVisibleText(fullStrOption);
        return fullStrOption;
    }
}
