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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));

            /*// checkbox-example form
            WebElement checkboxExampleFormElem = driver.findElement(By.id("checkbox-example"));
            WebElement checkboxExampleFormBtnElem = checkboxExampleFormElem.findElement(By.cssSelector("button"));
            checkboxExampleFormBtnElem.click();

            // Wait until checkbox disappeared | Explicitly Wait | Strategy 01
//            wait.until(ExpectedConditions.invisibilityOf(checkboxExampleFormElem.findElement(By.tagName("input"))));

            // Wait until msg appeared | Explicitly Wait | Strategy 02
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            WebElement checkBoxMsgElem = checkboxExampleFormElem.findElement(By.id("message"));

            // Get the message content
            System.out.println(checkBoxMsgElem.getText());*/


            // ============================================

            // input-example form
            WebElement inputExampleFormElem = driver.findElement(By.id("input-example"));
            // Find the button in the input-example form
            WebElement inputExampleFormBtnElem = inputExampleFormElem.findElement(By.cssSelector("button"));
            inputExampleFormBtnElem.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example input")));
            inputExampleFormElem.findElement(By.tagName("input")).sendKeys("TEO");

            Thread.sleep(3000);
            System.out.println(inputExampleFormBtnElem.getCssValue("background-color"));
            System.out.println(inputExampleFormBtnElem.getCssValue("border-bottom-color"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
