package domain;

public class CellaNegra extends Cella{

    private int valorDret;
    private int valorEsquerre;


    public CellaNegra () {

        valorDret = -1;
        valorEsquerre = -1;
    }

    public CellaNegra (int x, int y) {

        valorDret = x;
        valorEsquerre = y;
    }

    @Override
    public void intro_valor(int z) {
        super.intro_valor(z);
    }

    public int getValorDret() {
        return valorDret;

    }
    public int getValorEsquerre() {
        return valorEsquerre;
    }
}

