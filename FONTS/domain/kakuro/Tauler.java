package domain.kakuro;

import com.sun.javafx.image.impl.IntArgb;
import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import javafx.util.Pair;

import java.util.Random;

/**
 * The type Tauler.
 */
public class Tauler {

    private Cella[][] CjtCelles; // Conjunt de cel·les
    private /*final*/ int dimn, dimm;
    /**
     * The Solucions trobades.
     */
    int solucionsTrobades;
    private Cella[][] SolucionKakuro;
    /**
     * The Celles negres.
     */
    int cellesNegres;
    /**
     * The Celles blanques.
     */
    int cellesBlanques;
    /**
     * The Celles fixed.
     */
    int cellesFixed;
    /**
     * The Inici.
     */
    int inici, /**
     * The End.
     */
    end;
    /**
     * The Dificulty.
     */
    String dificulty;

    /**
     * Instantiates a new Tauler.
     */
    public Tauler(){
        dimn = 0;
        dimm = 0;
        solucionsTrobades = 0;
    }

    /**
     * Instantiates a new Tauler.
     *
     * @param n the n
     * @param m the m
     */
    public Tauler(int n, int m) {

        dimn = n;
        dimm = m;
        solucionsTrobades = 0;
        cellesNegres = 0;

        this.CjtCelles = new Cella[n][m];

        for (int i = 0; i < this.CjtCelles.length; ++i) {
            for (int j = 0; j < this.CjtCelles[0].length; ++j) {
                if (i == 0 || j == 0){
                    this.CjtCelles[i][j] = new CellaNegra();
                    ++cellesNegres;
                }
                else this.CjtCelles[i][j] = new CellaBlanca();
            }
        }
        cellesBlanques = dimn*dimm - cellesNegres;
        cellesFixed = 0;

        /*Random aleat = new Random();
        int aux = aleat.nextInt(2);
        if(aux == 0){
            inici = 1;
            end = 9;
        }
        else{
            inici = 9;
            end = 1;
        }*/
    }

    /**
     * Calcular dificultad.
     */
    public void calcularDificultad(){
        double d = (double)(cellesBlanques)/(double)(dimm*dimn);
        if(d <= 0.54)
            dificulty = "facil";
        if(d <= 0.59)
            dificulty = "medio";

        dificulty = "hard";
    }

    /**
     * Gets dificulty.
     *
     * @return the dificulty
     */
    public String getDificulty() {
        return dificulty;
    }

    /**
     * Sets dificulty.
     *
     * @param dif the dif
     */
    public void setDificulty(String dif) {
        dificulty = dif;
    }

    /**
     * Deep copy.
     *
     * @param cjt the cjt
     */
    public void deepCopy(Cella[][] cjt) {


        SolucionKakuro = new Cella[dimn][dimm];
        for(int i = 0; i < dimn; ++i) {
            for(int j = 0; j < dimm; ++j) {
                if(cjt[i][j].color() == ColorCella.Negra) {
                    SolucionKakuro[i][j] = new CellaNegra();
                    SolucionKakuro[i][j].setValorColumna(cjt[i][j].getValorEsquerre());
                    SolucionKakuro[i][j].setValorFila(cjt[i][j].getValorDret());
                }
                else{
                    SolucionKakuro[i][j] = new CellaBlanca();
                    this.SolucionKakuro[i][j].intro_valor_blanca(cjt[i][j].getValor_blanca());
                }
            }
        }
    }

    /**
     * Sets tauler.
     *
     * @param cjt the cjt
     */
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

    /**
     * Gets cella.
     *
     * @param i the
     * @param j the j
     * @return the cella
     */
    public Cella getCella(int i, int j) {
        return CjtCelles[i][j];
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
        // Cada vegada que pintem una cella hem de retornar el nombre restant de celles negres que pintem
        // Si la quantitat no es 0 podem pintar una cella negra.
        if (cantidad <= 0) return cantidad;
        else --cantidad;
        CjtCelles[i][j] = new CellaNegra();
        ++cellesNegres;

        if (cantidad <= 0) return cantidad;
        else --cantidad;
        // Apliquem el mirall per pintar negra, sempre que tinguem celles negres per pintar
        int k = dimn - i;
        int l = dimm - j;
        CjtCelles[k][l] = new CellaNegra();
        ++cellesNegres;

        return cantidad;
    }

