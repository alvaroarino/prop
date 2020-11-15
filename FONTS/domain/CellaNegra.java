package domain;

/**
 * The type Cella negra.
 */
public class CellaNegra extends Cella {

    private int valorDret;
    private int valorEsquerre;

    /**
     * Instantiates a new Cella negra.
     */
    public CellaNegra () {
        super();
        valorDret = -1;
        valorEsquerre = -1;
    }

    /**
     * Instantiates a new Cella negra.
     *
     * @param x the x
     * @param y the y
     */
    public CellaNegra (int x, int y) {
        super();
        valorDret = x;
        valorEsquerre = y;
    }

    /**
     * Intro valor negra.
     *
     * @param z the z
     * @param y the y
     */
    @Override
    public void intro_valor_negra(int z, int y) {
        super.intro_valor(z);
    }

    /**
     * Gets valor dret.
     *
     * @return the valor dret
     */
    public int getValorDret() {
        return valorDret;

    }

    /**
     * Gets valor esquerre.
     *
     * @return the valor esquerre
     */
    public int getValorEsquerre() {
        return valorEsquerre;
    }
}

