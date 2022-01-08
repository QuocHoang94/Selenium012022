package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Button implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_PAGE));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement content = driver.findElement(By.cssSelector("#input-example"));
            WebElement BtnEnable = content.findElement(By.tagName("button"));
            BtnEnable.click();

            WebElement inputExample = content.findElement(By.tagName("input"));
            wait.until(ExpectedConditions.elementToBeClickable(inputExample));
            inputExample.sendKeys("Hoang Quoc Tran");

            WebElement btnDisable = content.findElement(By.tagName("button"));
            wait.until(ExpectedConditions.elementToBeClickable(btnDisable));
            btnDisable.click();

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
