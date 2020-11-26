package domain.ranking;

import java.util.*;

public class Ranking {
    private static Ranking single_instance = null;

    public Map<UUID, Stat> puntuacioPerfils;

    public static Ranking Ranking() {
        if(single_instance == null) {
            single_instance = new Ranking();
        }
        return single_instance;
    }

    public void inicialitzarValors() {
        puntuacioPerfils = new TreeMap<UUID, Stat>();
        //com llegir?
    }

    public void afegirIndex(UUID nPerfil, Double puntuacio) {
        if(puntuacioPerfils.containsKey(nPerfil)) {
            Double aux = puntuacioPerfils.get(nPerfil).getPuntuacio();
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
        List<Stat> perfilPerPuntuació = new ArrayList<>(puntuacioPerfils.values());

        Collections.sort(perfilPerPuntuació, Comparator.comparing(Stat::getPuntuacio));

        for(Stat s : perfilPerPuntuació) {
            System.out.println(s.getPerfil() + "\t" + s.getPuntuacio());
        }

        /*Iterator<Map.Entry<UUID, Double>> itr = puntuacioPerfils.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<UUID, Double> stat = itr.next();
            System.out.println("Perfil : " + stat.getKey() + " -> Temps = " + stat.getValue());
        }*/
    }

}
