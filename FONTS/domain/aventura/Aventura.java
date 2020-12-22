package domain.aventura;

import domain.kakuro.Kakuro;

import java.util.ArrayList;

/**
 * The type Aventura.
 */
public class Aventura {

    private ArrayList<Kakuro> Aventura;
    private double TempsIni;
    private double TempsActual;
    private double TempsAcum;
    private int estat;

    /**
     * Instantiates a new Aventura.
     */
    public Aventura() {
         for (int i = 0; i < 10; ++i) {
             assert Aventura != null;
             Aventura.add(new Kakuro());
         }
         TempsIni = System.currentTimeMillis();

    }

    /**
     * Instantiates a new Aventura.
     *
     * @param n the n
     */
    public Aventura(int n) {
        for (int i = 0; i < n; ++i) {
            assert Aventura != null;
            Aventura.add(new Kakuro());
        }
        TempsIni = System.currentTimeMillis();

    }

    /**
     * Gets temps.
     *
     * @return the temps
     */
    public double getTemps() {
        TempsActual = System.currentTimeMillis();
        return ((TempsActual-TempsIni)/1000) + TempsAcum;
    }

    /**
     * Pause.
     */
    public void pause() {
        TempsActual = System.currentTimeMillis();
        estat = 0;
        TempsAcum += ((TempsActual - TempsIni)/1000);
    }

    /**
     * Restart.
     */
    public void restart() {
        estat = 1;
        TempsIni = System.currentTimeMillis();
    }

    /**
     * Gets aventura.
     *
     * @return the aventura
     */
    public ArrayList<Kakuro> getAventura() {
        return Aventura;
    }

    /**
     * Gets num nivells.
     *
     * @return the num nivells
     */
    public int getNumNivells() { return Aventura.size(); }

    /**
     * Gets kakuro.
     *
     * @param i the
     * @return the kakuro
     */
    public Kakuro getKakuro(int i) { return Aventura.get(i); }

    /**
     * Set temps.
     *
     * @param ini the ini
     */
    public void SetTemps(double ini) {
        TempsAcum = ini;
    }

    /**
     * Set aventura.
     *
     * @param av the av
     */
    public void SetAventura(ArrayList<Kakuro> av) {
        Aventura = av;
    }
}
