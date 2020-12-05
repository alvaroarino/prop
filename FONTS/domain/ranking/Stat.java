package domain.ranking;

import java.util.UUID;

public class Stat {
    String perfil;
    int puntuacio;

    public Stat() {
        perfil = "";
        puntuacio = 0;
    }

    public Stat(String  nom, int punt) {
        perfil = nom;
        puntuacio = punt;
    }

    public int getPuntuacio() {return puntuacio;}
    public String getPerfil() {return perfil;}
    public void setPuntuacio(int p) {
        puntuacio = p;
    }
}
