package dades;

import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.kakuro.Tauler;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The type Ctrl data kakuro.
 */
public class CtrlDataKakuro {
    private static CtrlDataKakuro singletonObject;

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

    /** Constructora privada. **/

    private CtrlDataKakuro() {}

    /**
     * Obtenir les dades del fitxer d'usuaris.
     *
     * @param filename the filename
     * @return the data
     * @throws IOException the io exception
     */
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

                        board[i][j].SetValorColN(Integer.parseInt(c));
                        board[i][j].SetValorFilaN(Integer.parseInt(f));
                    } else {
                        System.out.print(actual + " contains one with digits: ");
                        if (actual.contains("C")) {
                            String digits = actual.replaceAll("C", "");
                            System.out.println(digits);
                            board[i][j].SetValorColN(Integer.parseInt(digits));
                        }
                        if (actual.contains("F")) {
                            String digits = actual.replaceAll("F", "");
                            System.out.println(digits);
                            board[i][j].SetValorFilaN(Integer.parseInt(digits));
                        }
                    }

                }
                System.out.println(board[i][j].color() == 0 ? ("Valor blanca: " + board[i][j].getValor_blanca()) : ("Valor negra: C:" + board[i][j].getValorEsquerre() + " F:" + board[i][j].getValorDret()));
                ++linearPos;
            }
        }

        return board;
    }
}

