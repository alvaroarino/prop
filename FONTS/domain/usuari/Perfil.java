package domain.usuari;

import java.util.UUID;

public class Perfil {
    UUID _idPerfil;
    String _nom;

    public Perfil() {
        _idPerfil = UUID.randomUUID();
        _nom = "";
    }

    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID();
        this._nom = nom;
    }

    public void setNom(String n) {
        this._nom = n;
    }

    public String getNom() {
        return this._nom;
    }
}
