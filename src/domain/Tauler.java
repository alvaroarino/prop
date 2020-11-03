package domain;
import java.util.ArrayList;
import java.util.Set;

public class Tauler {

    private Cella CjtCelles [][] ; // Conjunt de cel·les
    private int dimn, dimm;

    public Tauler(int n, int m) {

        dimn = n;
        dimm = m;

        Cella CjtCelles [][] = new Cella[n][m];

        for (int i = 0; i < n ; ++i) {

            for(int j = 0; j < m ; ++j) CjtCelles[i][j].intro_valor(0);
        }
    }

    public int getDimm() {
        return dimm;
    }

    public int getDimn() {
        return dimn;
    }

    public void  pintar_negras(int cantidad) {

        //DE FORMA ALEATORIA -> MITAD aleatoria y espejo
    }

    public void pintar_negra(int x, int y, int  sum_d, int sum_i){

    }
    public void pintar_blanca(int x, int y){}

    public void buscar_problemas() {

        //ESTA MÉTODO HACE UNA BÚSQUEDA PARA MIRAR SI HAY +9 CASILLAS JUNTAS y busca otros problemas que no cumplan las reglas KAKURO
    }

    public void rellenar_blancas() {

    }

    public void hacer_sumas(){

    }

    public void borrar_blancas(){

    }
}
