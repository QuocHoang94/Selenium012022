package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class TestDropdown implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(BASE_URL.concat(DROPDOWN));
            WebElement dropdownMain = driver.findElement(By.cssSelector("#dropdown"));
            Select select = new Select(dropdownMain);

            select.selectByValue("1");
            Thread.sleep(2000);

            select.selectByVisibleText("Option 2");
            Thread.sleep(2000);

            select.selectByIndex(1);
            Thread.sleep(2000);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
