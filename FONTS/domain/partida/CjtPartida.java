package domain.partida;

import java.util.ArrayList;

public class CjtPartida {
    private ArrayList<Partida> partidas;

    public CjtPartida() {

    }

    public void NuevaPartidaAleatoria() {
        partidas.add(new Partida());
    }
    public void NuevaPartidaDeterminada(int n, int m, String nom) {
        partidas.add(new Partida(n, m, nom));
    }
    public void SetPartidas (Partida part) {
        partidas.add(part);
    }

    public int getNumPartides() {
        return partidas.size();
    }
    public Partida getPartida (int i) {
        return partidas.get(i);
    }
}
