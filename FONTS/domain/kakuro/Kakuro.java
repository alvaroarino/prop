package domain.kakuro;

import java.util.Random;

/**
 * The type Kakuro.
 */
public class Kakuro {
    /**
     * The Aleat.
     */
    Random aleat;
    /**
     * The Board.
     */
    Tauler board;

    /**
     * Instantiates a new Kakuro.
     *
     * @param n the n
     * @param m the m
     */
    public Kakuro(int n, int m) {
        aleat = new Random();
        board = new Tauler(n, m);
    }

    /**
     * Instantiates a new Kakuro.
     */
    public Kakuro() {
        aleat = new Random();

        int n = aleat.nextInt(4)+4;
        int m = aleat.nextInt(4)+4;

        board = new Tauler(n,m);
    }

    /**
     * Generar.
     */
    public void generar() {

        int minimo = Math.min(board.getDimn(), board.getDimm());
        int ca_negras = ((board.getDimn()* board.getDimm()) / 2) - minimo ;

        board.pintar_negras(ca_negras);
        board.rellenar_blancas();
        board.hacer_sumas();
        board.borrar_blancas();
    }

    /**
     * Generar usuario.
     *
     * @param n       the n
     * @param m       the m
     * @param negras  the negras
     * @param blancas the blancas
     */
    public void generar_usuario(int n, int m, int negras, int blancas) {
        if (negras + blancas != (n*m)) { //Aviso de que está mal
            return;
        }
        board.pintar_negras(negras);
        board.rellenar_blancas();
        board.hacer_sumas();
        board.borrar_blancas();
    }
}
