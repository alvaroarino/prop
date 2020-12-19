package dades;

import com.google.gson.*;
import domain.usuari.Usuari;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CtrlDataUsuaris {
    private static CtrlDataUsuaris singletonObject;

    public static CtrlDataUsuaris getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataUsuaris() {
            };
        return singletonObject;
    }

    private CtrlDataUsuaris() {}

    public ArrayList<Usuari> getData() throws IOException {
        Gson gson = new Gson();
        ArrayList<Usuari> cjtUsuaris = new ArrayList();
        String soPathSeparator = System.getProperty("file.separator");
        Reader reader = new FileReader("data-files" + soPathSeparator + "users.json");
        try {
            JsonArray json = gson.fromJson(reader, JsonArray.class);
            for (JsonElement data : json) {
                JsonObject obj = data.getAsJsonObject();
                Usuari user = new Usuari();
                user.fromJson(obj);
                cjtUsuaris.add(user);
            }
            cjtUsuaris.forEach((usuari) -> {
                System.out.println(usuari.getNom());
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return cjtUsuaris;
    }

    public void updateData(ArrayList<Usuari> cjtUsuaris) {

    }
}
