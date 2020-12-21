package domain.ranking;

import java.util.*;

public class Ranking {
    private static Ranking single_instance;

    public Map<String, Stat> puntuacioPerfils;

    public static Ranking getInstance() {
        if(single_instance == null) {
            single_instance = new Ranking();
        }
        return single_instance;
    }

    private Ranking(){}

    public void inicialitzarValors() {
        puntuacioPerfils = new TreeMap();
    }

    public void setRanking(Map<String, Stat> rank){puntuacioPerfils = rank;}

    public void afegirIndex(String nPerfil, int puntuacio) {
        if(puntuacioPerfils.containsKey(nPerfil)) {
            int aux = puntuacioPerfils.get(nPerfil).getPuntuacio();
            if(aux < puntuacio) {
                Stat s = new Stat(nPerfil, puntuacio);
                puntuacioPerfils.replace(nPerfil, s);
            }
        }
        else {
            Stat s = new Stat(nPerfil, puntuacio);
            puntuacioPerfils.put(nPerfil, s);
        }
    }

    public List<Stat> obtenirRankingOrdenat() {
        List<Stat> perfilPerPuntuacio = new ArrayList<>(puntuacioPerfils.values());

        perfilPerPuntuacio.sort(Comparator.comparing(Stat::getPuntuacio));

        return perfilPerPuntuacio;
    }

}
