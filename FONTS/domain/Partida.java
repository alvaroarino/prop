package domain;

/**
 * The type Partida.
 */
public class Partida {
    private Partida();
    private int Estat;
    private time Temps;

    public int getEstat() {
        return Estat;
    }

    public void PausaPart() {
        Estat = 1;
    }

    public void ContiunaPart() {
        Estat = 0;
    }

    public time getTemps() {
        return Temps;
    }
}
