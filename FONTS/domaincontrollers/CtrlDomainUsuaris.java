package domaincontrollers;

import domain.usuari.Usuari;

import java.util.ArrayList;

public class CtrlDomainUsuaris {
    ArrayList<Usuari> _usuaris;

    void crearUsuari(Usuari user) {
        _usuaris.add(user);
    }

    void eliminarUsuari(String id) {
        _usuaris.removeIf(usuari -> usuari.getId().equals(id));
    }

    void modificarUsuari(String id) {

    }
}