package dades;

import domain.aventura.Aventura;
import domain.kakuro.Kakuro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Ctrl data aventura.
 */
public class CtrlDataAventura {
    private static CtrlDataAventura singletonObject;
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
    public static CtrlDataAventura getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataAventura() {
            };
        return singletonObject;
    }

    private CtrlDataAventura() {}

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
     * Cargar aventura aventura.
     *
     * @param nom the nom
     * @return the aventura
     * @throws IOException the io exception
     */
    public Aventura cargarAventura (String nom) throws IOException {
        Aventura av = new Aventura();

        String fileRoute = "data-files" + File.separator + "Aventura" + nom + ".csv";

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        String[] linearBoard = content.split("[:\\n]");
        System.out.println(Arrays.toString(linearBoard));

        int nKakuros = atoi(linearBoard[2]);

        ArrayList<Kakuro> llista = new ArrayList<Kakuro>();

        for (int i = 0; i < nKakuros; ++i) {
            String nomKakuros = linearBoard[i+3];
            Kakuro kak = cdk.getData("kakuro"+nomKakuros+".csv");
            kak.setKakuro(kak);
            llista.add(kak);
        }

        av.SetAventura(llista);

        av.SetTemps(atoiTemps(linearBoard[1]));

        return av;
    }

    /**
     * Guardar aventura.
     *
     * @param av  the av
     * @param nom the nom
     * @throws IOException the io exception
     */
    public void guardarAventura (Aventura av, String nom) throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "Aventura"+nom+".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));

        bw.write("TEMPS:"+av.getTemps()+"\n");
        ArrayList<Kakuro> llista = av.getAventura();

        bw.write(llista.size()+"\n");

        for (Kakuro kakuro : llista) {
            bw.write(kakuro.getId() + "\n");
            //cdk.guardarKakuro(kakuro.getId(), kakuro);
        }

    }



}