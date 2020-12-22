package domain.ranking;

/**
 * The type Stat.
 */
public class Stat {
    /**
     * The Posicion.
     */
    int posicion;
    /**
     * The Perfil.
     */
    String perfil;
    /**
     * The Puntuacio.
     */
    int puntuacio;

    /**
     * Instantiates a new Stat.
     */
    public Stat() {
        posicion = 0;
        perfil = "";
        puntuacio = 0;
    }

    /**
     * Instantiates a new Stat.
     *
     * @param nom  the nom
     * @param punt the punt
     */
    public Stat(String  nom, int punt) {
        perfil = nom;
        puntuacio = punt;
    }

    /**
     * Instantiates a new Stat.
     *
     * @param pos  the pos
     * @param nom  the nom
     * @param punt the punt
     */
    public Stat(int pos, String  nom, int punt) {
        posicion = pos;
        perfil = nom;
        puntuacio = punt;
    }

    /**
     * Gets puntuacio.
     *
     * @return the puntuacio
     */
    public int getPuntuacio() {return puntuacio;}

    /**
     * Gets perfil.
     *
     * @return the perfil
     */
    public String getPerfil() {return perfil;}

    /**
     * Gets posicion.
     *
     * @return the posicion
     */
    public int getPosicion() {return posicion;}

    /**
     * Sets puntuacio.
     *
     * @param p the p
     */
    public void setPuntuacio(int p) {
        puntuacio = p;
    }

    /**
     * Sets posicion.
     *
     * @param pos the pos
     */
    public void setPosicion(int pos) {posicion = pos; }
}
