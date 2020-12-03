package domain.kakuro;

import java.util.Random;

public class Kakuro {
    Random aleat;
    Tauler board;

    public Kakuro(int n, int m) {
        aleat = new Random();
        board = new Tauler(n, m);
    }

    public Kakuro() {
        aleat = new Random();

        int n = aleat.nextInt(4)+6;
        int m = aleat.nextInt(4)+6;

        board = new Tauler(n,m);
    }

    public void generar() {

        int minimo = Math.min(board.getDimn(), board.getDimm());
        int ca_negras = ((board.getDimn()* board.getDimm()) / 2) - minimo ;

        board.print_negras(ca_negras);
        board.rellenar_celdas_blancas();
        //while (!board.rellenar_blancas1())
        //board.borrar_blancas();
        //board.hacer_sumas();
        //board.borrar_blancas();
        board.print();
    }

    public void generar_usuario(int n, int m, int negras, int blancas) {
        if (negras + blancas != (n*m)) {
            System.out.println("La quantitat de caselles introduïdes no coincideix amb la dimensió escollida");
            return;
        }
        board.print_negras(negras);
          while (!board.rellenar_blancas1())
            board.borrar_blancas();
        board.hacer_sumas();
        board.borrar_blancas();
        board.print();
    }



    public Tauler getBoard() {
        return board;
    }
}
