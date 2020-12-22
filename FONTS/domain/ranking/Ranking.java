package domain.ranking;

import java.util.*;

/**
 * The type Ranking.
 */
public class Ranking {
    private static Ranking single_instance;

    /**
     * The Puntuacio perfils.
     */
    public Map<String, Stat> puntuacioPerfils;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Ranking getInstance() {
        if(single_instance == null) {
            single_instance = new Ranking();
        }
        return single_instance;
    }

    private Ranking(){puntuacioPerfils = new TreeMap();}

    /**
     * Set ranking.
     *
     * @param rank the rank
     */
    public void setRanking(Map<String, Stat> rank){puntuacioPerfils = rank;}

    public Map<String, Stat> getRanking() {return puntuacioPerfils;}
    /**
     * Afegir index.
     *
     * @param nPerfil   the n perfil
     * @param puntuacio the puntuacio
     */
    public void afegirIndex(String nPerfil, int puntuacio) {
        if(puntuacioPerfils.containsKey(nPerfil)) {
            int aux = puntuacioPerfils.get(nPerfil).getPuntuacio();
            aux += puntuacio;
            Stat s = new Stat(nPerfil, aux);
            puntuacioPerfils.replace(nPerfil, s);
        }
        else {
            Stat s = new Stat(nPerfil, puntuacio);
            puntuacioPerfils.put(nPerfil, s);
        }
    }

    /**
     * Obtenir ranking ordenat list.
     *
     * @return the list
     */
    public List<Stat> obtenirRankingOrdenat() {
        List<Stat> perfilPerPuntuacio = new ArrayList<>(puntuacioPerfils.values());

        perfilPerPuntuacio.sort(Comparator.comparing(Stat::getPuntuacio));

        return perfilPerPuntuacio;
    }

}
