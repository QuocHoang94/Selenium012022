package test.pom;

import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginTest implements Urls {
    public static void main(String[] args) {
//        WebDriver driver = DriverFactory.getChromeDriver();
        testLoginPageTraditionalPOM();
        testLoginPageMainInteractionMenthods();
        testLoginPageMainMethodChaining(); // Builder Design Pattern
    }

    // Page Object : traditional way
    private static void testLoginPageTraditionalPOM() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN_PAGE));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.usernameSel().sendKeys("teo");
            loginPage.passwordSel().sendKeys("87654321");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //Page Object : main interaction methods
    private static void testLoginPageMainInteractionMenthods() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN_PAGE));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("___teo");
            loginPage.inputPassword("_87654321_");
            loginPage.clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //Page Object: method chaining
    private static void testLoginPageMainMethodChaining() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN_PAGE));
            LoginPage loginPage = new LoginPage(driver);
            loginPage
                    .inputUsername("___teo")
                    .inputPassword("_87654321_")
                    .clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
