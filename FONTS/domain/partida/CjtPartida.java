package domain.partida;

import java.util.ArrayList;

public class CjtPartida {
    ArrayList<Partida> partidas;

    public void NuevaPartidaAleatoria() {
        partidas.add(new Partida());
    }
    public void NuevaPartidaDeterminada(int n, int m) {
        partidas.add(new Partida(n, m));
    }

    public int getNumPartides() {
        return partidas.size();
    }
}
