package domain.kakuro;
import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;

import java.util.Random;

/**
 * The type Tauler.
 */
public class Tauler {

    private Cella CjtCelles[][]; // Conjunt de cel·les
    private int dimn, dimm;

    /**
     * Instantiates a new Tauler.
     *
     * @param n the n
     * @param m the m
     */
    public Tauler(int n, int m) {

        dimn = n;
        dimm = m;

        this.CjtCelles = new Cella[n][m];

        for(int i = 0; i < this.CjtCelles.length; ++i) {
            for (int j = 0; j < this.CjtCelles[0].length; ++j) {
                if (i == 0 || j == 0) this.CjtCelles[i][j] = new CellaNegra();
                else this.CjtCelles[i][j] = new Cella();
            }
        }

        // PINTAR FILA 1 y COLUMNA 1

    }

    public void setTauler(Cella[][] cjt) {
        CjtCelles = cjt;
    }

    /**
     * Gets dimm.
     *
     * @return the dimm
     */
    public int getDimm() {
        return dimm;
    }

    /**
     * Gets dimn.
     *
     * @return the dimn
     */
    public int getDimn() {
        return dimn;
    }

    /*

    Aquesta funcio comproba si una casella és valida per assignar-li una negra.
     */

    /**
     * Pos valida boolean.
     *
     * @param i the
     * @param j the j
     * @return the boolean
     */
    public boolean posValida(int i, int j) {

        //Si devuelve 0, es blanca
        if (CjtCelles[i - 1][j].color() == 0) {
            if (i > 2 && CjtCelles[i - 2][j].color() == 1) return false;
        }

        if (CjtCelles[i][j - 1].color() == 0) {
            if (j > 2 && CjtCelles[i][j - 2].color() == 1) return false;
        }

        return true;
    }


    /**
     * Pintar celda int.
     *
     * @param i        the
     * @param j        the j
     * @param cantidad the cantidad
     * @return the int
     */
    public int pintar_celda(int i, int j, int cantidad) {

        if (cantidad == 0) return cantidad;
        else --cantidad;
        CjtCelles[i][j] = new CellaNegra();
        if (cantidad == 0) return cantidad;
        else --cantidad;

        int k = dimn - i;
        int l = dimm - j;
        CjtCelles[k][l] = new CellaNegra();

        return cantidad;
    }

    /**
     * Pintar negras.
     *
     * @param cantidad the cantidad
     */
    public void pintar_negras(int cantidad) {

        int contador_blancas = 0;


        Random aleat = new Random();

        for (int i = 1; i < dimn; ++i) {
            for (int j = 1; j < dimm; ++j) {

                int n = aleat.nextInt(dimm);

                if (posValida(i, j)) {

                    if (n == j) cantidad = pintar_celda(i, j, cantidad);
                    else {
                        CjtCelles[i][j] = new CellaBlanca();
                        ++contador_blancas;
                    }

                    if (contador_blancas > 9) {
                        cantidad = pintar_celda(i, j, cantidad);
                        contador_blancas = 0;
                    }

                    if ((i >= dimn / 2) && (j >= dimn / 2) && cantidad >= (dimn * dimm)) {

                        cantidad = pintar_celda(i, j, cantidad);

                    }


                }
                else
                    CjtCelles[i][j] = new CellaBlanca();
            }
        }


    }

    /**
     * Generar aleatorios int.
     *
     * @return the int
     */
    public int generar_aleatorios() {

        Random aleat = new Random();
        int n = aleat.nextInt(9) + 1;

        return n;

    }

    /**
     * Presente fila boolean.
     *
     * @param aleat the aleat
     * @param i     the
     * @param j     the j
     * @return the boolean
     */
    public boolean presente_fila(int aleat, int i, int j) {

        for (int x = 1; x < j; ++x)
            if (CjtCelles[i][x].color() == 0)
                if (CjtCelles[i][x].getValor_blanca() == aleat) return true;
        return false;

    }


    /**
     * Presente col boolean.
     *
     * @param aleat the aleat
     * @param i     the
     * @param j     the j
     * @return the boolean
     */
    public boolean presente_col (int aleat,int i, int j) {
        for (int x = 1; x < i; ++x)
            if (CjtCelles[x][j].color() == 0)
                if (CjtCelles[x][j].getValor_blanca() == aleat) return true;
        return false;

    }

    public boolean presenteFilaCol(int aleat, int i, int j) {
        for (int x = 1; x < j; ++x) {
            if (CjtCelles[i][x].color() == 0)
                if (CjtCelles[i][x].getValor_blanca() == aleat) return true;
        }
        for (int y = 1; y < i; ++y) {
            if (CjtCelles[y][j].color() == 0)
                if (CjtCelles[y][j].getValor_blanca() == aleat) return true;
        }
        return false;
    }


    /**
     * Rellenar blancas.
     */
    public void rellenar_blancas() {

        //Set<Set<Integer>>  set_deN = new HashSet<>(); // VALOR DEL KAKURO (nxm)
        int numAleat;
        for (int i = 1; i < dimn; ++i) {
           // Set<Integer> fila = new HashSet<>();


            for (int j = 1; j < dimm; ++j) {

            if((CjtCelles[i][j]).color() == 0) {

                numAleat = generar_aleatorios();

                while(presenteFilaCol(numAleat, i, j)) { //!presente_fila(numAleat,i,j ) && !presente_col(numAleat,i,j)
                        numAleat = generar_aleatorios();

                    }

                CjtCelles[i][j].intro_valor_blanca(numAleat);

            }

            }
        }
    }

