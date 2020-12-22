package domain.cella;

/**
 * The type Cella negra.
 */
public class CellaNegra extends Cella{

    private int valorDret;
    private int valorEsquerre;

    /**
     * Instantiates a new Cella negra.
     */
    public CellaNegra () {
        super.Cella();
        valorDret = -1;
        valorEsquerre = -1;
    }

    /**
     * Instantiates a new Cella negra.
     *
     * @param dreta    the dreta
     * @param esquerra the esquerra
     */
    public CellaNegra(int dreta, int esquerra) {
        super.Cella();
        valorDret = dreta;
        valorEsquerre = esquerra;
    }

    @Override
    public void setValorFila(int val) {
        valorDret = val;

    }

    @Override
    public void setValorColumna(int val) {
        valorEsquerre = val;

    }

    @Override
    public  void acumular_valor_derecha(int s){
        super.Cella();
        if (valorDret == -1) valorDret = 0;
        valorDret += s;
    }
    @Override
    public  void acumular_valor_izquierda(int s){
        super.Cella();
        if (valorEsquerre == -1) valorEsquerre = 0;
        valorEsquerre += s;
    }


    @Override
    public int getValorDret() {
        return valorDret;

    }
    @Override
    public int getValorEsquerre() {
        return valorEsquerre;
    }

    @Override
    public ColorCella color() {
        return ColorCella.Negra;
    }
}

