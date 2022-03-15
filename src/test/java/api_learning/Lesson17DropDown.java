package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class Lesson17DropDown implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to the test page
            driver.get(BASE_URL.concat(DROPDOWN));

            // Target dropdown
            WebElement dropdownElem = driver.findElement(By.cssSelector("#dropdown"));
            Select select = new Select(dropdownElem);

            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            select.selectByIndex(2);
            Thread.sleep(1000);

            select.selectByValue("1");
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
