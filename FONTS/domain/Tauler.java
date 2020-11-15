package domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The type Tauler.
 */
public class Tauler {

    private Cella CjtCelles [][] ; // Conjunt de cel·les
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

        Cella CjtCelles [][] = new Cella[n][m];
        // PINTAR FILA 1 y COLUMNA 1

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
     * Comproba si una casella és valida per assignar-li una negra..
     *
     * @param i the
     * @param j the j
     * @return the boolean
     */
    public boolean posValida(int i, int j) {

        //Si devuelve 0, es blanca
       if( CjtCelles[i-1][j].color() == 0) {
           if(CjtCelles[i-2][j].color() == 1) return false;
       }

        if( CjtCelles[i][j-1].color() == 0) {
            if(CjtCelles[i][j-2].color() == 1) return false;
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
        int l = dimm -j;
        CjtCelles[k][l] = new CellaNegra();

        return cantidad;
    }

    /**
     * Pintar negras.
     *
     * @param cantidad the cantidad
     */
    public void  pintar_negras(int cantidad) {

        int contador_blancas =0;
        Random aleat = new Random();

        for(int i = 1; i < dimn; ++i) {
            for (int j = 1; j < dimm; ++j) {
                int n = aleat.nextInt(dimm);

                if (posValida(i, j)) {
                    if (n == j) cantidad = pintar_celda(i,j,cantidad);
                    else ++contador_blancas;

                    if (contador_blancas > 9) {
                        cantidad = pintar_celda(i,j,cantidad);
                        contador_blancas = 0;
                    }

                    if ((i >= dimn / 2) && (j >= dimn / 2) && cantidad >= (dimn * dimm)) {
                        cantidad = pintar_celda(i,j,cantidad);
                    }
                }
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
     * @return the boolean
     */
    public boolean presente_fila (int aleat) {}

    /**
     * Presente col boolean.
     *
     * @param aleat the aleat
     * @return the boolean
     */
    public boolean presente_col (int aleat) {}

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
                    while(presente_fila(numAleat )|| presente_col(numAleat)) {
                            numAleat = generar_aleatorios();
                    }
                    CjtCelles[i][j].intro_valor(numAleat);
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
                    int aux = 1;

                    while (CjtCelles[i][j + aux].color() == 0 && j + aux != dimm) {
                        CjtCelles[i][j].acumular_valor_derecha(CjtCelles[i][j + aux].getValor());
                        ++aux;
                    }
                    aux = 1;
                    while (CjtCelles[i + aux][j].color() == 0 && i + aux != dimn) {
                        CjtCelles[i][j].acumular_valor_izquierda(CjtCelles[i + aux][j].getValor());
                        ++aux;
                    }
                }
            }
        }
    }

    /**
     * Borrar blancas.
     */
    public void borrar_blancas() {
    }
}
