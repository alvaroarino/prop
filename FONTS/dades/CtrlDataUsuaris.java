package dades;

import com.google.gson.*;
import domain.usuari.Perfil;
import domain.usuari.Usuari;

import java.io.*;
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
        ArrayList<Usuari> cjtUsuaris = new ArrayList<>();

        Reader reader = new FileReader("users.json");
        try {
            JsonArray json = gson.fromJson(reader, JsonArray.class);
            for (JsonElement data : json) {
                JsonObject obj = data.getAsJsonObject();
                System.out.println(obj);
                Usuari user = new Usuari();
                user.fromJson(obj);
                cjtUsuaris.add(user);
            }
            cjtUsuaris.forEach((usuari) -> {
                System.out.println(usuari.getNom());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cjtUsuaris;
    }

    public void updateData(ArrayList<Usuari> cjtUsuaris) {
        JsonArray array = new JsonArray();
        for (Usuari usuari: cjtUsuaris) {
            // Guardo las propiedades basicas
            JsonObject userJSON = new JsonObject();
            userJSON.addProperty("id", usuari.getId());
            userJSON.addProperty("name", usuari.getNom());
            userJSON.addProperty("username", usuari.getUsername());
            userJSON.addProperty("password", usuari.getPass());

            // Creo el Array de perfiles i lo guardo como JSON
            JsonArray profiles = new JsonArray();
            ArrayList<Perfil> perfils = usuari.getPerfils();
            for (Perfil p : perfils) {
                JsonObject perfilObject = new JsonObject();
                perfilObject.addProperty("id", p.getId());
                perfilObject.addProperty("nom", p.getNom());
                profiles.add(perfilObject);
            }

            userJSON.add("profile", profiles);

            // Guardo el usuario en el Array de JSON
            array.add(userJSON);
        }
        // Escribo en el archivo
        try (FileWriter file = new FileWriter("users.json")) {
            file.write(array.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
