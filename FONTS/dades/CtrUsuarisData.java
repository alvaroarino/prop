package dades;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CtrUsuarisData {
    private static CtrUsuarisData singletonObject;

    public static CtrUsuarisData getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrUsuarisData() {
            };
        return singletonObject;
    }

    /** Constructora privada. **/

    private CtrUsuarisData() {}

    public String getData() throws IOException {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("./data-files/json/users.json")) {

            // Convert JSON to JsonElement, and later to String
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            String data = gson.toJson(json);
            System.out.println(data);
            return data;

        }
    }
}
