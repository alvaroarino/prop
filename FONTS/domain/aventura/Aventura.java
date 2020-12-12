package domain.aventura;

import domain.kakuro.Kakuro;
import domain.partida.CjtPartida;
import domain.partida.Partida;

import java.util.ArrayList;

public class Aventura {

    private ArrayList<Kakuro> Aventura;
    private double TempsIni;
    private double TempsActual;

    public Aventura() {
         for (int i = 0; i < 8; ++i) {
             Aventura.add(new Kakuro());
         }
         TempsIni = System.currentTimeMillis();

    }

    public double getTemps() {
        TempsActual = System.currentTimeMillis();
        return TempsActual-TempsIni;
    }

    public ArrayList<Kakuro> getAventura() {
        return Aventura;
    }

    public void SetTemps(double ini) {
        TempsIni = ini;
    }
    public void SetAventura(ArrayList<Kakuro> av) {
        Aventura = av;
    }
}
