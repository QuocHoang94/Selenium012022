package test_flow.global;

import models.components.global.footer.*;
import models.pages.BasePage;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(Class<? extends BasePage> pageClass) {
        BasePage page = null;
        try {
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FooterComponent footerComponent = page.footerComponent();

        verifyInformationColumn(footerComponent);
        if(page instanceof HomePage){
            System.out.println("HomePage | verifyCustomerColumn...");
            verifyCustomerColumn(footerComponent);
        }
        verifyMyAccountColumn(footerComponent);
        verifyFollowUsColumn(footerComponent);
    }

    private void verifyInformationColumn(FooterComponent footerComponent) {
        InformationColunmComponent informationColunmComponent =
                footerComponent.informationColunmComponent();
        String actualColumnTitle = informationColunmComponent.headerElem().getText().trim();
        String expectedTitle = "INFORMATION";
        Assert.assertEquals(actualColumnTitle, expectedTitle, "[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                "About us", "Contact us");
        List<String> expectedLinkHrefs = Arrays.asList(
                "/sitemap", "/shipping-returns", "/privacy-policy", "/conditions-of-use",
                "/about-us", "/contactus");
        verifyColumnData(informationColunmComponent, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyCustomerColumn(FooterComponent footerComponent) {
        CustomerServiceColunmComponent customerServiceColumnComp =
                footerComponent.customerServiceColunmComponent();
        String actualColumnTitle = customerServiceColumnComp.headerElem().getText().trim();
        String expectedTitle = "CUSTOMER SERVICE";
        Assert.assertEquals(actualColumnTitle, expectedTitle, "[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList(
                "Search", "News", "Blog", "Recently viewed products",
                "Compare products list", "New products");
        List<String> expectedLinkHrefs = Arrays.asList(
                "/search", "/news", "/blog", "/recentlyviewedproducts",
                "/compareproducts", "/newproducts");
        verifyColumnData(customerServiceColumnComp, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyMyAccountColumn(FooterComponent footerComponent) {
        AccountColunmComponent accountColunmComponent =
                footerComponent.accountColunmComponent();
        String actualColumnTitle = accountColunmComponent.headerElem().getText().trim();
        String expectedTitle = "MY ACCOUNT";
        Assert.assertEquals(actualColumnTitle, expectedTitle, "[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList(
                "My account", "Orders", "Addresses", "Shopping cart",
                "Wishlist");
        List<String> expectedLinkHrefs = Arrays.asList(
                "/customer/info", "/customer/orders", "/customer/addresses", "/cart",
                "/wishlist");
        verifyColumnData(accountColunmComponent, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyFollowUsColumn(FooterComponent footerComponent) {
        FolllowUsColunmComponent folllowUsColunmComponent =
                footerComponent.folllowUsColunmComponent();
        String actualColumnTitle = folllowUsColunmComponent.headerElem().getText().trim();
        String expectedTitle = "FOLLOW US";
        Assert.assertEquals(actualColumnTitle, expectedTitle, "[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList(
                "Facebook", "Twitter", "RSS", "YouTube",
                "Google+");
        List<String> expectedLinkHrefs = Arrays.asList(
                "http://www.facebook.com/nopCommerce", "https://twitter.com/nopCommerce", "/news/rss/1", "http://www.youtube.com/user/nopCommerce",
                "https://plus.google.com/+nopcommerce");
        verifyColumnData(folllowUsColunmComponent, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyColumnData(FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedLinkHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHrefs = new ArrayList<>();

        for (WebElement link : footerColumnComp.linkElems()) {
            actualLinkTexts.add(link.getText().trim());
            actualLinkHrefs.add(link.getAttribute("href"));
        }

        if (actualLinkTexts.isEmpty() || actualLinkHrefs.isEmpty()) {
            Assert.fail("[ERR] Texts or hyperlinks is empty");
        }

        //Link text verification
        Assert.assertTrue(actualLinkTexts.size() == expectedLinkTexts.size(),
                "[ERR] Texts in footer column is incorrect");
        for (String actualLinkText : actualLinkTexts) {
            System.out.println(actualLinkText);
            Assert.assertTrue(expectedLinkTexts.contains(actualLinkText), "[ERR]" + actualLinkText + "is incorrect value!");
        }

        // Verify Link href
        Assert.assertTrue(actualLinkHrefs.size() == expectedLinkHrefs.size(),
                "[ERR] Texts in footer column is incorrect");
        for (String actualLinkHref : actualLinkHrefs) {
            System.out.println(actualLinkHref);
            Assert.assertTrue(actualLinkHrefs.contains(actualLinkHref), "[ERR]" + actualLinkHref + "is incorrect value!");
        }

    }

}
