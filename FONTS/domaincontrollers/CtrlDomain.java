package domaincontrollers;

import dades.CtrlDades;
import domain.usuari.Perfil;
import domain.usuari.Usuari;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlDomain {
    private static CtrlDomain singletonObject;
    private CtrlDades dades = CtrlDades.getInstance();

    public static CtrlDomain getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDomain() {
            };
        return singletonObject;
    }

    private CtrlDomain() {};

    ArrayList<Usuari> cjtUsuarios;
    Usuari actualUser;
    Perfil perfilActual;

    public void initData() {
        try {
            if (cjtUsuarios == null) cjtUsuarios = new ArrayList<>();
            cjtUsuarios = dades.getUsuaris();
        } catch (IOException e) {
        }
    }

    public boolean checkUsuari(String op, String username, String password) {
        switch (op) {
            case "login":
                for (Usuari user : cjtUsuarios) {
                    if (user.getUsername().equals(username) && user.checkPassword(password)) {
                        actualUser = user;
                        return true;
                    }
                }
                return false;
            case "signup":
                for (Usuari user : cjtUsuarios) {
                    if (user.getUsername().equals(username)) return true;
                }
                return false;
            default:
                System.out.println("Not available");
        }
        return false;
    }

    public void addUsuari(String username, String password) {
        Usuari user = new Usuari(username, username);
        user.setPass(password);
        cjtUsuarios.add(user);
        dades.updateUsuaris(cjtUsuarios);
    }

    public ArrayList<Perfil> getPerfils() {
        return actualUser.getPerfils();

    }

    public void setPerfilactual(Perfil p) {
        perfilActual = p;
    }

}
