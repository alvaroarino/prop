package dades;

import domain.kakuro.Kakuro;
import domain.partida.CjtPartida;
import domain.partida.Partida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * The type Ctrl data partida.
 */
public class CtrlDataPartida {
    private static CtrlDataPartida singletonObject;
    /**
     * The Cdk.
     */
    CtrlDataKakuro cdk = CtrlDataKakuro.getInstance();

    /**
     * The constant ENCODING.
     */
    final static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDataPartida getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataPartida() {
            };
        return singletonObject;
    }

    private CtrlDataPartida() {}

    private int atoi (String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        str = str.trim();

        int i = 0;

        double result = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result*10+(str.charAt(i) - '0');
            i++;
        }

        return (int) result;

    }

    private double atoiTemps (String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        str = str.trim();

        int i = 0;

        double result = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result*10+(str.charAt(i) - '0');
            i++;
        }

        return result;

    }

    /**
     * Gets cjt partida.
     *
     * @param filename the filename
     * @return the cjt partida
     * @throws IOException the io exception
     */
    public CjtPartida getCjtPartida(String filename) throws IOException {
        CjtPartida part = new CjtPartida();

        String fileRoute = "data-files" + File.separator + "CjtPartida"+filename+".csv";

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        String[] linearBoard = content.split("[:\\n]");
        System.out.println(Arrays.toString(linearBoard));

        int nPart;

        nPart = atoi(linearBoard[1]);
        for (int i = 0; i < nPart; ++i) {
            String nomPart = linearBoard[i+2];
            Partida p = getPartida(nomPart);
            part.SetPartidas(p);
        }

        return part;

    }

    /**
     * Guardar cjt partida.
     *
     * @param p   the p
     * @param nom the nom
     * @throws IOException the io exception
     */
    public void guardarCjtPartida(CjtPartida p, String nom) throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "Cjtpartida"+nom+".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));
        bw.write("NumeroPartides:"+p.getNumPartides()+"\n");
        for (int i = 0; i < p.getNumPartides(); ++i) {
            Partida part = p.getPartida(i);
            guardarPartida(part, part.getNom());
            bw.write(part.getNom());
        }

    }

    /**
     * Gets partida.
     *
     * @param filename the filename
     * @return the partida
     * @throws IOException the io exception
     */
    public Partida getPartida(String filename) throws IOException {
        Partida part = new Partida();

        String fileRoute = "data-files" + File.separator + "partida"+filename+".csv";

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        String[] linearBoard = content.split("[:\\n]");
        System.out.println(Arrays.toString(linearBoard));

        double time;
        int state;
        String name, id;

        name = linearBoard[1];
        if (linearBoard[3].equals("Corrent")) {
            state = 0;
        }
        else {
            state = 1;
        }

        time = atoiTemps(linearBoard[5]);
        id = linearBoard[7];

        Kakuro kak = cdk.getData("kakuro"+id+".csv");

        part.SetName(name);
        part.SetTinicial(time);
        part.SetEstat(state);
        part.SetKakuroPartida(kak);

        return part;

    }

    /**
     * Guardar partida.
     *
     * @param p   the p
     * @param nom the nom
     * @throws IOException the io exception
     */
    public void guardarPartida(Partida p, String nom) throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "partida"+nom+".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));
        bw.write("NOM:"+nom+"\n");
        if (p.getEstat() == 1) {
            bw.write("ESTAT:Corrent\n");
        }
        else {
            bw.write("ESTAT:Pausat\n");
        }
        bw.write("TEMPS:"+p.getTime()+"\n");

        bw.write("IDKakuro:"+(p.getKakuro()).getId()+"\n");

        cdk.guardarKakuro((p.getKakuro()).getId(), p.getKakuro(), p.getTime());
    }
}
