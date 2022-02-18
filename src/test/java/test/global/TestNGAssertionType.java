package test.global;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertionType {

    @Test
    public void testHardAssertion(){
        Assert.assertEquals(1,2,"[ERR] Now 1 == 2");
        try{
            Assert.assertEquals(1,2,"[ERR] Now 1 == 2");
        }catch(Exception ignored){}
        System.out.println("Hello");
    }

    @Test
    public void testSoftAssertion(){
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(1,2, "[ERR] Now 1 == 2");
        Assert.assertEquals(1,21, "[ERR] Now 1 != 1");
        softAssert.assertAll();
    }
}
