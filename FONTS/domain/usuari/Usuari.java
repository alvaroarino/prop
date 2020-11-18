package domain.usuari;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class Usuari {
    String _id;
    String _nom;
    String _username;
    String _password;

    ArrayList<Perfil> _perfils;

    Usuari() {
        _nom = "";
        _username = "";
        _perfils = new ArrayList<>();
    }

    Usuari(String nom, String username) {
        this._id = UUID.randomUUID().toString();
        this._nom = nom;
        this._username = username;
        _perfils = new ArrayList<>();
    }

    public String getId() {
        return _id;
    }

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
