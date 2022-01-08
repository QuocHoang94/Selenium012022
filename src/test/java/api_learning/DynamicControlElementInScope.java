package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class DynamicControlElementInScope implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_PAGE));
            // Find the checkbox-example form

            WebElement checkboxExampleFormElm = driver.findElement(By.id("checkbox-example"));
            // Find the button in the checkbox-example form

            WebElement checkboxExampleFormBtnElem = checkboxExampleFormElm.findElement(By.cssSelector("button"));

            // Find input-example form
            WebElement inputExampleFormElm = driver.findElement(By.id("input-example"));
            // Find the button in the input-example form
            WebElement inputExampleFormBtnElem = inputExampleFormElm.findElement(By.cssSelector("button"));


            checkboxExampleFormBtnElem.click();
            inputExampleFormBtnElem.click();

            //Wait to see the results
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
