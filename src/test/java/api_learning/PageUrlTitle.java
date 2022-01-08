package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class PageUrlTitle {
    public static void main (String[] args){
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get("https://the-internet.herokuapp.com/login");

            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

        }finally {
            // Quit driver session
            driver.quit();
        }
    }
}
