package models.components.order;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ComputerEssentialComponent extends BaseItemDetailsComponent {

    private static final By allOptionsSel = By.cssSelector(".option-list input");

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType(String type);
    public abstract String selectRAMType(String type);

    @Step("Unselect all default options")
    public void unselectDefaultOptions(){
        List<WebElement> allOptionElems = component.findElements(allOptionsSel);
        allOptionElems.forEach(option -> {
            if(option.getAttribute("checked") != null){
                option.click();
            }
        });
    }

    protected String selectCompSpecOption(String option){
        String selectorString = "//label[contains(text(), \"" + option + "\")]";
        By optionSel = By.xpath(selectorString);
        WebElement optionElem = null;
        try {
            optionElem = component.findElement(optionSel);
        } catch (Exception ignored){}

        if(optionElem != null){
            optionElem.click();
            return optionElem.getText();
        } else {
            throw new RuntimeException("The option: " + option + " is not existing to select!");
        }
    }

    @Step("Select HDD type as {hddType}")
    public String selectHDD(String hddType){
        return selectCompSpecOption(hddType);
    }

    @Step("Select OS type as {osType}")
    public String selectOS(String osType){
        return selectCompSpecOption(osType);
    }


    @Step("Select software type as {softwareType}")
    public String selectSoftware(String softwareType){
        return selectCompSpecOption(softwareType);
    }

}
