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



    public void pintar_negra(int x, int y, int  sum_d, int sum_i){

    }
    public void pintar_blanca(int x, int y){}


}
