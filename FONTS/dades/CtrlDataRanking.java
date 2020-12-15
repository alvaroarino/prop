package dades;

import domain.ranking.Stat;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class CtrlDataRanking {
    private static CtrlDataRanking singletonObject;

    public static CtrlDataRanking getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataRanking() {
            };
        return singletonObject;
    }

    private CtrlDataRanking() {}

    public Map<String, Stat> obtenirRanking() throws IOException {
        String separador = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "ranking.csv");
        FileReader ff = new FileReader(problema);
        BufferedReader br = new BufferedReader(ff);
        String linea;
        Map<String, Stat> ranking = new TreeMap();
        String user,perfil;
        int puntuacion;
        while ((linea = br.readLine()) != null) {
            String[] atr = linea.split(";");
            user = atr[0];
            perfil = atr[1];
            puntuacion = Integer.parseInt(atr[2]);
            Stat estadistica = new Stat(perfil,puntuacion);
            ranking.put(user,estadistica);
        }
        br.close();
        return ranking;
    }

    public void guardarRanking(Map<String, Stat> rank) throws IOException{
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "ranking.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));
        for (Map.Entry<String, Stat> stat : rank.entrySet()) {
            String user = stat.getKey();
            String perfil = stat.getValue().getPerfil();
            int punt = stat.getValue().getPuntuacio();
            String p = String.valueOf(punt);
            bw.write(user + ";" + perfil + ";" + p + "\n");
        }
        bw.close();
    }

    public void creaFitxerRanking() throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "ranking.csv");
        problema.createNewFile();
    }

}
