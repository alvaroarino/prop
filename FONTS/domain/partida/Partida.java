package domain.partida;

import domain.kakuro.Kakuro;

public class Partida {
    private double tinicial;
    private double tacumulat;
    private int estat;
    private Kakuro KakuroPartida;

    public Partida(int n, int m) {
        tinicial = System.currentTimeMillis();
        estat = 1;
        KakuroPartida = new Kakuro(n, m);
    }

    public Partida() {
        tinicial = System.currentTimeMillis();
        estat = 1;
        KakuroPartida = new Kakuro();
    }

    public double getTime() {
        long tactual = System.currentTimeMillis();
        return (tactual - tinicial)/1000;
    }

    public Kakuro getKakuro() {
        return KakuroPartida;
    }

    public int getEstat() {
        return estat;
    }

    public void pause() {
        estat = 0;
        tacumulat = (System.currentTimeMillis()) - tinicial;
    }

    public void restart() {
        estat = 1;
        tinicial = tacumulat;
    }
}
