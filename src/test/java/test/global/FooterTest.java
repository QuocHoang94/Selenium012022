package test.global;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class FooterTest implements Urls {
    public static void main(String[] args) {
        testHomepageFooter();
    }

    private static void testHomepageFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL.concat(HOME_PAGE));
        try {
            HomePage homePage = new HomePage(driver);

            FooterComponent footerComponent = homePage.footerComponent();

            InformationColunmComponent informationColunmComponent =
                    footerComponent.informationColunmComponent();
            CustomerServiceColunmComponent customerServiceColumnComp =
                    footerComponent.customerServiceColunmComponent();
            AccountColunmComponent accountColunmComponent =
                    footerComponent.accountColunmComponent();
            FolllowUsColunmComponent folllowUsColunmComponent =
                    footerComponent.folllowUsColunmComponent();

            GenericTestFlow genericTestFlow = new GenericTestFlow(driver);
            genericTestFlow.testFooterColunm(informationColunmComponent);
            genericTestFlow.testFooterColunm(customerServiceColumnComp);
            genericTestFlow.testFooterColunm(accountColunmComponent);
            genericTestFlow.testFooterColunm(folllowUsColunmComponent);
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
