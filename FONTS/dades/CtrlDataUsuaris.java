package dades;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

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

        try (Reader reader = new FileReader("FONTS/data-files/users.json")) {
            // Convert JSON to JsonElement, and later to String
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            String data = gson.toJson(json);
            System.out.println(data);
            return data;

        }
    }

    public String writeData() {
        return "TODO: Implement the function writeData()";
    }
}
