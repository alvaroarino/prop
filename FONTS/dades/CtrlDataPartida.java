package dades;

import domain.partida.Partida;
import dades.CtrlDataKakuro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CtrlDataPartida {
    private static CtrlDataPartida singletonObject;

    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static CtrlDataPartida getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataPartida() {
            };
        return singletonObject;
    }

    private CtrlDataPartida() {}

    public void guardarPartida(Partida p, String nom) throws IOException {
        String separador_SO = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "partida"+nom+".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));
        bw.write("NOM:"+nom+"\n");
        if (p.getEstat() == 1) {
            bw.write("ESTAT: Corrent\n");
        }
        else {
            bw.write("ESTAT: Pausat\n");
        }
        bw.write("TEMPS:"+p.getTime()+"\n");

        CtrlDataKakuro cdk;
        cdk = getInstance();
        cdk.guardarKakuro((p.getKakuro()).getId(), p.getKakuro());
    }
}
