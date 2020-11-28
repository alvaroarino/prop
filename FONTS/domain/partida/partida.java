package domain.partida;

import domain.kakuro.Kakuro;

public class partida {
    double tinicial;
    double tacumulat;
    int estat;
    Kakuro KakuroPartida;

    public partida(int n, int m) {
        tinicial = System.currentTimeMillis();
        estat = 1;
        KakuroPartida = new.Kakuro.Kakuro(n, m);
    }

    public partida() {
        tinicial = System.currentTimeMillis();
        estat = 1;
        KakuroPartida = new.Kakuro.Kakuro();
    }

    public double getTime() {
        long tactual = System.currentTimeMillis();
        return (tactual - tinicial)/1000;
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
