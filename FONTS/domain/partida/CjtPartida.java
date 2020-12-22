package domain.partida;

import java.util.ArrayList;

/**
 * The type Cjt partida.
 */
public class CjtPartida {
    private ArrayList<Partida> partidas;

    /**
     * Instantiates a new Cjt partida.
     */
    public CjtPartida() {

    }

    /**
     * Nueva partida aleatoria.
     */
    public void NuevaPartidaAleatoria() {
        partidas.add(new Partida());
    }

    /**
     * Nueva partida determinada.
     *
     * @param n   the n
     * @param m   the m
     * @param nom the nom
     */
    public void NuevaPartidaDeterminada(int n, int m, String nom) {
        partidas.add(new Partida(n, m, nom));
    }

    /**
     * Set partidas.
     *
     * @param part the part
     */
    public void SetPartidas (Partida part) {
        partidas.add(part);
    }

    /**
     * Gets num partides.
     *
     * @return the num partides
     */
    public int getNumPartides() {
        return partidas.size();
    }

    /**
     * Gets partida.
     *
     * @param i the
     * @return the partida
     */
    public Partida getPartida (int i) {
        return partidas.get(i);
    }
}
