package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class Iframe implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the test page
            driver.get(BASE_URL.concat(IFRAME));

            // Switch to iframe
            WebElement iFrameElem = driver.findElement(By.cssSelector("[id$='ifr']"));
            driver.switchTo().frame(iFrameElem);

            // clear default text then input a new one
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.clear();
            editorInputElem.sendKeys("ABCXYZ");
            // Switch back to default frame

            driver.switchTo().defaultContent();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
