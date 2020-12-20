package domain.aventura;

import domain.kakuro.Kakuro;

import java.util.ArrayList;

public class Aventura {

    private ArrayList<Kakuro> Aventura;
    private double TempsIni;
    private double TempsActual;
    private double TempsAcum;
    private int estat;

    public Aventura() {
         for (int i = 0; i < 10; ++i) {
             assert Aventura != null;
             Aventura.add(new Kakuro());
         }
         TempsIni = System.currentTimeMillis();

    }
    public Aventura(int n) {
        for (int i = 0; i < n; ++i) {
            assert Aventura != null;
            Aventura.add(new Kakuro());
        }
        TempsIni = System.currentTimeMillis();

    }

    public double getTemps() {
        TempsActual = System.currentTimeMillis();
        return ((TempsActual-TempsIni)/1000) + TempsAcum;
    }

    public void pause() {
        TempsActual = System.currentTimeMillis();
        estat = 0;
        TempsAcum += ((TempsActual - TempsIni)/1000);
    }

    public void restart() {
        estat = 1;
        TempsIni = System.currentTimeMillis();
    }

    public ArrayList<Kakuro> getAventura() {
        return Aventura;
    }
    public int getNumNivells() { return Aventura.size(); }
    public Kakuro getKakuro(int i) { return Aventura.get(i); }

    public void SetTemps(double ini) {
        TempsAcum = ini;
    }
    public void SetAventura(ArrayList<Kakuro> av) {
        Aventura = av;
    }
}
