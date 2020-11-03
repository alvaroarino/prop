package domain;

import java.util.Random;

public class Kakuro {


    Random aleat;
    Tauler board;


    public Kakuro(int n, int m) {

        aleat = new Random();

        board = new Tauler(n,m);

    }

    public Kakuro() {

        aleat = new Random();
       int n = aleat.nextInt(4)+4;
       int m = aleat.nextInt(4)+4;

        board = new Tauler(n,m);
    }



    public void generar() {

        int minimo = Math.min(board.getDimn(), board.getDimm());

        int ca_negras = ((board.getDimn()* board.getDimm()) / 2) - minimo ;


        board.pintar_negras(ca_negras);

        board.buscar_problemas();

        board.rellenar_blancas();

        board.hacer_sumas();

        board.borrar_blancas();





    }





}
