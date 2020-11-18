package domain.usuari;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * The type Usuari.
 *
 * @author Alvaro Ariño Cabau
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
     * El nom d'usuari escollit.
     */
    String _username;
    /**
     * La contasenya es opcional.
     */
    String _password;

    /**
     * Els diferents perfils que un usuari pot tenir.
     */
    ArrayList<Perfil> _perfils;

    /**
     * Crea un usuari buit.
     */
    Usuari() {
        _nom = "";
        _username = "";
        _perfils = new ArrayList<>();
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
        _perfils = new ArrayList<>();
    }

    /**
     * Obtenir d'ID assignat a l'usuari.
     *
     * @return l 'ID de l'usuari.
     */
    public String getId() {
        return _id;
    }

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
     * @throws UserException the user excepcion
     */
    public void addProfile() throws UserException {
        if (_username.equals("")) throw new UserException(getId());
        this._perfils.add(new Perfil(this._nom));
    }
}
