package test_data;

import com.google.gson.Gson;
import utils.data.DataObjectBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestGson {
    public static void main(String[] args) {
//        testFromObjectToJson();
        testFromJsonToObject();
    }

    private static void testFromObjectToJson() {
        User user = new User("teo", 20);
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
    }

    private static void testFromJsonToObject() {
        String jsonFileLocation = "/src/test/resources/test-data/User.json";
        User[] users = DataObjectBuilder.buildDataObjectFrom(jsonFileLocation, User[].class);

        for (User user : users) {
            System.out.println(user);
        }
    }
}
