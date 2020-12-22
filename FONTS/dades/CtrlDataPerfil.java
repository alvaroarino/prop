package dades;

import domain.aventura.Aventura;
import domain.partida.CjtPartida;
import domain.usuari.Perfil;

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
 * The type Ctrl data perfil.
 */
public class CtrlDataPerfil {
    private static CtrlDataPerfil singletonObject;

    /**
     * The constant ENCODING.
     */
    final static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDataPerfil getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataPerfil() {
            };
        return singletonObject;
    }

    /**
     * Gets perfil.
     *
     * @param filename the filename
     * @return the perfil
     * @throws IOException the io exception
     */
    public Perfil getPerfil(String filename) throws IOException {
        Perfil p = new Perfil();

        String fileRoute = "data-files" + File.separator + "Perfil"+filename+".csv";

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        String[] linearBoard = content.split("[:\\n]");
        System.out.println(Arrays.toString(linearBoard));

        String nom = linearBoard[0];

        CtrlDataAventura cda = CtrlDataAventura.getInstance();
        Aventura av = cda.cargarAventura(nom);

        CtrlDataPartida cdp = CtrlDataPartida.getInstance();
        CjtPartida cjt = cdp.getCjtPartida(nom);

        p.setAventura(av);
        p.setCjt(cjt);
        p.setNom(nom);

        return p;

    }

    /**
     * Guardar perfil.
     *
     * @param p   the p
     * @param nom the nom
     * @throws IOException the io exception
     */
    public void guardarPerfil (Perfil p, String nom) throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "Perfil"+nom+".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));

        bw.write(nom+"\n");

        CtrlDataPartida cdp = CtrlDataPartida.getInstance();
        cdp.guardarCjtPartida(p.getCjt(), nom);

    }
}
