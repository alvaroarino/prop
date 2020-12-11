package domain.aventura;

import domain.partida.CjtPartida;

public class Aventura {

    private CjtPartida Aventura;
    private double TempsIni;
    private double TempsActual;

    public Aventura() {
         Aventura = new CjtPartida();
         for (int i = 0; i < 8; ++i) {
             Aventura.NuevaPartidaAleatoria();
         }
         TempsIni = System.currentTimeMillis();

    }

    public double getTemps() {
        TempsActual = System.currentTimeMillis();
        return TempsActual-TempsIni;
    }

    public void SetTemps(double ini, double act) {
        TempsIni = ini;
        TempsActual = act;
    }
    public void SetAventura(CjtPartida av) {
        Aventura = av;
    }
}
