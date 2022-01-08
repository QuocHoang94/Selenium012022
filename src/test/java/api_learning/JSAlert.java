package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JSAlert implements Urls {

    private static final By jsAlertSel = By.cssSelector("[onclick='jsAlert()']");
    private static final By jsConfirmSel = By.cssSelector("[onclick='jsConfirm()']");
    private static final By jsPrompSel = By.cssSelector("[onclick='jsPrompt()']");
    private static final By resultSel = By.id("result");

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Navigate to the test page
            driver.get(BASE_URL.concat(JAVASCRIPT_ALERTS));
            WebElement resultElem = driver.findElement(resultSel);

            // JS ALERT
            driver.findElement(jsAlertSel).click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("JS ALERT CONTENT: " + jsAlert.getText());
            Thread.sleep(2000);
            jsAlert.accept();
            System.out.println(resultElem.getText());
            System.out.println("=================");
            driver.navigate().refresh();
            // JS CONFIRM

            driver.findElement(jsConfirmSel).click();
            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("JS Confirm CONTENT: " + jsConfirm.getText());
            Thread.sleep(2000);
            jsAlert.dismiss();
            resultElem = driver.findElement(resultSel);
            System.out.println(resultElem.getText());
            Thread.sleep(2000);
            System.out.println("=================");

            // JS PROMPT
            driver.findElement(jsPrompSel).click();
            Alert jsPrompSel = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("JS Confirm CONTENT: " + jsPrompSel.getText());
            Thread.sleep(2000);
            jsPrompSel.sendKeys("This is my message!");
            jsPrompSel.accept();
            System.out.println(resultElem.getText());
            Thread.sleep(2000);
            System.out.println("=================");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
