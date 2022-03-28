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

    public void verifyFooterComponent(Class<? extends BasePage> pageClass){
        BasePage page = null;
        try {
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e){
            e.printStackTrace();
        }
        FooterComponent footerComponent = page.footerComponent();
        verifyInformationColumn(footerComponent);

        // JUST AN EXAMPLE to handle different flow on pages
        if(page instanceof HomePage){
            System.out.println("HomePage | verifyCustomerColumn..... ");
            verifyCustomerColumn(footerComponent);
        }
    }

    private void verifyInformationColumn(FooterComponent footerComponent) {
        InformationColumnComponent informationColumnComp = footerComponent.informationColumnComp();
        String actualColumnTitle = informationColumnComp.headerElem().getText().trim();
        String expectedTitle = "INFORMATION";
        Assert.assertEquals(actualColumnTitle, expectedTitle, "[ERR] Column Title is incorrect!");
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                "About us", "Contact us");
        List<String> expectedLinkHrefs = Arrays.asList(
                "/sitemap", "/shipping-returns", "/privacy-policy", "/conditions-of-use",
                "/about-us", "/contactus");
        verifyColumnData(informationColumnComp, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyCustomerColumn(FooterComponent footerComponent) {
        CustomerServiceColumnComponent customerServiceColumnComp = footerComponent.customerServiceColumnComp();
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

    private void verifyColumnData(FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedLinkHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHrefs = new ArrayList<>();

        for (WebElement link : footerColumnComp.linkElems()) {
            actualLinkTexts.add(link.getText().trim());
            actualLinkHrefs.add(link.getAttribute("href"));
        }

        if(actualLinkTexts.isEmpty() || actualLinkHrefs.isEmpty()){
            Assert.fail("[ERR] Texts or hyperlinks is empty");
        }

        // Link text verification
        Assert.assertTrue(actualLinkTexts.size() == expectedLinkTexts.size(),
                "[ERR] Texts in footer column is incorrect");
        for (String actualLinkText : actualLinkTexts) {
            System.out.println(actualLinkText);
            Assert.assertTrue(expectedLinkTexts.contains(actualLinkText), "[ERR] " + actualLinkText + " is incorrect value!");
        }

        // Verify link href
        Assert.assertTrue(actualLinkHrefs.size() == expectedLinkHrefs.size(),
                "[ERR] Texts in footer column is incorrect");
        for (String actualLinkHref : actualLinkHrefs) {
            System.out.println(actualLinkHref);
            Assert.assertTrue(actualLinkHrefs.contains(actualLinkHref), "[ERR] " + actualLinkHref + " is incorrect value!");
        }
    }
}
