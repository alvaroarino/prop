package dades;

import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;

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

        String fileRoute = System.getProperty("user.dir") + "/FONTS/data-files/" + filename;

        Path path = Paths.get(fileRoute);
        String content = Files.readString(path);
        System.out.println(content);

        // Separem el contingut en comes y separadors de linea
        String[] linearBoard = content.split(",|\\n");
        System.out.println(Arrays.toString(linearBoard));

        int tamM = Integer.parseInt(linearBoard[0]);
        int tamN = Integer.parseInt(linearBoard[1]);

        board = new Cella[tamM][tamN];

        int linearPos = 2;
        for (int i = 0; i < tamM; ++i) {
            if (linearPos >= linearBoard.length) break;
            for (int j = 0; j < tamN; ++j) {
                if (linearPos >= linearBoard.length) break;
                String actual = linearBoard[linearPos];

                if (actual.contains("?")) {
                    System.out.println(actual + " Cella Blanca");
                    board[i][j] = new CellaBlanca();
                } else if (actual.contains("*")) {
                    System.out.println(actual + " Cella Negra");
                    board[i][j] = new CellaNegra();
                } else {
                    board[i][j] = new CellaNegra();

                    if (actual.contains("C") && actual.contains("F")) {
                        System.out.print(actual + " contains both with digits: ");

                        String[] digits = actual.split("F");
                        String c = digits[0].replaceAll("C", "");
                        String f = digits[1]; //Com que em separat per F abans ja no tenim lletra
                        System.out.println(c + " " + f);

                        board[i][j].setValorColumna(Integer.parseInt(c));
                        board[i][j].setValorFila(Integer.parseInt(f));
                    } else {
                        System.out.print(actual + " contains one with digits: ");
                        if (actual.contains("C")) {
                            String digits = actual.replaceAll("C", "");
                            System.out.println(digits);
                            board[i][j].setValorColumna(Integer.parseInt(digits));
                        }
                        if (actual.contains("F")) {
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

        return board;
    }
}

