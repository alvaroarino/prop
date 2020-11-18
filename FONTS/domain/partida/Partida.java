package domain.partida;

import java.sql.Time;

public class Partida {

    private int Estat;
    private Time Temps;

    private Partida() {

    }

    public int getEstat() {
        return Estat;
    }

    public void PausaPart() {
        Estat = 1;
    }

    public void ContiunaPart() {
        Estat = 0;
    }

    public Time getTemps() {
        return Temps;
    }
}
