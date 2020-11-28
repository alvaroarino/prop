package domain.partida;

import java.util.ArrayList;

public class Cjtpartida {
    ArrayList<partida> partidas;

    public void NuevaPartidaAleatoria() {
        partidas.add(new partida());
    }
    public void NuevaPartidaDeterminada(int n, int m) {
        partidas.add(new partida(n, m));
    }

    public int getNumPartides() {
        return partidas.size();
    }
}
