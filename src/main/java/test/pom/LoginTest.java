package test.pom;

import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginTest implements Urls {

    public static void main(String[] args) {
        testLoginPageTraditionalPOM();
        testLoginPageMainInteractionMethods();
        testLoginPageMainMethodChaining();
    }

    private static void testLoginPageTraditionalPOM() {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(LOGIN_PAGE));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.usernameElem().sendKeys("teo");
            loginPage.passwordElem().sendKeys("87654321");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void testLoginPageMainInteractionMethods() {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(LOGIN_PAGE));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("___ti");
            loginPage.inputPassword("____87654321");
            loginPage.clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void testLoginPageMainMethodChaining() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN_PAGE));
            LoginPage loginPage = new LoginPage(driver);
            loginPage
                    .inputUsername("___ti")
                    .inputPassword("____87654321")
                    .clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
