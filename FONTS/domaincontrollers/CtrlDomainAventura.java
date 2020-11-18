package domaincontrollers;

import domain.kakuro.Kakuro;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Aventura.
 */
public class CtrlDomainAventura {
    private ArrayList<Kakuro> CjtKakuros;
    private Time Temps;

    /**
     * Instantiates a new Aventura.
     *
     * @param n the n
     */
    public CtrlDomainAventura (int n) {

    }

    /**
     * Instantiates a new Aventura.
     */
    public CtrlDomainAventura () {
        Random aleat = new Random();
        int n = aleat.nextInt(9)+1;
    }

    /**
     * Gets temps.
     *
     * @return the temps
     */
    public Time getTemps() {
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