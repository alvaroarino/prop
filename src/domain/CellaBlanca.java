package domain;

public class CellaBlanca extends Cella{

    private int valor;

    @Override
    public CellaBlanca () {
    super.Cella();
        valor = null;
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
