package test.global;

import driver.DriverFactory;
import models.components.global.header.HeaderComponent;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class HeaderTest implements Urls {
    public static void main(String[] args) {
        testHomepageHeader();
//        testRegisterPageHeader();
    }

    private static void testHomepageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL.concat(HOME_PAGE));
        try {
            HomePage homePage = new HomePage(driver);

            HeaderComponent headerComponent = homePage.headerComp();
            headerComponent.searchInputElem().sendKeys("Laptop");
            System.out.println("All Links : " + headerComponent.allLinksNumber());
            headerComponent.searchInputBtn().click();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void testRegisterPageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL.concat(REGISTER_PAGE));
        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.headerComp().searchInputElem().sendKeys("Laptop");
            registerPage.headerComp().searchInputBtn().click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

}
