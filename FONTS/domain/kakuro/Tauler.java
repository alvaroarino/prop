package domain.kakuro;

import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;

import javax.print.CancelablePrintJob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Tauler {

    private Cella[][] CjtCelles; // Conjunt de cel·les
    private final int dimn, dimm;

    public Tauler(int n, int m) {

        dimn = n;
        dimm = m;

        this.CjtCelles = new Cella[n][m];

        for (int i = 0; i < this.CjtCelles.length; ++i) {
            for (int j = 0; j < this.CjtCelles[0].length; ++j) {
                if (i == 0 || j == 0) this.CjtCelles[i][j] = new CellaNegra();
                else this.CjtCelles[i][j] = new CellaBlanca();
            }
        }

    }

    public void setTauler(Cella[][] cjt) {
        CjtCelles = cjt;
    }

    public int getDimm() {
        return dimm;
    }

    public int getDimn() {
        return dimn;
    }

    public Cella getCella(int i, int j) {
        return CjtCelles[i][j];
    }

    /*public boolean posValidaGran(int i, int j) {
        if(CjtCelles[i-1][j].color() == ColorCella.Blanca) {
            if(i > 1 && CjtCelles[i-2][j].color() != ColorCella.Blanca) {
                return false;
            }
        }
        if(CjtCelles[i])
    }*/


    // Aquesta funcio comproba si una casella és valida per assignar-li una negra.
    public boolean posValida(int i, int j) {
        // Considerem la cella actual [i][j]
        // Si l'anterior cap a l'esquerra es blanca i l'anterior a aquesta es negra no es valida la posicio
        if (CjtCelles[i - 1][j].color() == ColorCella.Blanca) {
            if (i >= 2 && CjtCelles[i - 2][j].color() == ColorCella.Negra) return false;
        }

        // Si la posterior cap a la dreta es blanca i la posterior a aquesta es negra no es valida la posicio
        if (i < dimn-1 && CjtCelles[i+1][j].color() == ColorCella.Blanca) {
            if (i < dimn-2 && CjtCelles[i+2][j].color() == ColorCella.Negra) return false;
        }

        // Si l'anterior cap a amunt es blanca i l'anterior a aquesta es negra no es valida la posicio
        if (CjtCelles[i][j - 1].color() == ColorCella.Blanca) {
            return j <= 2 || CjtCelles[i][j - 2].color() != ColorCella.Negra;
        }

        // Si la posterior cap a baix es blanca i la posterior a aquesta es negra no es valida la posicio
        if (j < dimm-1 && CjtCelles[i][j+1].color() == ColorCella.Blanca) {
            if (j < dimm-2 && CjtCelles[i][j+2].color() == ColorCella.Negra) return false;
        }

        // Quan no trobem una negra la posició es valida
        return true;
    }


    public int pintar_celda(int i, int j, int cantidad) {
        // Cada vegada que pintem una cella hem de retornar el nombre restant de celles negres que pintem
        // Si la quantitat no es 0 podem pintar una cella negra.
        if (cantidad <= 0) return cantidad;
        else --cantidad;
        CjtCelles[i][j] = new CellaNegra();

        if (cantidad <= 0) return cantidad;
        else --cantidad;
        // Apliquem el mirall per pintar negra, sempre que tinguem celles negres per pintar
        int k = dimn - i;
        int l = dimm - j;
        CjtCelles[k][l] = new CellaNegra();

        return cantidad;
    }

    public void pintar_negras(int cantidad) {
        //int contador_blancas = 0;
        Random aleat = new Random();


        for (int i = 1; i < dimn; ++i) {
            for (int j = 1; j < dimm; ++j) {
                int n = aleat.nextInt(dimm);
                if (posValida(i, j)) {
                    if (n == j) cantidad = pintar_celda(i, j, cantidad);
                    /*else {
                        ++contador_blancas;
                    }*/

                    /*if (contador_blancas > 9) {
                        cantidad = pintar_celda(i, j, cantidad);
                        contador_blancas = 0;
                    }*/

                    if ((i >= dimn / 2) && (j >= dimn / 2) && cantidad >= (dimn * dimm)) {
                        cantidad = pintar_celda(i, j, cantidad);
                    }
                }
            }
        }
        if(dimn > 9 || dimm > 9) {
            int length;
            for (int i = 0; i < dimn; ++i) {
                length = 0;
                for(int j = 0; j < dimm; ++j) {
                    if (CjtCelles[i][j].color() == ColorCella.Blanca) {
                        ++length;
                    } else {
                        length = 0;
                    }

                    if (length > 9) {
                        CjtCelles[i][j] = new CellaNegra();
                        length = 0;
                    }

                }
            }

            for (int i = 0; i < dimm; ++i) {
                length = 0;
                for (int j = 0; j < dimn; ++j) {
                    if (CjtCelles[j][i].color() == ColorCella.Blanca) {
                        ++length;
                    } else{
                        length = 0;
                    }
                    if (length > 9) {
                        CjtCelles[j][i] = new CellaNegra();
                        length = 0;
                    }
                }
            }
        }
    }

    public boolean noPresenteCol(int valor, int i, int j) {
        // Mirem a les columnes si tenim valors ja introduits per no repetir el valor a introduir.
        // Retorna true si valor no es present, i si hi es false.

        // Comencem des de la posicio actual i anem cap amunt.
        for (int x = j; x > 0; --x) {
            if (CjtCelles[x][i].color() == ColorCella.Blanca) {
                if (CjtCelles[x][i].getValor_blanca() == valor) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean noPresente(int valor, int fila, int col) {  // false si esta, true si no esta

        //Mira casella esquerra
        int d;
        d = col - 1;
         while(d >0  && CjtCelles[fila][d].color() !=ColorCella.Negra) {
             if(CjtCelles[fila][d].color() == ColorCella.Blanca && CjtCelles[fila][d].getValor_blanca() == valor) return true;
             --d;
         }
        //Mira casella dreta
         d= col+1;
         while(d < dimm  && CjtCelles[fila][d].color() !=ColorCella.Negra) {
             if(CjtCelles[fila][d].color() == ColorCella.Blanca && CjtCelles[fila][d].getValor_blanca() == valor) return true;
             ++d;
         }

        //Mira casella d'adalt
        d = fila - 1;
        while(d >0   && CjtCelles[d][col].color() !=ColorCella.Negra ) {
            if(CjtCelles[d][col].color() == ColorCella.Blanca && CjtCelles[d][col].getValor_blanca() == valor) return true;
            --d;
        }
        //Mira casella d'adalt
        d= fila+1;
        while(d < dimn && CjtCelles[d][col].color() !=ColorCella.Negra) {
            if(CjtCelles[d][col].color() == ColorCella.Blanca && CjtCelles[d][col].getValor_blanca() == valor) return true;
            ++d;
        }

        return false;


    }

    public boolean rellenar_blancas1() {
        int aux;
        boolean[] possibles = new boolean[9];
        for(int k = 0; k < 9; ++k) {
            possibles[k] = true;
        }
        Random aleat = new Random();
        for(int i = 0; i < dimn; ++i) {
            for(int j = 0; j < dimm; ++j) {
                if(CjtCelles[i][j].color() == ColorCella.Blanca) {
                    aux = aleat.nextInt(9) + 1;
                    CjtCelles[i][j].intro_valor_blanca(aux);
                    while (noPresente(aux,i,j)) {
                        possibles[aux-1] = false;
                        if(!possibles[0] && !possibles[1] && !possibles[2] && !possibles[3] && !possibles[4] && !possibles[5] && !possibles[6] && !possibles[7] && !possibles[8]) {
                            return false;
                        }
                        aux = aleat.nextInt(9) + 1;
                        CjtCelles[i][j].intro_valor_blanca(aux);
                    }

                }

                for(int k = 0; k < 9; ++k) {
                    possibles[k] = true;
                }
            }
        }
        return true;
    }

    public void rellenar_blancas() {
        int numAleat;
        int valor;
        Random aleat = new Random();
        for (int i = 1; i < dimn; ++i) {
            ArrayList<Integer> candidats = new ArrayList<Integer>();
            for(int k=1; k<10; ++k){
                candidats.add(k);
            }
            int elements = candidats.size();
            for (int j = 1; j < dimm; ++j) {
                if ((CjtCelles[i][j]).color() == ColorCella.Blanca) {
                    //numAleat = aleat.nextInt(elements);
                    boolean presente = true;
                    valor = -1;
                    while(presente) {
                        numAleat = aleat.nextInt(elements);
                        valor = candidats.get(numAleat);
                        if(noPresenteCol(valor,i,j)) presente = false;
                    }
    

                    CjtCelles[i][j].intro_valor_blanca(valor);
                    --elements;
    
                }
                else {
                    candidats.clear();
                    for(int k=1; k<10; ++k){
                        candidats.add(k);
                    }
                    elements = candidats.size();
                }
            }
        }
    }

    public void hacer_sumas() {
        for (int i = 0; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (CjtCelles[i][j].color() == ColorCella.Negra) {
                    int auxj = 1;

                    while (j + auxj < dimm && CjtCelles[i][j + auxj].color() == ColorCella.Blanca) {
                        int valor = CjtCelles[i][j + auxj].getValor_blanca();
                        CjtCelles[i][j].acumular_valor_derecha(valor);
                        ++auxj;
                    }

                    int auxi = 1;
                    while (i + auxi < dimn && CjtCelles[i + auxi][j].color() == ColorCella.Blanca) {
                        int valor = CjtCelles[i + auxi][j].getValor_blanca();
                        CjtCelles[i][j].acumular_valor_izquierda(valor);
                        ++auxi;
                    }
                }
            }
        }
    }

    public void borrar_blancas() {
        for (int i = 1; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (CjtCelles[i][j].color() == ColorCella.Blanca) CjtCelles[i][j].intro_valor_blanca(-1);
            }
        }
    }

    public void solucionar(){
        long startTime = System.nanoTime();
        if (solBacktracking(this.CjtCelles, 0, 0)) {
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

        if (fila == nFila) return true;

        else if (col == nCol) {
            return solBacktracking(board,fila+1, 0);
        }

        else if (board[fila][col].color() == ColorCella.Negra) {
            return solBacktracking(board, fila, col+1);
        }

        for (int valor=1; valor <= 9; ++valor) {
            if (valorValid(board, fila, col, valor)) {
                board[fila][col].intro_valor_blanca(valor);
                if (solBacktracking(board, fila, col+1)) {
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
        return valorValidFila(board, fila, col, valor) && valorValidCol(board, fila, col, valor);
    }

    private static boolean valorValidFila(Cella[][] board, int fila, int col, int valor) {
        int suma = valor;
        int sumaNegras = 0;

        for (int i = col-1; i >= 0; --i) {
            if (board[fila][i].color() == ColorCella.Negra){
                sumaNegras = board[fila][i].getValorDret();
                break;
            }
            suma += board[fila][i].getValor_blanca();
            if (board[fila][i].getValor_blanca() == valor)
                return false;
        }
        if (suma > sumaNegras)
            return false;

        if (col == board[0].length - 1) {
            return suma >= sumaNegras;
        }
        else if (board[fila][col+1].color() == ColorCella.Negra) {
            return suma >= sumaNegras;
        }
        return true;
    }

    private static boolean valorValidCol(Cella[][] board, int fila, int col, int valor){
        int suma = valor;
        int sumaNegras = 0;

        for (int i = fila-1; i >= 0; --i) {
            if (board[i][col].color() == ColorCella.Negra){
                sumaNegras = board[i][col].getValorEsquerre();
                break;
            }
            suma += board[i][col].getValor_blanca();
            if (board[i][col].getValor_blanca() == valor)
                return false;
        }
        if (suma > sumaNegras)
            return false;

        if (fila == board.length - 1) {
            return suma >= sumaNegras;
        }
        else if (board[fila+1][col].color() == ColorCella.Negra) {
            return suma >= sumaNegras;
        }
        return true;
    }


    public void print() {
        System.out.printf("%s,%s%n",dimn,dimm);
        for (int i = 0; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (this.CjtCelles[i][j].color() == ColorCella.Blanca) {
                    if (this.CjtCelles[i][j].getValor_blanca() > 0) {
                        System.out.print(this.CjtCelles[i][j].getValor_blanca());
                    } else {
                        System.out.print("?");
                    }

                } else {
                    int valorColumna = this.CjtCelles[i][j].getValorEsquerre();
                    int valorFila = this.CjtCelles[i][j].getValorDret();

                    if (valorColumna > 0 && valorFila > 0) {
                        System.out.printf("C%sF%s", valorColumna, valorFila);
                    } else if (valorColumna > 0) {
                        System.out.printf("C%s", valorColumna);
                    } else if (valorFila > 0) {
                        System.out.printf("F%s", valorFila);
                    } else {
                        System.out.print("*");
                    }
                }
                if (j != this.CjtCelles[0].length - 1)
                    System.out.print(",");
            }

            System.out.print("\n");
        }
    }
}

