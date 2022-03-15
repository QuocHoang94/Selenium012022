package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling {

    public static void main(String[] args) throws InterruptedException {
        // class method | getChromeDriver | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            // Find username/password Element by using username/password selector
            // POST /session/{sessionID}/element --- {selector: ...}
            WebElement usernameElem = driver.findElement(By.id("username"));
            WebElement passwordElem = driver.findElement(By.cssSelector("#password"));

            // Input username and password
            usernameElem.sendKeys("teo");
            usernameElem.clear();
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("87654321");
            passwordElem.clear();
            passwordElem.sendKeys("SuperSecretPassword!");

            WebElement clickLoginBtnElem = driver.findElement(By.cssSelector("#login button[type='submit']"));
            clickLoginBtnElem.click();

            Thread.sleep(3000);
        } finally {
            // Quit driver session
            driver.quit();
        }

    }
}
