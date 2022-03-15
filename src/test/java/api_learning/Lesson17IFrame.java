package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class Lesson17IFrame implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to the test page
            driver.get(BASE_URL.concat(IFRAME));

            // Switch to iFrame
            WebElement iFrameElem = driver.findElement(By.cssSelector("[id$='ifr']"));
            driver.switchTo().frame(iFrameElem);

            // Clear default text then input a new one
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.clear();
            editorInputElem.sendKeys("This is the new texts");

            // Switch back to default frame
            driver.switchTo().defaultContent();

            Thread.sleep(3000);

            // Another interactions continue here......

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
