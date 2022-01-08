package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.sql.Driver;
import java.time.Duration;

public class Practive_JSAlert implements Urls {
    private static final By jsAlertSel = By.cssSelector("[onclick='jsAlert()']");
    private static final By jsConfirmSel = By.cssSelector("[onclick='jsConfirm()']");
    private static final By jsPromptSel = By.cssSelector("[onclick='jsPrompt()']");
    private static final By resultSel = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(JAVASCRIPT_ALERTS));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//          JS ALERT
//            driver.findElement(jsAlertSel).click();
//            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
//            System.out.println("JS Alert Content" + jsAlert);
//            Thread.sleep(1000);
//            jsAlert.accept();
//            System.out.println(driver.findElement(resultSel).getText());
//            System.out.println("===========================");
//            Thread.sleep(3000);
            // JS Confirm

//            driver.findElement(jsConfirmSel).click();
//            Alert jsConfirmAlert = wait.until(ExpectedConditions.alertIsPresent());
//            System.out.println("====123=======");
//            System.out.println(jsConfirmAlert.getText());
//            System.out.println("====123=======");
//            Thread.sleep(1000);
//            jsConfirmAlert.accept();
//            System.out.println(driver.findElement(resultSel).getText());
//            Thread.sleep(3000);
//          JS PROMPTSEL

            driver.findElement(jsPromptSel).click();
            Alert jsAlertPrompt = wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(2000);
            jsAlertPrompt.sendKeys("Hoang Quoc Tran 123");
            Thread.sleep(2000);
            jsAlertPrompt.accept();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
