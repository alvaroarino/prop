package domain.partida;

import domain.kakuro.Kakuro;

public class Partida {
    private double tinicial;
    private double tacumulat;
    private int estat;
    private Kakuro KakuroPartida;
    private String name;

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
}
