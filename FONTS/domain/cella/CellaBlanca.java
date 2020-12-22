package domain.cella;

/**
 * The type Cella blanca.
 */
public class CellaBlanca extends Cella{

    private int valor;
    private boolean fixed;
    private boolean usuari;

    /**
     * Instantiates a new Cella blanca.
     */
    public CellaBlanca () {
        super.Cella();
        valor = -1;
        fixed = false;
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
    public void fixCellaBlanca() {
        super.fixCellaBlanca();
        fixed = true;
    }

    @Override
    public void resetFixCellaBlanca() {
        super.resetFixCellaBlanca();
        fixed = false;
    }

    @Override
    public boolean cellaFixed() {
        return fixed;
    }

    @Override
    public ColorCella color() {
        return ColorCella.Blanca;
    }

    @Override
    public void fixUsuariCellaBlanca() {
        super.fixUsuariCellaBlanca();
        usuari = true;
    }

    @Override
    public void resetUsuariCella() {
        super.resetUsuariCella();
        usuari = false;
    }

    @Override
    public boolean usuariCella() {
        return usuari;
    }
}