package domain.partida;

import domain.kakuro.Kakuro;
import domain.ranking.Ranking;
import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;

public class Partida {
    private double tinicial;
    private double tacumulat;
    private int estat;
    private Kakuro KakuroPartida;
    private String name;

    CtrlDomain domain = CtrlDomain.getInstance();
    Ranking rank = Ranking.getInstance();

    public Partida(int n, int m, String nom) {
        tinicial = System.currentTimeMillis();
        tacumulat = 0;
        estat = 1;
        KakuroPartida = new Kakuro(n, m);
        name = nom;
    }

    public Partida() {
        tinicial = System.currentTimeMillis();
        tacumulat = 0;
        estat = 1;
        KakuroPartida = new Kakuro();
        int id2 = (int) (Math.random() * 5000);
        name = id2+"";
    }

    public double getTime() {
        long tactual = System.currentTimeMillis();
        return ((tactual - tinicial)/1000) + tacumulat;
    }

    public Kakuro getKakuro() {
        return KakuroPartida;
    }

    public int getEstat() {
        return estat;
    }

    public void pause() {
        long tactual = System.currentTimeMillis();
        estat = 0;
        tacumulat += ((tactual - tinicial)/1000);
    }

    public void restart() {
        estat = 1;
        tinicial = System.currentTimeMillis();
    }
    public String getNom() {
        return name;
    }

    public void SetKakuroPartida(Kakuro k) {
        KakuroPartida = k;
    }
    public void SetTinicial(double i) {
        tacumulat = i;
        tinicial = System.currentTimeMillis();
    }
    public void SetEstat(int i) {
        estat = i;
    }
    public void SetName(String n) { name = n; }

    public void acabarPartida() {
        String perfil = domain.perfilActual.getNom();
        String dif = KakuroPartida.getBoard().getDificulty();
        double aux;
        if(dif.equals("facil")) {
            aux = 300 - tacumulat;
        }
        else if(dif.equals("medio")) {
            aux = 600 - tacumulat;
        }
        else {
            aux = 900 - tacumulat;
        }
        int punt = (int)aux;

        if(!domain.perfilActual.conteKakuro(KakuroPartida.getId())) {
            rank.afegirIndex(perfil, punt);
            domain.perfilActual.addKakuro(KakuroPartida.getId());
        }
    }
}
