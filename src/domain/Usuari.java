package domain;

import java.util.ArrayList;

public class Usuari {
    String _nom;
    // Imatge _fotoPerfil;
    String _usuari;
    String _contrasenya;

    ArrayList<Perfil> perfils;

    Usuari() {
        _nom = "";
        _usuari = "";
        _contrasenya = "";
    }

    Usuari(String nom, String usuari, String contrasenya) {
        this._nom = nom;
        this._usuari = usuari;
        this._contrasenya = contrasenya;
        perfils = new ArrayList<>();
    }
}
