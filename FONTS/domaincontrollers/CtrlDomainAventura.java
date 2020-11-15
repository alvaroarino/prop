package domaincontrollers;

import domain.Kakuro;

import java.util.ArrayList;

public class Aventura {
    private ArrayList<Kakuro> CjtKakuros;
    private time Temps;

    public Aventura (int n) {

    }
    public Aventura () {
        int n = Math.floor(Math.random()*11+1);
    }

    public time getTemps() {
        return Temps;
    }
    public int KakurosTotals() {
        return CjtKakuros.size();
    }
}