    /**
     * Posible boolean.
     *
     * @param i the
     * @param j the j
     * @return the boolean
     */
    public boolean posible (int i, int j){

        if((CjtCelles[i-1][j].color() == ColorCella.Blanca) && (i > 1) &&(CjtCelles[i-2][j].color() == ColorCella.Negra)) return false;
        if((CjtCelles[i][j-1].color() == ColorCella.Blanca) && (j > 1) &&(CjtCelles[i][j-2].color() == ColorCella.Negra)) return false;
        if(i < (dimn - 1) && CjtCelles[i+1][j].color() ==ColorCella.Blanca  ) {
            if(i+2 > dimn - 1) return false;
            if(i < (dimn - 2) && CjtCelles[i+2][j].color() ==ColorCella.Negra) return  false;
        }
        if(j < (dimm - 1) && CjtCelles[i][j+1].color() ==ColorCella.Blanca  ) {
            if(j+2 > dimm - 1) return false;
            return j >= (dimm - 2) || CjtCelles[i][j + 2].color() != ColorCella.Negra;
        }
        return true;
    }

    /**
     * Print negras.
     *
     * @param cantidad the cantidad
     */
    public void print_negras(int cantidad) {
        Random aleat = new Random();
        int compt = 0;
        while(cantidad !=0 && compt < 4) {
            for (int i = 1; i < dimn; ++i) {
                for (int j = 1; j < dimm; ++j) {
                    int n = aleat.nextInt(4);
                    if (CjtCelles[i][j].color() == ColorCella.Blanca) {
                        if (n == 3) {
                            if (posible(i, j)) cantidad = pintar_celda(i, j, cantidad);
                        }
                    }

                }

            }
            ++compt; //perque no es quedi bucle infinit
        }


        if(dimn > 9 || dimm > 9) {
            int length;
            for (int i = 0; i < dimn; ++i) {
                length = 0;
                for (int j = 0; j < dimm; ++j) {
                    if (CjtCelles[i][j].color() == ColorCella.Blanca) {
                        ++length;
                    } else {
                        length = 0;
                    }

                    if (length > 9) {
                        CjtCelles[i][j] = new CellaNegra();
                        ++cellesNegres;
                        length = 0;
                    }

                }
            }

            for (int i = 0; i < dimm; ++i) {
                length = 0;
                for (int j = 0; j < dimn; ++j) {
                    if (CjtCelles[j][i].color() == ColorCella.Blanca) {
                        ++length;
                    } else {
                        length = 0;
                    }
                    if (length > 9) {
                        CjtCelles[j][i] = new CellaNegra();
                        ++cellesNegres;
                        length = 0;
                    }
                }
            }
        }
        cellesBlanques = dimn*dimm - cellesNegres;
    }

    /**
     * No presente boolean.
     *
     * @param valor the valor
     * @param fila  the fila
     * @param col   the col
     * @return the boolean
     */
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

    /**
     * Rellenar celdas blancas.
     */
    public void rellenar_celdas_blancas() {
        rellenar_blancas_back(this.CjtCelles, 0, 0);
    }

    private boolean rellenar_blancas_back(Cella[][] board, int fila, int col) {
        final int nFila = board.length;
        final int nCol = board[0].length;

        if (fila == nFila) return true;

        else if (col == nCol) {
            return rellenar_blancas_back(board,fila+1, 0);
        }

        else if (board[fila][col].color() == ColorCella.Negra) {
            return rellenar_blancas_back(board, fila, col+1);
        }

        for (int valor= 1; valor <= 9; ++valor) {
            if (valorDuplicat(board, fila, col, valor)) {
                board[fila][col].intro_valor_blanca(valor);
                if (rellenar_blancas_back(board, fila, col+1)) {
                    return true;
                }
                else{
                    board[fila][col].intro_valor_blanca(-1);
                }
            }
        }
        return false;
    }

