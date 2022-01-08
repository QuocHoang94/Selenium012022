package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

import java.sql.Driver;

public class DropdownList implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(BASE_URL.concat(DROPDOWN));
            WebElement elementDropdown = driver.findElement(By.cssSelector("#dropdown"));
            Select select = new Select(elementDropdown);

            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            select.selectByIndex(2);
            Thread.sleep(1000);

            select.selectByValue("1");
            Thread.sleep(1000);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
