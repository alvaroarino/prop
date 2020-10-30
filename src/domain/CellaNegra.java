package domain;

public class CellaNegra extends Cella{

    private int valorDret;
    private int valorEsquerre;


    public CellaNegra (int x, int y) {

        valorDret = x;
        valorEsquerre = y;
    }

    public int getValorDret() {
        return valorDret;

    }
    public int getValorEsquerre() {
        return valorEsquerre;
    }
}
