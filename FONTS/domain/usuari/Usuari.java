package domain.usuari;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * The type Usuari.
 */
public class Usuari {
    /**
     * El Id unic per cada usuari.
     */
    String _id;
    /**
     * El nome de cada usuari.
     */
    String _nom;
    /**
     * La foto de perfil, es opcional. En el suposi que no en tingui es fa ús
     * d'una predeterminada del sistema de dades.
     */
    File _fotoPerfil;
    /**
     * El nom d'usuari escollit.
     */
    String _username;

    /**
     * Els diferents perfils que un usuari pot tenir.
     */
    ArrayList<Perfil> perfils;

    /**
     * Crea un usuari buit.
     */
    Usuari() {
        _nom = "";
        _username = "";
        _fotoPerfil = new File("data-files/img/empty-img.jpg");
        perfils = new ArrayList<>();
    }

    /**
     * Crea un usuari amb nom i nom d'usuari, username
     *
     * @param nom      the nom
     * @param username the usuari
     */
    Usuari(String nom, String username) {
        this._id = UUID.randomUUID().toString();
        this._nom = nom;
        this._username = username;
        _fotoPerfil = new File("data-files/img/empty-img.jpg");
        perfils = new ArrayList<>();
    }

    /**
     * Obtenir d'ID assignat a l'usuari.
     *
     * @return l 'ID de l'usuari.
     */
    public String getId() {
        return _id;
    }
}