    /**
     * Hacer sumas.
     */
    public void hacer_sumas() {

        for (int i = 0; i < dimn; ++i) {

            for (int j = 0; j < dimm; ++j) {
                if (CjtCelles[i][j].color() == 1) {
                    int auxj = 1;

                    while (j + auxj < dimm && CjtCelles[i][j + auxj].color() == 0) {
                        int valor = CjtCelles[i][j+auxj].getValor_blanca();
                        CjtCelles[i][j].acumular_valor_derecha(valor);
                        ++auxj;

                    }
                    int auxi = 1;
                    while (i + auxi < dimn && CjtCelles[i + auxi][j].color() == 0) {
                        int valor = CjtCelles[i + auxi][j].getValor_blanca();
                        CjtCelles[i][j].acumular_valor_izquierda(valor);
                        ++auxi;
                    }


                }

            }

        }
    }

    /**
     * Borrar blancas.
     */
    public void borrar_blancas() {
        for (int i = 1; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (CjtCelles[i][j].color() == 0) CjtCelles[i][j].intro_valor_blanca(-1);
            }
        }
    }

    public void solucionar(){
        long startTime = System.nanoTime();
        if(solBacktracking(this.CjtCelles, 0, 0)) {
            System.out.println("Solució trobada: \n");
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);

            System.out.println("Execution time in milliseconds : " +
                    timeElapsed / 1000000);
            print();
        }
        else{
            System.out.println("No s'ha trobat solució \n");
        }
    }

    public static boolean solBacktracking(Cella[][] board, int fila, int col) {
        final int nFila = board.length;
        final int nCol = board[0].length;

        if(fila == nFila) return true;

        else if(col == nCol) {
            return solBacktracking(board,fila+1, 0);
        }

        else if(board[fila][col].color() == 1) {
            return solBacktracking(board, fila, col+1);
        }

        for(int valor=1; valor <= 9; ++valor) {
            if(valorValid(board, fila, col, valor)) {
                board[fila][col].intro_valor_blanca(valor);
                if(solBacktracking(board, fila, col+1)) {
                    return true;    //Modificar para que devuelva mas de una solucion
                }
                else{
                    board[fila][col].intro_valor_blanca(0);
                }
            }
        }
        return false;
    }

    private static boolean valorValid(Cella[][] board, int fila, int col, int valor) {

        if(valorValidFila(board,fila,col,valor) && valorValidCol(board,fila,col,valor)){
            return true;
        }
        else
            return false;
    }

    private static boolean valorValidFila(Cella[][] board, int fila, int col, int valor) {
        int suma = valor;
        int sumaNegras = 0;

        for(int i = col-1; i >= 0; --i) {
            if(board[fila][i].color() == 1){
                sumaNegras = board[fila][i].getValorDret();
                break;
            }
            suma += board[fila][i].getValor_blanca();
            if(board[fila][i].getValor_blanca() == valor)
                return false;
        }
        if(suma > sumaNegras)
            return false;

        if(col == board[0].length - 1) {
            if(suma < sumaNegras)
                return false;
        }
        else if(board[fila][col+1].color() == 1) {
            if(suma < sumaNegras)
                return false;
        }
        return true;
    }

    private static boolean valorValidCol(Cella[][] board, int fila, int col, int valor){
        int suma = valor;
        int sumaNegras = 0;

        for(int i = fila-1; i >= 0; --i) {
            if(board[i][col].color() == 1){
                sumaNegras = board[i][col].getValorEsquerre();
                break;
            }
            suma += board[i][col].getValor_blanca();
            if(board[i][col].getValor_blanca() == valor)
                return false;
        }
        if(suma > sumaNegras)
            return false;

        if(fila == board.length - 1) {
            if(suma < sumaNegras)
                return false;
        }
        else if(board[fila+1][col].color() == 1) {
            if(suma < sumaNegras)
                return false;
        }
        return true;
    }



    /**
     * Print.
     */
    public void print() {
        System.out.printf("%s,%s%n",dimn,dimm);
        for (int i = 0; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (this.CjtCelles[i][j].color() == 0) {
                    if(this.CjtCelles[i][j].getValor_blanca() > 0)
                        System.out.print(this.CjtCelles[i][j].getValor_blanca());
                    else
                        System.out.print("?");

                } else {
                    int valorColumna = this.CjtCelles[i][j].getValorEsquerre();
                    int valorFila = this.CjtCelles[i][j].getValorDret();
                    if(valorColumna > 0 && valorFila > 0) {
                        System.out.printf("C%sF%s",valorColumna,valorFila);
                    }
                    else if(valorColumna > 0)
                        System.out.printf("C%s",valorColumna);

                    else if(valorFila > 0)
                        System.out.printf("F%s",valorFila);

                    else
                        System.out.print("*");


                }
                if(j != this.CjtCelles[0].length - 1)
                    System.out.print(",");
            }

            System.out.print("\n");
        }
    }
}
