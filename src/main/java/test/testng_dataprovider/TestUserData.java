package test.testng_dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.User;
import utils.data.DataObjectBuilder;

public class TestUserData {

    @Test(dataProvider = "userData")
    public void testUserDataCollection(User userData) {
        Assert.assertTrue(userData.getName().startsWith("T"), "[ERR] name is not started with T");
        Assert.assertTrue(userData.getAge() >=18, "[ERR] Age is less than 18");
    }

    @DataProvider()
    public User[] userData(){
        String jsonFileLocation = "/src/main/resources/test-data/User.json";
        return DataObjectBuilder.buildDataObjectFrom(jsonFileLocation, User[].class);
    }
}
