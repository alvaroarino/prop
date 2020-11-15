package domain;

/**
 * The type Cella blanca.
 */
public class CellaBlanca extends Cella{

    private int valor;

    /**
     * Instantiates a new Cella blanca.
     *
     * @param x the x
     */
    public CellaBlanca(int x) {

        valor = x;
    }

    public int getValor() {
        return valor;
    }

    /**
     * Intro valor blanca.
     *
     * @param z the z
     */
    @Override
    public void intro_valor_blanca(int z) {
        super.intro_valor(z);
        this.valor = z;
    }
}
