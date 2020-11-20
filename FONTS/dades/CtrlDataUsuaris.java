package dades;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CtrlDataUsuaris {
    private static CtrlDataUsuaris singletonObject;

    public static CtrlDataUsuaris getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataUsuaris() {
            };
        return singletonObject;
    }

    private CtrlDataUsuaris() {}

    public String getData() throws IOException {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("data-files/users.json")) {
            // Convert JSON to JsonElement, and later to String
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            String data = gson.toJson(json);
            System.out.println(data);
            return data;
        }
    }
}
