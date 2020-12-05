package domain.ranking;

import java.util.*;

public class Ranking {
    private static Ranking single_instance = null;

    public Map<String, Stat> puntuacioPerfils;

    public static Ranking Ranking() {
        if(single_instance == null) {
            single_instance = new Ranking();
        }
        return single_instance;
    }

    public void inicialitzarValors() {
        puntuacioPerfils = new TreeMap<String, Stat>();
        //com llegir?
    }

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

    public void print() {
        List<Stat> perfilPerPuntuacio = new ArrayList<>(puntuacioPerfils.values());

        Collections.sort(perfilPerPuntuacio, Comparator.comparing(Stat::getPuntuacio));

        for(Stat s : perfilPerPuntuacio) {
            System.out.println(s.getPerfil() + "\t" + s.getPuntuacio());
        }

        /*Iterator<Map.Entry<UUID, Double>> itr = puntuacioPerfils.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<UUID, Double> stat = itr.next();
            System.out.println("Perfil : " + stat.getKey() + " -> Temps = " + stat.getValue());
        }*/
    }

}
