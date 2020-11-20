package dades;

import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public Cella[][] getData(String filename) throws IOException {
        Cella[][] board;

        String fileRoute = "data-files" + File.separator + filename;

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        // Separem el contingut en comes y separadors de linea
        String[] linearBoard = content.split(",|\\n");
        // System.out.println(Arrays.toString(linearBoard));

        // A la pos 0 i 1 tenim el tamany del Kakuro
        int tamM = Integer.parseInt(linearBoard[0]);
        int tamN = Integer.parseInt(linearBoard[1]);

        board = new Cella[tamM][tamN];

        int linearPos = 2; // Serveix per mourens per el vector linearBoard que conté tots els valors del txt
        for (int i = 0; i < tamM; ++i) {
            if (linearPos >= linearBoard.length) break; // Si em acabat el vector d'entrada cal sortir del for
            for (int j = 0; j < tamN; ++j) {
                if (linearPos >= linearBoard.length) break; // Si em acabat el vector d'entrada cal sortir del for
                String actual = linearBoard[linearPos];
                if (actual.contains("?")) {
                    // Si es ? creem una cel.la blanca
                    // System.out.println(actual + " Cella Blanca");
                    board[i][j] = new CellaBlanca();
                } else if (actual.contains("*")) {
                    // Si es * creem una cel.la blanca
                    // System.out.println(actual + " Cella Negra");
                    board[i][j] = new CellaNegra();
                } else {
                    // En qualsevol altre cas es negra
                    board[i][j] = new CellaNegra();
                    if (actual.contains("C") && actual.contains("F")) {
                        // Si conté C i F cal extreure dos valors
                        // System.out.print(actual + " contains both with digits: ");
                        // Separem per la lletra F, que está al mig, i obtenim dos strings en un vector (digits):
                        // - un te el patro CX (digits[0]) i l'altre es nomes el valor de la F (digits[1])
                        // - el valor de la F no cal fe res pero el de la C cal substituir la C per res
                        // finalment fem un parseInt de cada valor (c, f).
                        String[] digits = actual.split("F");
                        String c = digits[0].replaceAll("C", "");
                        String f = digits[1]; //Com que em separat per F abans ja no tenim lletra
                        // System.out.println(c + " " + f);

                        board[i][j].setValorColumna(Integer.parseInt(c));
                        board[i][j].setValorFila(Integer.parseInt(f));
                    } else {
                        // System.out.print(actual + " contains one with digits: ");
                        // Si conté només C o F cal extreure un valor
                        if (actual.contains("C")) {
                            // Substituim C per res per tenir només el valor i el demanem amb parseInt;
                            String digits = actual.replaceAll("C", "");
                            // System.out.println(digits);
                            board[i][j].setValorColumna(Integer.parseInt(digits));
                        }
                        if (actual.contains("F")) {
                            // Substituim F per res per tenir només el valor i el demanem amb parseInt;
                            String digits = actual.replaceAll("F", "");
                            // System.out.println(digits);
                            board[i][j].setValorFila(Integer.parseInt(digits));
                        }
                    }

                }
                System.out.println(board[i][j].color() == ColorCella.Blanca ? ("Valor blanca: " + board[i][j].getValor_blanca()) : ("Valor negra: C:" + board[i][j].getValorEsquerre() + " F:" + board[i][j].getValorDret()));
                ++linearPos;
            }
        }

        return board;
    }
}

