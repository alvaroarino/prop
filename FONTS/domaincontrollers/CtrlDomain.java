package domaincontrollers;

import dades.CtrlDades;
import domain.kakuro.Kakuro;
import domain.partida.Partida;
import domain.ranking.Ranking;
import domain.ranking.Stat;
import domain.usuari.Perfil;
import domain.usuari.Usuari;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Ctrl domain.
 */
public class CtrlDomain {
    private static CtrlDomain singletonObject;

    private CtrlDades dades = CtrlDades.getInstance();
    private ArrayList<Usuari> cjtUsuarios;
    /**
     * The Actual user.
     */
    public Usuari actualUser = new Usuari();
    /**
     * The Perfil actual.
     */
    public Perfil perfilActual;

    /**
     * The Partida actual.
     */
    public Partida partidaActual;
    /**
     * The Rank actual.
     */
    public Ranking rankActual = Ranking.getInstance();
    /**
     * The Tipo entrada.
     */
    public int tipoEntrada = 0; // 1 = aleatorio 2 = ajustes predefinidos 3 = importar fichero
    /**
     * The Kakuro.
     */
    public Kakuro kakuro ;
    /**
     * The N.
     */
    public int n;
    /**
     * The M.
     */
    public int m;
    /**
     * The Negras.
     */
    public int negras;
    /**
     * The Valor.
     */
    public int valor;

    /**
     * The Num kakuros aventura.
     */
    public int num_kakuros_aventura;


    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDomain getInstance() {
        if (singletonObject == null) {
            System.out.println("Init Domini");
            singletonObject = new CtrlDomain() {
            };
        }
        return singletonObject;
    }

    private CtrlDomain() {};


    /**
     * Init data.
     */
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

    /**
     * Check usuari boolean.
     *
     * @param op       the op
     * @param username the username
     * @param password the password
     * @return the boolean
     */
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

    /**
     * Add usuari.
     *
     * @param username the username
     * @param password the password
     */
    public void addUsuari(String username, String password) {
        Usuari user = new Usuari(username, username);
        user.setPass(password);
        cjtUsuarios.add(user);
        this.actualUser = user;
        dades.updateUsuaris(cjtUsuarios);
    }

    /**
     * Gets perfils.
     *
     * @return the perfils
     */
    public ArrayList<Perfil> getPerfils() {
        System.out.println(this.actualUser.getId());
        return actualUser.getPerfils();

    }

    /**
     * Sets perfilactual.
     *
     * @param p the p
     */
    public void setPerfilactual(Perfil p) {
        perfilActual = p;
    }

    /**
     * Crear perfil.
     *
     * @param nom the nom
     */
    public void crearPerfil(String nom) {
        Perfil p = new Perfil(nom);
        actualUser.addProfile(p);
        for (Usuari u: cjtUsuarios) {
            if (u.getId() == actualUser.getId()) u = actualUser;
        }
        dades.updateUsuaris(cjtUsuarios);
    }

    /**
     * Gets ranking.
     *
     * @return the ranking
     */
    public List<Stat> getRanking() {
        return rankActual.obtenirRankingOrdenat();
    }

    public void storeRanking() throws IOException {dades.guardar_estadisticas(rankActual.getRanking());}

}
