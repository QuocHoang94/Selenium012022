package test.global;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertionType {

    @Test
    public void testHardAssertion() {
        try {
            Assert.assertEquals(1, 2, "[ERR] Now 1 == 2");
        } catch (Exception ignored){

            System.out.println("Hello!");
        }
    }

    @Test
    public void testSoftAssertion() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2, "[ERR] Now 1 == 2");
        softAssert.assertEquals(1, 1, "[ERR] Now 1 != 1");
//        softAssert.assertAll();
    }
}