package test_data;

import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        testFromObjectToJson();
//        testFromJsonToObject();
    }

    private static void testFromObjectToJson() {
        User user  = new User("teo",20);
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
    }

    private static void testFromJsonToObject() {
        String userJSONObject = "{\n" +
                "  \"name\": \"Teo\",\n" +
                "  \"age\": 18\n" +
                "}";
        User user;
        Gson gson = new Gson();
        user = gson.fromJson(userJSONObject, User.class);
        System.out.println(user);

        System.out.println(user.getAge() + 1);
    }
}
