package domaincontrollers;

import domain.Kakuro;

import java.util.ArrayList;
import java.util.Random;

public class Aventura {
    private ArrayList<Kakuro> CjtKakuros;
    private time Temps;

    public Aventura (int n) {

    }
    public Aventura () {
        Random aleat = new Random();
        int n = aleat.nextInt(9)+1;
    }

    public time getTemps() {
        return Temps;
    }
    public int KakurosTotals() {
        return CjtKakuros.size();
    }
}