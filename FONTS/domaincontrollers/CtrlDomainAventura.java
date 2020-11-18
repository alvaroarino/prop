package domaincontrollers;

import domain.Kakuro;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Aventura.
 */
public class Aventura {
    private ArrayList<Kakuro> CjtKakuros;
    private time Temps;

    /**
     * Instantiates a new Aventura.
     *
     * @param n the n
     */
    public Aventura (int n) {

    }

    /**
     * Instantiates a new Aventura.
     */
    public Aventura () {
        Random aleat = new Random();
        int n = aleat.nextInt(9)+1;
    }

    /**
     * Gets temps.
     *
     * @return the temps
     */
    public time getTemps() {
        return Temps;
    }

    /**
     * Kakuros totals int.
     *
     * @return the int
     */
    public int KakurosTotals() {
        return CjtKakuros.size();
    }
}