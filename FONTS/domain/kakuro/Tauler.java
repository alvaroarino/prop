package domain.kakuro;

import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;

import javax.print.CancelablePrintJob;
import java.util.*;

public class Tauler {

    private Cella[][] CjtCelles; // Conjunt de cel·les
    private /*final*/ int dimn, dimm;
    int solucionsTrobades;
    private Cella[][] SolucionKakuro;
    int cellesNegres;

    public Tauler(){
        dimn = 0;
        dimm = 0;
        solucionsTrobades = 0;
    }

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

    }

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

    public boolean posible (int i, int j){

        if((CjtCelles[i-1][j].color() == ColorCella.Blanca) && (i > 1) &&(CjtCelles[i-2][j].color() == ColorCella.Negra)) return false;
        if((CjtCelles[i][j-1].color() == ColorCella.Blanca) && (j > 1) &&(CjtCelles[i][j-2].color() == ColorCella.Negra)) return false;
        if(i < (dimn - 1) && CjtCelles[i+1][j].color() ==ColorCella.Blanca  ) {
            if(i+2 > dimn - 1) return false;
            if(i < (dimn - 2) && CjtCelles[i+2][j].color() ==ColorCella.Negra) return  false;
        }
        if(j < (dimm - 1) && CjtCelles[i][j+1].color() ==ColorCella.Blanca  ) {
            if(j+2 > dimm - 1) return false;
            if(j < (dimm - 2) && CjtCelles[i][j+2].color() ==ColorCella.Negra) return  false;
        }
        return true;
    }

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

    public void rellenar_celdas_blancas() {
        rellenar_blancas_back(this.CjtCelles, 0, 0);
    }

    private static boolean rellenar_blancas_back(Cella[][] board, int fila, int col) {
        final int nFila = board.length;
        final int nCol = board[0].length;

        if (fila == nFila) return true;

        else if (col == nCol) {
            return rellenar_blancas_back(board,fila+1, 0);
        }

        else if (board[fila][col].color() == ColorCella.Negra) {
            return rellenar_blancas_back(board, fila, col+1);
        }

        for (int valor=1; valor <= 9; ++valor) {
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
                    if(restants == 0) {
                        CjtCelles[i][j].intro_valor_blanca(-1);
                    }
                    else {
                        if ((restants > 1) && (compt != m)) {
                            CjtCelles[i][j].intro_valor_blanca(-1);
                        } else if ((restants == 1) && (compt != n)) {
                            CjtCelles[i][j].intro_valor_blanca(-1);
                        }
                        else{
                            CjtCelles[i][j].fixCellaBlanca();
                        }
                    }
                    if(compt == m) compt = 0;
                    ++compt;
                }
            }
        }
    }

    public void solve() {

        solBack2(this.CjtCelles, 0, 0);
        if(solucionsTrobades > 1) {
            System.out.println("El kakuro té més d'una solució \n");
            printSol();
        }
        else if(solucionsTrobades == 1) {
            System.out.println("El kakuro té una unica solució \n");
            printSol();
        }
        else {
            System.out.println("No s'ha trobat solució \n");
        }
    }

    private void solBack2(Cella[][] board, int fila, int col) {
        final int nFila = board.length;
        final int nCol = board[0].length;

        if (fila == nFila){
            solucionsTrobades = solucionsTrobades +1;
            deepCopy(board);
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
                board[fila][col].intro_valor_blanca(valor);
                solBack2(board, fila, col+1);
                board[fila][col].intro_valor_blanca(0);
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
        int suma = valor;
        int sumaNegras = 0;

        for (int i = col+1; i < dimm; ++i) {
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
        int suma = valor;
        int sumaNegras = 0;

        for (int i = fila+1; i < dimn; ++i) {
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

    public void validar() {
        for(int i = 0; i < dimn; ++i) {
            for(int j = 0; j < dimm; ++j) {
                if(CjtCelles[i][j].color() == ColorCella.Negra) {
                    if(CjtCelles[i][j].getValorEsquerre() != -1) {
                        int x = comprovarColumna(i,j,CjtCelles[i][j].getValorEsquerre());
                        if(x == -1) {
                            break;
                        }
                    }
                    else if(CjtCelles[i][j].getValorDret() != -1) {
                        int x = comprovarFila(i,j,CjtCelles[i][j].getValorDret());
                        if(x == -1) {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Enhorabona, has solucionat el kakuro!");
    }

    private int comprovarColumna(int i, int j, int valor) {
        int sumaParcial = 0;
        boolean[] presents = new boolean[9];
        for(int l = 0; l < 9; ++l) {
            presents[l] = false;
        }
        for(int x = i+1; x < dimn; ++x) {
            if(CjtCelles[x][j].color() == ColorCella.Blanca) {
                if(CjtCelles[x][j].getValor_blanca() == -1 || CjtCelles[x][j].getValor_blanca() == 0) {
                    System.out.println("Valor no valid");
                    return -1;
                }
                else if(presents[CjtCelles[x][j].getValor_blanca() - 1]){
                    System.out.println("Valor repetit");
                    return -1;
                }
                else if(sumaParcial >= valor) {
                    System.out.println("Error");
                    return -1;
                }
                else{
                    sumaParcial += CjtCelles[x][j].getValor_blanca();
                    presents[CjtCelles[x][j].getValor_blanca()-1] = true;
                }
            }
            else{
                if(sumaParcial != valor) {
                    System.out.println("Suma no correcte");
                    return -1;
                }
            }
        }
        if(sumaParcial != valor) {
            System.out.println("Suma no correcte");
            return -1;
        }
        return 0; //correcto
    }

    private int comprovarFila(int i, int j, int valor) {
        int sumaParcial = 0;
        boolean[] presents = new boolean[9];
        for(int l = 0; l < 9; ++l) {
            presents[l] = false;
        }
        for(int x = j+1; x < dimm; ++x) {
            if(CjtCelles[i][x].color() == ColorCella.Blanca) {
                if(CjtCelles[i][x].getValor_blanca() == -1 || CjtCelles[i][x].getValor_blanca() == 0) {
                    System.out.println("Valor no valid");
                    return -1;
                }
                else if(presents[CjtCelles[i][x].getValor_blanca() - 1]){
                    System.out.println("Valor repetit");
                    return -1;
                }
                else if(sumaParcial >= valor) {
                    System.out.println("Error");
                    return -1;
                }
                else{
                    sumaParcial += CjtCelles[i][x].getValor_blanca();
                    presents[CjtCelles[i][x].getValor_blanca()-1] = true;
                }
            }
            else{
                if(sumaParcial != valor) {
                    System.out.println("Suma no correcte");
                    return -1;
                }
            }
        }
        if(sumaParcial != valor) {
            System.out.println("Suma no correcte");
            return -1;
        }
        return 0; //correcto
    }

    public void setCjtCelles(Cella[][] c) {
        CjtCelles = c;
    }
    public void setDimn(int n) {
        dimn = n;
    }
    public void setDimm(int m) {
        dimm = m;
    }
}

