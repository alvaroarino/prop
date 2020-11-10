package domain;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Tauler {

    private Cella CjtCelles [][] ; // Conjunt de cel·les
    private int dimn, dimm;

    public Tauler(int n, int m) {

        dimn = n;
        dimm = m;

        Cella CjtCelles [][] = new Cella[n][m];
        // PINTAR FILA 1 y COLUMNA 1

    }

    public int getDimm() {
        return dimm;
    }

    public int getDimn() {
        return dimn;
    }

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

    public void  pintar_negras(int cantidad) {

        int contador_blancas =0;


        Random aleat = new Random();

        for(int i = 1; i < dimn; ++i) {
            for (int j = 1; j < dimm; ++j) {


                int n = aleat.nextInt(dimm);

                if (posValida(i, j)) {

                    if (n == j) {


                        if (cantidad == 0) return;
                        else --cantidad;
                        CjtCelles[i][j] = CellaNegra();
                        if (cantidad == 0) return;
                        else --cantidad;
                        CjtCelles[j][i] = CellaNegra();

                    } else ++contador_blancas;

                    if (contador_blancas > 9) {


                        if (cantidad == 0) return;
                        else --cantidad;
                        CjtCelles[i][j] = CellaNegra();
                        if (cantidad == 0) return;
                        else --cantidad;
                        CjtCelles[j][i] = CellaNegra();

                        contador_blancas = 0;

                    }

                    if ((i >= dimn / 2) && (j >= dimn / 2) && cantidad >= (dimn * dimm)) {

                        if (cantidad == 0) return;
                        else --cantidad;
                        CjtCelles[i][j] = CellaNegra();
                        if (cantidad == 0) return;
                        else --cantidad;
                        CjtCelles[j][i] = CellaNegra();


                    }


                }
            }
        }




    }

   public int generar_aleatorios(){

       Random aleat = new Random();
       int n = aleat.nextInt(9) + 1;

       return n;

   }



    public void rellenar_blancas() {

        Set<Set<Integer>> set_deN = new Set<Set<Integer>>(); // VALOR DEL KAKURO (nxm)
        int numAleat;
        for (int i = 1; i < dimn; ++i) {
            Set<Integer> fila = new Set<Integer>();


            for (int j = 1; j < dimm; ++j) {

            if((CjtCelles[i][j]).color() == 0) {

                numAleat = generar_aleatorios();

                while(!fila.add(numAleat)) {
                        numAleat = generar_aleatorios(); //Falta comprobar que no esté en el set grande y añadirlo.
                    }


            }

            }
        }
    }

    public void hacer_sumas(){

    }

    public void borrar_blancas(){

    }
}
