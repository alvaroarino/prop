package domain.usuari;

import java.util.UUID;

public class Perfil {
    String _idPerfil;
    String _nom;

    public Perfil() {
        _idPerfil = UUID.randomUUID().toString();
        _nom = "";
    }

    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID().toString();
        this._nom = nom;
    }

    public Perfil(String id, String nom) {
        this._idPerfil = id;
        this._nom = nom;
    }

    public void setNom(String n) {
        this._nom = n;
    }

    public String getNom() {
        return this._nom;
    }
}
