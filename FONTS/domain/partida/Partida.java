package domain.partida;

import java.sql.Time;

/**
 * The type Partida.
 */
public class Partida {

    private int Estat;
    private Time Temps;

    private Partida() {

    }

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
    public Time getTemps() {
        return Temps;
    }
}
