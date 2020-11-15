package domain;

public class CellaNegra extends Cella{

    private int valorDret;
    private int valorEsquerre;

    public CellaNegra () {
        super.Cella();
        valorDret = -1;
        valorEsquerre = -1;
    }

    @Override
    public  void acumular_valor_derecha(int s){
        if(valorDret == -1) valorDret = 0;
        valorDret += s;
    }
    @Override
    public  void acumular_valor_izquierda(int s){
        if(valorEsquerre == -1) valorDret = 0;
        valorEsquerre+= s;
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
    public int color() {
        return 1;

    }
}

