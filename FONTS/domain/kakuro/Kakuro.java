package domain.kakuro;

import java.util.Random;

/**
 * The type Kakuro.
 */
public class Kakuro {
    /**
     * The Id.
     */
    String id;
    /**
     * The Aleat.
     */
    final Random aleat;
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
        int id2 = (int) (Math.random() * 5000);
        id = id2+"";
    }

    /**
     * Instantiates a new Kakuro.
     */
    public Kakuro() {
        aleat = new Random();

        int n = aleat.nextInt(4)+6;
        int m = aleat.nextInt(4)+6;

        board = new Tauler(n,m);


        int id2 = (int) (Math.random() * 5000);
        id = id2+"";
    }

    /**
     * Generar.
     */
    public void generar() {

        int minimo = Math.min(board.getDimn(), board.getDimm());
        int ca_negras = ((board.getDimn()* board.getDimm()) / 2) - minimo ;

        board.print_negras(ca_negras);
        board.rellenar_celdas_blancas();
        board.hacer_sumas();
        board.borrar_blancas(0); //els que volem + 1
        board.print();
    }

    /**
     * Generar usuario.
     *
     * @param negras   the negras
     * @param restants the restants
     */
    public void generar_usuario( int negras, int restants) {
        board.print_negras(negras);
        board.rellenar_celdas_blancas();
        board.hacer_sumas();
        board.borrar_blancas(restants);
        board.print();
    }


    /**
     * Gets board.
     *
     * @return the board
     */
    public Tauler getBoard() {
        return board;
    }

    /**
     * Get id string.
     *
     * @return the string
     */
    public String getId(){return id; }

    /**
     * Sets id.
     *
     * @param Identif the identif
     */
    public void setId(String Identif) {
        id = Identif;
    }

    /**
     * Sets tauler.
     *
     * @param t the t
     */
    public void setTauler(Tauler t) {
        board = t;
    }

    /**
     * Sets kakuro.
     *
     * @param k the k
     */
    public void setKakuro(Kakuro k) {
        id = k.getId();
        board = k.getBoard();
    }
}
