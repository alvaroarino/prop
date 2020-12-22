package domain.usuari;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

/**
 * The type Usuari.
 */
public class Usuari {
    private String _id;
    private String _nom;
    private String _username;
    private String _password;

    private ArrayList<Perfil> _perfils;

    /**
     * Instantiates a new Usuari.
     */
    public Usuari() {
        _nom = "";
        _username = "";
        _perfils = new ArrayList<>();
    }

    /**
     * Instantiates a new Usuari.
     *
     * @param nom      the nom
     * @param username the username
     */
    public Usuari(String nom, String username) {
        this._id = UUID.randomUUID().toString();
        this._nom = nom;
        this._username = username;
        _perfils = new ArrayList<>();
    }

    /**
     * To json string.
     *
     * @param user the user
     * @return the string
     */
    public String toJson(Usuari user) {
        Gson gson = new Gson();
        // 1. Java object to JSON file
        return gson.toJson(user);
    }

    /**
     * From json.
     *
     * @param user the user
     */
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
            JsonArray puntuats = obj.getAsJsonArray("puntuats");
            Set<String> punts = new TreeSet<>();
            puntuats.forEach((element) -> punts.add(element.getAsString()));
            perfil.setPuntuats(punts);
            System.out.println("PERFIL:" + perfil.getNom());
            _perfils.add(perfil);
        }
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return _nom;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return _username;
    }

    /**
     * Gets pass.
     *
     * @return the pass
     */
    public String getPass() {
        return _password;
    }

    /**
     * Gets num perfils.
     *
     * @return the num perfils
     */
    public int getNumPerfils() { return _perfils.size();}

    /**
     * Check password boolean.
     *
     * @param pass the pass
     * @return the boolean
     */
    public boolean checkPassword(String pass) {
        return pass.equals(_password);
    }

    /**
     * Get perfils array list.
     *
     * @return the array list
     */
    public ArrayList<Perfil> getPerfils(){return _perfils;}

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this._nom = name;
    }

    /**
     * Sets pass.
     *
     * @param pass the pass
     */
    public void setPass(String pass) {
        this._password = pass;
    }

    /**
     * Add profile.
     *
     * @param p the p
     */
    public void addProfile(Perfil p) {
        this._perfils.add(p);
    }
}
