package domain.partida;

import domain.kakuro.Kakuro;
import domain.ranking.Ranking;
import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;

import java.io.IOException;

/**
 * The type Partida.
 */
public class Partida {
    private double tinicial;
    private double tacumulat;
    private int estat;
    private Kakuro KakuroPartida;
    private String name;

    /**
     * The Domain.
     */
    CtrlDomain domain = CtrlDomain.getInstance();
    /**
     * The Rank.
     */
    Ranking rank = Ranking.getInstance();

    /**
     * Instantiates a new Partida.
     *
     * @param n   the n
     * @param m   the m
     * @param nom the nom
     */
    public Partida(int n, int m, String nom) {
        tinicial = System.currentTimeMillis();
        tacumulat = 0;
        estat = 1;
        KakuroPartida = new Kakuro(n, m);
        name = nom;
    }

    /**
     * Instantiates a new Partida.
     */
    public Partida() {
        tinicial = System.currentTimeMillis();
        tacumulat = 0;
        estat = 1;
        KakuroPartida = new Kakuro();
        int id2 = (int) (Math.random() * 5000);
        name = id2+"";
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public double getTime() {
        long tactual = System.currentTimeMillis();
        return ((tactual - tinicial)/1000) + tacumulat;
    }

    /**
     * Gets kakuro.
     *
     * @return the kakuro
     */
    public Kakuro getKakuro() {
        return KakuroPartida;
    }

    /**
     * Gets estat.
     *
     * @return the estat
     */
    public int getEstat() {
        return estat;
    }

    /**
     * Pause.
     */
    public void pause() {
        long tactual = System.currentTimeMillis();
        estat = 0;
        tacumulat += ((tactual - tinicial)/1000);
    }

    /**
     * Restart.
     */
    public void restart() {
        estat = 1;
        tinicial = System.currentTimeMillis();
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return name;
    }

    /**
     * Set kakuro partida.
     *
     * @param k the k
     */
    public void SetKakuroPartida(Kakuro k) {
        KakuroPartida = k;
    }

    /**
     * Set tinicial.
     *
     * @param i the
     */
    public void SetTinicial(double i) {
        tacumulat = i;
        tinicial = System.currentTimeMillis();
    }

    /**
     * Set estat.
     *
     * @param i the
     */
    public void SetEstat(int i) {
        estat = i;
    }

    /**
     * Set name.
     *
     * @param n the n
     */
    public void SetName(String n) { name = n; }

    /**
     * Acabar partida.
     */
    public void acabarPartida() {
        String perfil = domain.perfilActual.getNom();
        String dif = KakuroPartida.getBoard().getDificulty();
        double aux = 0;
        if(dif.equals("facil")) {
            aux = 300 - tacumulat;
        }
        else if(dif.equals("medio")) {
            aux = 600 - tacumulat;
        }
        else if(dif.equals("hard")){
            aux = 900 - tacumulat;
        }
        int punt = (int)aux;

        if(aux != 0) {
            if (!domain.perfilActual.conteKakuro(KakuroPartida.getId())) {
                rank.afegirIndex(perfil, punt);
                domain.perfilActual.addKakuro(KakuroPartida.getId());
                try{
                domain.storeRanking();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
