package domain.partida;

import java.util.ArrayList;

/**
 * The type Cjt partidas.
 */
public class Cjt_Partidas {
    private ArrayList<Partida> CjtPartides;

    /**
     * Partides totals int.
     *
     * @return the int
     */
    public int PartidesTotals() {
        return CjtPartides.size();
    }

}
