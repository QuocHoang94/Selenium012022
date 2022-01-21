package test.global;

import org.testng.Assert;
import org.testng.annotations.Test;
import url.Urls;

public class FooterTestCopy implements Urls {

    private static Boolean isLoginSuccess;

    @Test
    public void testHomepageFooterCopy() {
        System.out.println("testHomepageFooter");
    }

    @Test(priority = 2)
    public void anotherTestMethodCopy() {
        if (isLoginSuccess)
            System.out.println("anotherTestMethod");
    }

    @Test(priority = 1)
    public void importantMethod() {
//        Assert.fail();
        isLoginSuccess = false;
//        System.out.println("importantMethod");
    }


}
