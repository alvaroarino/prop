package domain.kakuro;

import java.util.Random;

public class Kakuro {
    String id;
    Random aleat;
    Tauler board;

    public Kakuro(int n, int m) {
        aleat = new Random();
        board = new Tauler(n, m);
        int id2 = (int) Math.random()*5000;
        id = id2+"";
    }

    public Kakuro() {
        aleat = new Random();

        int n = aleat.nextInt(4)+6;
        int m = aleat.nextInt(4)+6;

        board = new Tauler(n,m);


        int id2 = (int) Math.random()*5000;
        id = id2+"";
    }

    public void generar() {

        int minimo = Math.min(board.getDimn(), board.getDimm());
        int ca_negras = ((board.getDimn()* board.getDimm()) / 2) - minimo ;

        board.print_negras(ca_negras);
        board.rellenar_celdas_blancas();
        board.hacer_sumas();
        board.borrar_blancas(4); //els que volem + 1
        //board.print();
    }

    public void generar_usuario(int n, int m, int negras, int blancas) {
        if (negras + blancas != (n*m)) {
            System.out.println("La quantitat de caselles introduïdes no coincideix amb la dimensió escollida");
            return;
        }
        board.print_negras(negras);
        board.rellenar_celdas_blancas();
        board.hacer_sumas();
        board.borrar_blancas(0);
        board.print();
    }



    public Tauler getBoard() {
        return board;
    }

    public String getId(){return id; }

    public void setId(String Identif) {
        id = Identif;
    }

    public void setTauler(Tauler t) {
        board = t;
    }

    public void setKakuro(Kakuro k) {
        id = k.getId();
        board = k.getBoard();
    }
}
