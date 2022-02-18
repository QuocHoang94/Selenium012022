package test.global;

import models.pages.CategoryPage;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flow.global.FooterTestFlow;
import url.Urls;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class FooterTest extends BaseTest implements Urls {

    @Test
    public void testHomepageFooter() {
        driver.get(BASE_URL.concat(HOME_PAGE));
        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent(HomePage.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testRegisterPageFooter() {
        driver.get(BASE_URL.concat(REGISTER_PAGE));
        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent(RegisterPage.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCategoryPageFooter() {
        List<String> categorySlugs = Arrays.asList("/books", "/computers", "/electronics");
        String randomSlug = categorySlugs.get(new SecureRandom().nextInt(categorySlugs.size()));
        driver.get(BASE_URL.concat(randomSlug));
        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent(CategoryPage.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
