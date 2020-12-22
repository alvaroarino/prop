package domain.ranking;

public class Stat {
    int posicion;
    String perfil;
    int puntuacio;

    public Stat() {
        posicion = 0;
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
    public void setPosicion(int pos) {posicion = pos; }
}
