package domain;

import java.util.ArrayList;

public class Usuari {
    String _id;
    String _nom;
    // Imatge _fotoPerfil;
    String _usuari;

    ArrayList<Perfil> perfils;

    Usuari() {
        _nom = "";
        _usuari = "";
    }

    Usuari(String nom, String usuari) {
        this._nom = nom;
        this._usuari = usuari;
        perfils = new ArrayList<>();
    }

    public String getId() {
        return _id;
    }
}
