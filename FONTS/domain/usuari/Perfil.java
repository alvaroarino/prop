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

    /**
     * Instantiates a new Perfil.
     *
     * @param nom the nom
     */
    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID();
        this._nom = nom;
    }

    /**
     * Sets nom.
     *
     * @param n the n
     */
    public void setNom(String n) {
        this._nom = n;
    }
}
