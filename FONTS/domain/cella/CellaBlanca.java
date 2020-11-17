package domain.cella;

/**
 * The type Cella blanca.
 */
public class CellaBlanca extends Cella{

    private int valor;

    /**
     * Instantiates a new Cella blanca.
     */
    public CellaBlanca () {
        super.Cella();
        valor = -1;
    }

    @Override
    public int getValor_blanca() {
        super.getValor_blanca();
        return valor;
    }

    @Override
    public void intro_valor_blanca(int z) {
        super.intro_valor_blanca(z);
        valor = z;
    }

    @Override
    public int color() {
        super.color();
        return 0;

    }
}