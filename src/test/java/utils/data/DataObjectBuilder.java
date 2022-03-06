package utils.data;

import com.google.gson.Gson;
import test_data.User;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T buildDataObjectFrom(String jsonDataFileLocation, Class<T> dataType) {
        T data = null;
        String currentProjectLocation = System.getProperty("user.dir");

        try (Reader jsonContentReader = Files.newBufferedReader(Paths.get(currentProjectLocation + jsonDataFileLocation))) {

            Gson gson = new Gson();
            data = gson.fromJson(jsonContentReader, dataType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