    private static boolean valorDuplicat(Cella[][] board, int fila, int col, int valor) {
        return valorDuplicatFila(board, fila, col, valor) && valorDuplicatCol(board, fila, col, valor);
    }

    private static boolean valorDuplicatFila(Cella[][] board, int fila, int col, int valor) {

        for (int i = col-1; i >= 0; --i) {
            if (board[fila][i].color() == ColorCella.Negra){
                break;
            }
            if (board[fila][i].getValor_blanca() == valor)
                return false;
        }
        return true;
    }

    private static boolean valorDuplicatCol(Cella[][] board, int fila, int col, int valor) {

        for (int i = fila-1; i >= 0; --i) {
            if (board[i][col].color() == ColorCella.Negra){
                break;
            }
            if (board[i][col].getValor_blanca() == valor)
                return false;
        }

        return true;
    }

    /**
     * Hacer sumas.
     */
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

    /**
     * Borrar blancas.
     *
     * @param restants the restants
     */
    public void borrar_blancas(int restants) {
        int n = -1;
        int aux = (dimm * dimn) - cellesNegres; //celles blanques
        int m = -1;
        if(restants == 1) {
            Random aleat = new Random();
            n = aleat.nextInt(aux);
        }
        else if(restants > 1){
            m = aux/restants;
        }
        int compt = 0;
        for (int i = 1; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (CjtCelles[i][j].color() == ColorCella.Blanca) {
                    if(!CjtCelles[i][j].cellaFixed()) {
                        if (restants == 0) {
                            CjtCelles[i][j].intro_valor_blanca(-1);
                        } else {
                            if ((restants > 1) && (compt != m)) {
                                CjtCelles[i][j].intro_valor_blanca(-1);
                            } else if ((restants == 1) && (compt != n)) {
                                CjtCelles[i][j].intro_valor_blanca(-1);
                            } else {
                                CjtCelles[i][j].fixCellaBlanca();
                                ++cellesFixed;
                            }
                        }
                        if (compt == m) compt = 0;
                        ++compt;
                    }
                }
            }
        }
    }

    /**
     * Solve.
     *
     * @return the int
     */
    public int solve() {

        solBack2(this.CjtCelles, 0, 0);
        /*if(solucionsTrobades > 1) {
            System.out.println("El kakuro te mes d'una solucio \n");
            printSol();
        }
        else if(solucionsTrobades == 1) {
            System.out.println("El kakuro te una unica solucio \n");
            printSol();
        }
        else {
            System.out.println("No s'ha trobat solucio \n");
        }*/
        return solucionsTrobades;
    }

    private void solBack2(Cella[][] board, int fila, int col) {
        final int nFila = board.length;
        final int nCol = board[0].length;

        if (fila == nFila){
            solucionsTrobades = solucionsTrobades +1;
            deepCopy(board);
            print();
        }

        else if (col == nCol) {
            solBack2(board,fila+1, 0);
        }

        else if (board[fila][col].color() == ColorCella.Negra) {
            solBack2(board, fila, col+1);
        }

        else if(board[fila][col].cellaFixed()) {
            solBack2(board, fila, col+1);
        }

        for (int valor=1; valor <= 9; ++valor) {
            if (valorValid(board, fila, col, valor)) {
                if(!board[fila][col].cellaFixed()) {
                    board[fila][col].intro_valor_blanca(valor);
                    solBack2(board, fila, col + 1);
                    board[fila][col].intro_valor_blanca(0);
                }
            }
        }
    }

    private boolean valorValid(Cella[][] board, int fila, int col, int valor) {
        return valorValidFila(board, fila, col, valor) && valorValidCol(board, fila, col, valor) && valorValidFilaAvall(board, fila, col, valor) && valorValidColDreta(board,fila,col,valor);
    }

    private boolean valorValidFila(Cella[][] board, int fila, int col, int valor) {
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

    private boolean valorValidFilaAvall(Cella[][] board, int fila, int col, int valor) {

        for (int i = col+1; i < dimm; ++i) {
            if (board[fila][i].color() == ColorCella.Negra){
                break;
            }
            if (board[fila][i].getValor_blanca() == valor)
                return false;
        }

        return true;
    }

    private boolean valorValidCol(Cella[][] board, int fila, int col, int valor){
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

    private boolean valorValidColDreta(Cella[][] board, int fila, int col, int valor){

        for (int i = fila+1; i < dimn; ++i) {
            if (board[i][col].color() == ColorCella.Negra){
                break;
            }
            if (board[i][col].getValor_blanca() == valor)
                return false;
        }
        return true;
    }

    /**
     * Print sol.
     */
    public void printSol() {
        System.out.printf("%s,%s%n",dimn,dimm);
        for (int i = 0; i < dimn; ++i) {
            for (int j = 0; j < dimm; ++j) {
                if (this.SolucionKakuro[i][j].color() == ColorCella.Blanca) {
                    if (this.SolucionKakuro[i][j].getValor_blanca() > 0) {
                        System.out.print(this.SolucionKakuro[i][j].getValor_blanca());
                    } else {
                        System.out.print("?");
                    }

                } else {
                    int valorColumna = this.SolucionKakuro[i][j].getValorEsquerre();
                    int valorFila = this.SolucionKakuro[i][j].getValorDret();

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
                if (j != this.SolucionKakuro[0].length - 1)
                    System.out.print(",");
            }

            System.out.print("\n");
        }
    }

    /**
     * Print.
     */
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

    /**
     * Dar pista.
     */
    public void darPista(){
        if(solucionar(this.CjtCelles, 0,0)){
            borrar_blancas(1);
        }
        else{
            System.out.println("No es pot donar una pista ja que la solució parcial no és valida");
        }
    }

    private boolean solucionar(Cella[][] board, int fila, int col) {
        final int nFila = board.length;
        final int nCol = board[0].length;

        if (fila == nFila) return true;

        else if (col == nCol) {
            return solucionar(board,fila+1, 0);
        }
        else if(board[fila][col].color() == ColorCella.Negra) {
            return solucionar(board, fila, col+1);
        }

        else if(board[fila][col].cellaFixed()) {
            return solucionar(board, fila, col+1);
        }

        for (int valor=1; valor <= 9; ++valor) {
            if (valorValid(board, fila, col, valor)) {
                if(!board[fila][col].cellaFixed()) {
                    board[fila][col].intro_valor_blanca(valor);
                    if(solucionar(board,fila,col+1)) {
                        return true;
                    }
                    else{
                        board[fila][col].intro_valor_blanca(0);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Validar string.
     *
     * @return the string
     */
    public String validar() {
        for(int i = 0; i < dimn; ++i) {
            for(int j = 0; j < dimm; ++j) {
                if(CjtCelles[i][j].color() == ColorCella.Negra) {
                    if(CjtCelles[i][j].getValorEsquerre() != -1) {
                        Pair<Integer, String> x = comprovarColumna(i,j,CjtCelles[i][j].getValorEsquerre());
                        if(x.getKey() == -1) {
                            return x.getValue();
                        }
                    }
                    else if(CjtCelles[i][j].getValorDret() != -1) {
                        Pair<Integer, String> x = comprovarFila(i,j,CjtCelles[i][j].getValorDret());
                        if(x.getKey() == -1) {
                            return x.getValue();
                        }
                    }
                }
            }
        }
       return "Enhorabona, has solucionat el kakuro!" ;

    }

    private Pair<Integer,String> comprovarColumna(int i, int j, int valor) {

        int sumaParcial = 0;
        boolean[] presents = new boolean[9];

        for(int l = 0; l < 9; ++l) {
            //Aquest vector serveix per saber si hi ha repetits
            presents[l] = false;
        }
        for(int x = i+1; x < dimn; ++x) {
            if(CjtCelles[x][j].color() == ColorCella.Blanca) {
                if(CjtCelles[x][j].getValor_blanca() < 1 || CjtCelles[x][j].getValor_blanca() > 9)  return new Pair<>(-1, "Valor no valid a la columna " + (j+1));

                if(CjtCelles[x][j].getValor_blanca() == -1 || CjtCelles[x][j].getValor_blanca() == 0) {
                    System.out.println("Valor no valid a la columna " + (j+1));
                    return new Pair<>(-1, "Valor no valid a la columna " + (j+1));
                }
                else if(presents[CjtCelles[x][j].getValor_blanca() - 1]){
                    System.out.println("Valor repetit a la columna " + (j+1));
                    return new Pair<>(-1, "Valor repetit a la columna " + (j+1));
                }
                else if(sumaParcial >= valor) {
                    System.out.println("Error de suma a la columna " + (j+1));
                    return new Pair<>(-1, "Error de suma a la columna " + (j+1));
                }
                else {
                    sumaParcial += CjtCelles[x][j].getValor_blanca();
                    presents[CjtCelles[x][j].getValor_blanca()-1] = true;
                }
            }
            else {
                for(int l = 0; l < 9; ++l) {
                    presents[l] = false;
                }

                if(sumaParcial != valor) {
                    System.out.println("Suma no correcte a la columna " + (j+1));
                    return new Pair<>(-1, "Suma no correcta a la columna " + (j+1));
                }
                return new Pair<>(0, "Correcto"); //correcto
            }
        }
        if (sumaParcial != valor) {
            System.out.println("Suma no correcte");
            return new Pair<>(-1, "Suma no correcte a la columna " + (j+1));
        }
        return new Pair<>(0, "Correcto"); //correcto
    }

    private Pair<Integer, String> comprovarFila(int i, int j, int valor) {
        int sumaParcial = 0;
        boolean[] presents = new boolean[9];

        for(int l = 0; l < 9; ++l) {
            presents[l] = false;
        }
        for(int x = j+1; x < dimm; ++x) {
            if(CjtCelles[i][x].color() == ColorCella.Blanca) {
                if(CjtCelles[i][x].getValor_blanca() < 1 || CjtCelles[i][j].getValor_blanca() > 9)  return new Pair<>(-1, "Valor no valid a la fila " + (i+1));

                if(CjtCelles[i][x].getValor_blanca() == -1 || CjtCelles[i][x].getValor_blanca() == 0) {
                    System.out.println("Valor no valid en fila " + (i+1));
                    return new Pair<>(-1, "Valor no valid en fila " + (i+1));
                }
                else if(presents[CjtCelles[i][x].getValor_blanca() - 1]){
                    System.out.println("Valor repetit en fila " + (i+1));
                    return new Pair<>(-1, "Valor repetit en fila " + (i+1));
                }
                else if(sumaParcial >= valor) {
                    System.out.println("Error de suma a la fila" + (i+1));
                    return new Pair<>(-1, "Error de suma a la fila" + (i+1));
                }
                else{
                    sumaParcial += CjtCelles[i][x].getValor_blanca();
                    presents[CjtCelles[i][x].getValor_blanca()-1] = true;
                }
            }
            else{
                for(int l = 0; l < 9; ++l) {
                    presents[l] = false;
                }
                if(sumaParcial != valor) {
                    System.out.println("Suma no correcte a la fila" + (i+1));
                    return new Pair<>(-1, "Suma no correcta a la fila" + (i+1));
                }
                return new Pair<>(0, "Correcto"); //correcto
            }
        }
        if(sumaParcial != valor) {
            System.out.println("Suma no correcte a la fila" + (i+1));
            return new Pair<>(-1, "Suma no correcte a la fila" + (i+1));
        }
        return new Pair<>(0, "Correcto"); //correcto
    }

    /**
     * Sets cella blanca.
     *
     * @param i      the
     * @param j      the j
     * @param actual the actual
     */
    public void setCellaBlanca (int i, int j, int actual) {
        CjtCelles[i][j].intro_valor_blanca(actual);
    }

    /**
     * Sets cjt celles.
     *
     * @param c the c
     */
    public void setCjtCelles(Cella[][] c) {
        CjtCelles = c;
    }

    /**
     * Sets dimn.
     *
     * @param n the n
     */
    public void setDimn(int n) {
        dimn = n;
    }

    /**
     * Sets dimm.
     *
     * @param m the m
     */
    public void setDimm(int m) {
        dimm = m;
    }
}

