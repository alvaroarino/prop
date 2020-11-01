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
       int n = aleat.nextInt(4)+3;
       int m = aleat.nextInt(4)+3;

        board = new Tauler(n,m);
    }



    public void generar() {


        int ca_negras = ((aleat.nextInt(board.getDimn()* board.getDimm())) / 2) ;











    }





}
