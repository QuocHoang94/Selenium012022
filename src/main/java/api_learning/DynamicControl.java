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
            List<WebElement> btnElems = driver.findElements(By.cssSelector("button"));
            final int REMOVE_SECTION_BTN_INDEX = 0;
            final int ENABLE_SECTION_BTN_INDEX = 1;

            btnElems.get(REMOVE_SECTION_BTN_INDEX).click();
            btnElems.get(ENABLE_SECTION_BTN_INDEX).click();

            System.out.println(btnElems.size());

            List<WebElement> taolaoElems = driver.findElements(By.className("taolao"));
            System.out.println(taolaoElems.isEmpty());

            if(taolaoElems.isEmpty())
                throw new RuntimeException("The List X is empty");


            for (WebElement taolaoElem : taolaoElems) {
                // Verification points related to taolaoElem
            }

            // How to check an element is not on that page


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
