package domain;

public class CellaBlanca extends Cella{

    private int valor;

    public CellaBlanca (int x) {

        valor = x;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public void intro_valor_blanca(int z) {
        super.intro_valor(z);

        this.valor = z;
    }
}
