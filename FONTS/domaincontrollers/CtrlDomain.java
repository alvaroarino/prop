package domaincontrollers;

import dades.CtrlDades;
import domain.usuari.Perfil;
import domain.usuari.Usuari;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlDomain {
    private static CtrlDomain singletonObject;

    private CtrlDades dades = CtrlDades.getInstance();
    private ArrayList<Usuari> cjtUsuarios;
    private Usuari actualUser = new Usuari();
    private Perfil perfilActual;

    public static CtrlDomain getInstance() {
        if (singletonObject == null) {
            System.out.println("Init Domini");
            singletonObject = new CtrlDomain() {
            };
        }
        return singletonObject;
    }

    private CtrlDomain() {};



    public void initData() {
        System.out.println("Getting data");
        try {
            System.out.println("USUARIS");
            if (cjtUsuarios == null) cjtUsuarios = new ArrayList<>();
            cjtUsuarios = dades.getUsuaris();
            System.out.println("#USUARIS: " + cjtUsuarios.size());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public boolean checkUsuari(String op, String username, String password) {
        switch (op) {
            case "login":
                for (Usuari user : cjtUsuarios) {
                    if (user.getUsername().equals(username) && user.checkPassword(password)) {
                        this.actualUser = user;
                        System.out.println(actualUser.getUsername());
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
        System.out.println(this.actualUser.getId());
        return actualUser.getPerfils();

    }

    public void setPerfilactual(Perfil p) {
        perfilActual = p;
    }

}
