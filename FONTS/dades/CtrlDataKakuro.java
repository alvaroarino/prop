package dades;

import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import domain.kakuro.Kakuro;
import domain.kakuro.Tauler;
import domain.partida.Partida;
import domaincontrollers.CtrlDomain;

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
 * The type Ctrl data kakuro.
 */
public class CtrlDataKakuro {
    private static CtrlDataKakuro singletonObject;

    /**
     * The constant ENCODING.
     */
    final static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDataKakuro getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDataKakuro() {
            };
        return singletonObject;
    }

    private CtrlDataKakuro() {}

    /**
     * Gets data.
     *
     * @param fileRoute the filename
     * @return the data
     * @throws IOException the io exception
     */
    public Kakuro getData(String fileRoute) throws IOException {
        Cella[][] board;


        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);

        // Separem el contingut en comes y separadors de linea
        String[] linearBoard = content.split("[,\\n]");
        //System.out.println(Arrays.toString(linearBoard));

        // A la pos 0 i 1 tenim el tamany del Kakuro
        int tamN = (int) Double.parseDouble((linearBoard[0]));
        int tamM = (int) Double.parseDouble((linearBoard[1]));


        board = new Cella[tamN][tamM];

        int linearPos = 2; // Serveix per mourens per el vector linearBoard que conté tots els valors del txt
        for (int i = 0; i < tamN; ++i) {
            if (linearPos >= linearBoard.length) break; // Si em acabat el vector d'entrada cal sortir del for
            for (int j = 0; j < tamM; ++j) {
                if (linearPos >= linearBoard.length) break; // Si em acabat el vector d'entrada cal sortir del for
                String actual = linearBoard[linearPos];
                if (actual.contains("?")) {
                    // Si es ? creem una cel.la blanca
                    board[i][j] = new CellaBlanca();
                } else if (actual.contains("*")) {
                    // Si es * creem una cel.la blanca
                    board[i][j] = new CellaNegra();
                } else {
                    // En qualsevol altre cas es negra
                    board[i][j] = new CellaNegra();
                    if (actual.contains("C") && actual.contains("F")) {
                        // Si conté C i F cal extreure dos valors
                        // Separem per la lletra F, que está al mig, i obtenim dos strings en un vector (digits):
                        // - un te el patro CX (digits[0]) i l'altre es nomes el valor de la F (digits[1])
                        // - el valor de la F no cal fe res pero el de la C cal substituir la C per res
                        // finalment fem un parseInt de cada valor (c, f).
                        String[] digits = actual.split("F");
                        String c = digits[0].replaceAll("C", "");
                        String f = digits[1]; //Com que em separat per F abans ja no tenim lletra

                        board[i][j].setValorColumna((int) Double.parseDouble(c));
                        board[i][j].setValorFila((int) Double.parseDouble(f));
                    }
                    else if (actual.contains("C")) {
                            // Substituim C per res per tenir només el valor i el demanem amb parseInt;
                            String digits = actual.replaceAll("C", "");
                            board[i][j].setValorColumna((int) Double.parseDouble(digits));
                    }
                    else if (actual.contains("F")) {
                            // Substituim F per res per tenir només el valor i el demanem amb parseInt;
                            String digits = actual.replaceAll("F", "");
                            board[i][j].setValorFila((int) Double.parseDouble(digits));
                    }
                    else {
                        board[i][j] = new CellaBlanca();
                        board[i][j].intro_valor_blanca((int) Double.parseDouble(actual));
                    }


                }
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

    /**
     * Guardar kakuro.
     *
     * @param id   the id
     * @param k    the k
     * @param time the time
     * @throws IOException the io exception
     */
    public void guardarKakuro(String id, Kakuro k, double time) throws IOException {
        try{
            File myObj = new File("filename.txt");
            if(myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("filename.txt");
                int n = k.getBoard().getDimn();
                String s = String.valueOf(n);
                int m = k.getBoard().getDimm();
                String d = String.valueOf(m);
                myWriter.write(s+","+d+"\n");
                for(int i = 0; i < n; ++i) {
                    for(int j = 0; j < m; ++j) {
                        if(k.getBoard().getCella(i,j).color() == ColorCella.Negra){
                            if(k.getBoard().getCella(i,j).getValorEsquerre() > 0 && k.getBoard().getCella(i,j).getValorDret() > 0) {
                                s = String.valueOf(k.getBoard().getCella(i,j).getValorEsquerre());
                                d = String.valueOf(k.getBoard().getCella(i,j).getValorDret());
                                myWriter.write("C"+s+"F"+d);
                            }
                            else if(k.getBoard().getCella(i,j).getValorEsquerre() > 0) {
                                s = String.valueOf(k.getBoard().getCella(i,j).getValorEsquerre());
                                myWriter.write("C"+s);
                            }
                            else if(k.getBoard().getCella(i,j).getValorDret() > 0) {
                                d = String.valueOf(k.getBoard().getCella(i,j).getValorDret());
                                myWriter.write("F"+d);
                            }
                            else{
                                myWriter.write("*");
                            }
                        }
                        else if(k.getBoard().getCella(i,j).color() == ColorCella.Blanca){
                            if(k.getBoard().getCella(i,j).getValor_blanca() > 0) {
                                s = String.valueOf(k.getBoard().getCella(i,j).getValor_blanca());
                                myWriter.write(s);
                            }
                            else{
                                myWriter.write("?");
                            }
                        }
                        if(j != (m - 1))
                            myWriter.write(",");
                    }
                    myWriter.write("\n");
                }

                String f = String.valueOf(time);
                myWriter.write(f);
                myWriter.close();

            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error.");
            e.printStackTrace();
        }
    }
}

