package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

import java.util.List;

public class DynamicControl implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_PAGE));

            // Get list of button on the page
            //https://the-internet.herokuapp.com

            List<WebElement> btnElems = driver.findElements(By.cssSelector("button"));
//            WebElement btnElems = driver.findElement(By.cssSelector("button"));
//            btnElems.click();
//            Thread.sleep(2000);
//            System.out.println(btnElems.size());

            final int REMOVE_SECTION_BTN_INDEX = 0;
            final int ENABLE_SECTION_BTN_INDEX = 1;

            btnElems.get(REMOVE_SECTION_BTN_INDEX).click();
            btnElems.get(ENABLE_SECTION_BTN_INDEX).click();


            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
