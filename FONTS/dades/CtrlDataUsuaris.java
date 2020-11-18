package dades;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * The type Ctr usuaris data.
 *
 * @author Alvaro Ariño Cabau
 */
public class CtrlDataUsuaris {
    private static CtrlDataUsuaris singletonObject;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDataUsuaris getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataUsuaris() {
            };
        return singletonObject;
    }

    /** Constructora privada. **/

    private CtrlDataUsuaris() {}

    /**
     * Obtenir les dades del fitxer d'usuaris.
     *
     * @return the data
     * @throws IOException the io exception
     */
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

    /**
     * Write data string.
     *
     * @return the string
     */
    public String writeData() {
        return "TODO: Implement the function writeData()";
    }
}
