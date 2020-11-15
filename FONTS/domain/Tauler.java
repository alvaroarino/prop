package domain;
import java.util.ArrayList;

public class Tauler {

    private ArrayList<Cella> CjtCelles ; // Conjunt de cel·les
    private int dimn, dimm;


    public Tauler(int n, int m) {

        dimn = n;
        dimm = m;

    }

    public int getDimm() {
        return dimm;
    }

    public int getDimn() {
        return dimn;
    }


}
