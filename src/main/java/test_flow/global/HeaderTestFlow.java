package test_flow.global;

import models.components.global.header.HeaderComponent;
import models.components.global.header.LogoComponent;
import models.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderTestFlow {

    private WebDriver driver;

    public HeaderTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHeaderComponent(Class<? extends BasePage> pageClass){
        BasePage page = null;
        try {
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e){
            e.printStackTrace();
        }

        HeaderComponent headerComp = page.headerComp();
        LogoComponent logoComp = headerComp.logoComp();

        System.out.println("Logo link: " + logoComp.logoLinkElem().getAttribute("href"));
        System.out.println("Logo img src: " + logoComp.logoImgElem().getAttribute("src"));

        Dimension logoSize = logoComp.logoImgElem().getSize();
        int logoWidth = logoSize.getWidth();
        int logoHeight = logoSize.getHeight();
        boolean isImgBroken = logoWidth < 300 || logoHeight < 40;
        Assert.assertTrue(logoComp.logoImgElem().isDisplayed(), "[ERR] Logo is invisible!");
        Assert.assertFalse(isImgBroken, "[ERR] Logo img is broken!");
    }
}
