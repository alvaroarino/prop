package dades;

import domain.ranking.Stat;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Ctrl data ranking.
 */
public class CtrlDataRanking {
    private static CtrlDataRanking singletonObject;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDataRanking getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataRanking() {
            };
        return singletonObject;
    }

    private CtrlDataRanking() {}

    /**
     * Obtenir ranking map.
     *
     * @return the map
     * @throws IOException the io exception
     */
    public Map<String, Stat> obtenirRanking() throws IOException {
        String separador = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("Resources")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "ranking.csv");
        FileReader ff = new FileReader(problema);
        BufferedReader br = new BufferedReader(ff);
        String linea;
        Map<String, Stat> ranking = new TreeMap();
        String perfil;
        int pos,puntuacion;
        while ((linea = br.readLine()) != null) {
            String[] atr = linea.split(";");
            pos = Integer.parseInt(atr[0]);
            perfil = atr[1];
            puntuacion = Integer.parseInt(atr[2]);
            Stat estadistica = new Stat(pos,perfil,puntuacion);
            ranking.put(perfil,estadistica);
        }
        br.close();
        return ranking;
    }

    /**
     * Guardar ranking.
     *
     * @param rank the rank
     * @throws IOException the io exception
     */
    public void guardarRanking(Map<String, Stat> rank) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("ranking.csv"));
        for (Map.Entry<String, Stat> stat : rank.entrySet()) {
            int pos = stat.getValue().getPosicion();
            String po = String.valueOf(pos);
            String perfil = stat.getValue().getPerfil();
            int punt = stat.getValue().getPuntuacio();
            String p = String.valueOf(punt);
            bw.write(po + ";" + perfil + ";" + p + "\n");
        }
        bw.close();
    }

    /**
     * Crea fitxer ranking.
     *
     * @throws IOException the io exception
     */
    public void creaFitxerRanking() throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("Resources")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "ranking.csv");
        problema.createNewFile();
    }

}
