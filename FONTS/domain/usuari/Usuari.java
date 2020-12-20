package domain.usuari;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Usuari {
    private String _id;
    private String _nom;
    private String _username;
    private String _password;

    private ArrayList<Perfil> _perfils;

    public Usuari() {
        _nom = "";
        _username = "";
        _perfils = new ArrayList<>();
    }

    public Usuari(String nom, String username) {
        this._id = UUID.randomUUID().toString();
        this._nom = nom;
        this._username = username;
        _perfils = new ArrayList<>();
    }

    public String toJson(Usuari user) throws IOException {
        Gson gson = new Gson();
        // 1. Java object to JSON file
        return gson.toJson(user);
    }

    public void fromJson(JsonObject user) {
        this._id = user.get("id").getAsString();
        this._nom = user.get("name").getAsString();
        this._username = user.get("username").getAsString();
        this._password = user.get("password").getAsString();
        JsonArray profiles = user.getAsJsonArray("profile");

        for (JsonElement data : profiles) {
            JsonObject obj = data.getAsJsonObject();
            String id = obj.get("id").getAsString();
            String nom = obj.get("nom").getAsString();
            Perfil perfil = new Perfil();
            perfil.setID(id);
            perfil.setNom(nom);
            System.out.println("PERFIL:" + perfil.getNom());
            _perfils.add(perfil);
        }
    }

    public String getId() {
        return _id;
    }
    public String getNom() {
        return _nom;
    }
    public String getUsername() {
        return _username;
    }
    public String getPass() {
        return _password;
    }
    public int getNumPerfils() { return _perfils.size();}
    public boolean checkPassword(String pass) {
        return pass.equals(_password);
    }
    public ArrayList<Perfil> getPerfils(){return _perfils;}
    public void setName(String name) {
        this._nom = name;
    }
    public void setPass(String pass) {
        this._password = pass;
    }

    public void addProfile() throws UserException {
        if (_username.equals("")) throw new UserException(getId());
        this._perfils.add(new Perfil(this._nom));
    }
}
