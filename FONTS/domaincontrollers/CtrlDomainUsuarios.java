package domaincontrollers;

import domain.usuari.Usuari;

import java.util.ArrayList;

/**
 * The type Ctrl domain usuarios.
 */
public class CtrlDomainUsuarios {
    /**
     * The Usuaris.
     */
    ArrayList<Usuari> _usuaris;

    /**
     * Crear usuari.
     *
     * @param user the user
     */
    void crearUsuari(Usuari user) {
        _usuaris.add(user);
    }

    /**
     * Eliminar usuari.
     *
     * @param id the id
     */
    void eliminarUsuari(String id) {
        _usuaris.removeIf(usuari -> usuari.getId().equals(id));
    }

    /**
     * Modificar usuari.
     *
     * @param id the id
     */
    void modificarUsuari(String id) {

    }
}
