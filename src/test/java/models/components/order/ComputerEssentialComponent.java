package models.components.order;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class ComputerEssentialComponent extends BaseItemDetailComponent {

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract void selectProcessorType(String type);

    public abstract void selectRAMType(String type);

    protected void selectCompSpecOption(String option) {
        String selectorString = "//label[contains(text(),\"" + option + "\")]";
        By optionSel = By.xpath(selectorString);
        WebElement optionElem = null;
        try{
            optionElem = component.findElement(optionSel);
        }catch(Exception ignored){}
        if(optionElem != null){
            optionElem.click();
        }else{
            throw new RuntimeException("The option: " + option + "is not existing to select!");
        }
    }

    @Step("Select HDD type as {asType}")
    public void selectHDD(String hddType){
        selectCompSpecOption(hddType);
    }

    @Step("Select OS type as {asType}")
    public  void selectOS(String osType){
        selectCompSpecOption(osType);
    }
}
