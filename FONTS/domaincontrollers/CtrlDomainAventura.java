package domaincontrollers;

import domain.kakuro.Kakuro;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class CtrlDomainAventura {
    private ArrayList<Kakuro> CjtKakuros;
    private Time Temps;

    public CtrlDomainAventura (int n) {

    }

    public CtrlDomainAventura () {
        Random aleat = new Random();
        int n = aleat.nextInt(9)+1;
    }

    public Time getTemps() {
        return Temps;
    }

    public int KakurosTotals() {
        return CjtKakuros.size();
    }
}