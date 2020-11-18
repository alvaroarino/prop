package domain.partida;

/**
 * The type Partida.
 */
public class Partida {
    private Partida();
    private int Estat;
    private time Temps;

    /**
     * Gets estat.
     *
     * @return the estat
     */
    public int getEstat() {
        return Estat;
    }

    /**
     * Pausa part.
     */
    public void PausaPart() {
        Estat = 1;
    }

    /**
     * Contiuna part.
     */
    public void ContiunaPart() {
        Estat = 0;
    }

    /**
     * Gets temps.
     *
     * @return the temps
     */
    public time getTemps() {
        return Temps;
    }
}
