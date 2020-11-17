package domain.usuari;

import java.util.UUID;

/**
 * The type Perfil.
 */
public class Perfil {
    /**
     * The Id perfil.
     */
    UUID _idPerfil;

    /**
     * The Nom.
     */
    String _nom;

    /**
     * Instantiates a new Perfil.
     */
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
}
