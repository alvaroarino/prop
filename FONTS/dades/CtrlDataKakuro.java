package dades;

import domain.cella.*;
import domain.kakuro.Kakuro;
import domain.kakuro.Tauler;

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

public class CtrlDataKakuro {
    private static CtrlDataKakuro singletonObject;

    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static CtrlDataKakuro getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataKakuro() {
            };
        return singletonObject;
    }

    private CtrlDataKakuro() {}

    public Kakuro getData(String filename) throws IOException {
        Cella[][] board;

        String fileRoute = "data-files" + File.separator + filename;

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        // Separem el contingut en comes y separadors de linea
        String[] linearBoard = content.split("[,\\n]");
        System.out.println(Arrays.toString(linearBoard));

        // A la pos 0 i 1 tenim el tamany del Kakuro
        int tamN = Integer.parseInt(linearBoard[0]);
        int tamM = Integer.parseInt(linearBoard[1]);

        board = new Cella[tamN][tamM];

        int linearPos = 2; // Serveix per mourens per el vector linearBoard que conté tots els valors del txt
        for (int i = 0; i < tamN; ++i) {
            if (linearPos >= linearBoard.length-2) break; // Si em acabat el vector d'entrada cal sortir del for
            for (int j = 0; j < tamM; ++j) {
                if (linearPos >= linearBoard.length-2) break; // Si em acabat el vector d'entrada cal sortir del for
                String actual = linearBoard[linearPos];
                if (actual.contains("?")) {
                    // Si es ? creem una cel.la blanca
                    System.out.println(actual + " Cella Blanca");
                    board[i][j] = new CellaBlanca();
                } else if (actual.contains("*")) {
                    // Si es * creem una cel.la blanca
                    System.out.println(actual + " Cella Negra");
                    board[i][j] = new CellaNegra();
                } else {
                    // En qualsevol altre cas es negra
                    board[i][j] = new CellaNegra();
                    if (actual.contains("C") && actual.contains("F")) {
                        // Si conté C i F cal extreure dos valors
                        System.out.print(actual + " contains both with digits: ");
                        // Separem per la lletra F, que está al mig, i obtenim dos strings en un vector (digits):
                        // - un te el patro CX (digits[0]) i l'altre es nomes el valor de la F (digits[1])
                        // - el valor de la F no cal fe res pero el de la C cal substituir la C per res
                        // finalment fem un parseInt de cada valor (c, f).
                        String[] digits = actual.split("F");
                        String c = digits[0].replaceAll("C", "");
                        String f = digits[1]; //Com que em separat per F abans ja no tenim lletra
                        System.out.println(c + " " + f);

                        board[i][j].setValorColumna(Integer.parseInt(c));
                        board[i][j].setValorFila(Integer.parseInt(f));
                    } else {
                        System.out.print(actual + " contains one with digits: ");
                        // Si conté només C o F cal extreure un valor
                        if (actual.contains("C")) {
                            // Substituim C per res per tenir només el valor i el demanem amb parseInt;
                            String digits = actual.replaceAll("C", "");
                            System.out.println(digits);
                            board[i][j].setValorColumna(Integer.parseInt(digits));
                        }
                        if (actual.contains("F")) {
                            // Substituim F per res per tenir només el valor i el demanem amb parseInt;
                            String digits = actual.replaceAll("F", "");
                            System.out.println(digits);
                            board[i][j].setValorFila(Integer.parseInt(digits));
                        }
                    }

                }
                System.out.println(board[i][j].color() == ColorCella.Blanca ? ("Valor blanca: " + board[i][j].getValor_blanca()) : ("Valor negra: C:" + board[i][j].getValorEsquerre() + " F:" + board[i][j].getValorDret()));
                ++linearPos;
            }
        }
        int max = linearBoard.length;
        String id = linearBoard[max-1];
        Tauler t = new Tauler(tamN, tamM);
        Kakuro kak = new Kakuro(tamN, tamM);
        t.setCjtCelles(board);
        kak.setTauler(t);
        kak.setId(id);
        return kak;
    }

    public void guardarKakuro(String id, Kakuro k) throws IOException {
        String separador = System.getProperty("file.separator");
        String path_fitxer_dades = (new File("data-files")).getAbsolutePath();
        File problema = new File(path_fitxer_dades, "kakuro"+id+".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(problema,true));
        Tauler t = k.getBoard();
        String n = String.valueOf(t.getDimn());
        String m = String.valueOf(t.getDimm());
        bw.write(n+","+m+"\n");
        int valorCella;
        String valor;
        for(int i = 0; i < t.getDimn(); ++i) {
            for(int j = 0; j < t.getDimm(); ++j) {
                if(t.getCella(i,j).color() == ColorCella.Blanca){
                    if(t.getCella(i,j).getValor_blanca() == -1)
                        bw.write("?");
                    else{
                        valorCella = t.getCella(i,j).getValor_blanca();
                        valor = String.valueOf(valorCella);
                        bw.write(valor);
                    }
                }
                else { //cella negra
                    if((t.getCella(i,j).getValorDret() == -1) && (t.getCella(i,j).getValorEsquerre() == -1))
                        bw.write("*");
                    else{
                        if(t.getCella(i,j).getValorEsquerre() != -1) {
                            valorCella = t.getCella(i,j).getValorEsquerre();
                            valor = String.valueOf(valorCella);
                            bw.write("C"+valor);
                        }
                        if(t.getCella(i,j).getValorDret() != -1) {
                            valorCella = t.getCella(i,j).getValorDret();
                            valor = String.valueOf(valorCella);
                            bw.write("F"+valor);
                        }
                    }
                }
                if(j < (t.getDimm()-1)) {
                    bw.write(",");
                }
            }
            bw.write("\n");
        }
        bw.write(id);
    }
}

