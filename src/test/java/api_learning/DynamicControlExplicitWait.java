package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class DynamicControlExplicitWait implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_PAGE));
            // Find the checkbox-example form
//            WebElement checkboxExampleFormElm = driver.findElement(By.id("checkbox-example"));
//            // Find the button in the checkbox-example form
//            WebElement checkboxExampleFormBtnElem = checkboxExampleFormElm.findElement(By.cssSelector("button"));
//            checkboxExampleFormBtnElem.click();

            // Wait until msg display
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
//            WebElement checkBoxMsgElem = checkboxExampleFormElm.findElement(By.id("message"));
//            wait.until(ExpectedConditions.invisibilityOf(checkboxExampleFormElm.findElement(By.tagName("input"))));
            // Get the message content
//            WebElement checkBoxMsgElem = wait.until(ExpectedConditions.visibilityOf(checkboxExampleFormElm.findElement(By.id("message"))));
//            WebElement checkBoxMsgElem = checkboxExampleFormElm.findElement(By.id("message"));
//            System.out.println(checkBoxMsgElem.getText());


            // checkbox-example form
            WebElement inputExampleFormElem = driver.findElement(By.id("input-example"));
            // Find the button in the input-example form

            WebElement inputExampleFormBtnElem = inputExampleFormElem.findElement(By.cssSelector("button"));
            inputExampleFormBtnElem.click();

//            wait.until(ExpectedConditions.elementSelectionStateToBe(inputExampleFormElem.findElement(By.tagName("input")),true);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example input")));
            inputExampleFormElem.findElement(By.tagName("input")).sendKeys("TEO");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
