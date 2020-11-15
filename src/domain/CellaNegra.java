package domain;

public class CellaNegra extends Cella{

    private int valorDret;
    private int valorEsquerre;

    @Override
    public CellaNegra () {
        super.Cella();
        valorDret = Integer.parseInt(null);
        valorEsquerre = Integer.parseInt(null);
    }

    @Override
    public  void acumular_valor_derecha(int s){
        if(valorDret == null) valorDret = 0;
        valorDret += s;
    }
    @Override
    public  void acumular_valor_izquierda(int s){
        if(valorEsquerre == null) valorDret = 0;
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


