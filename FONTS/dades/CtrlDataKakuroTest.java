package dades;

import domain.cella.Cella;
import static org.junit.Assert.*;

import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import org.junit.Test;

import java.io.IOException;

public class CtrlDataKakuroTest {
    @Test
    public void testGetData() throws IOException {
        CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();

        try {
            Cella[][] board = ctrlDataKakuro.getData2("kakuro-test.txt");
            Cella[][] correctBoard = {
                    {new CellaNegra(), new CellaNegra(), new CellaNegra(0, 19), new CellaNegra(0, 12), new CellaNegra(), new CellaNegra(), new CellaNegra(), new CellaNegra(0, 7), new CellaNegra(0, 10)},
                    {new CellaNegra(), new CellaNegra(14, 0), new CellaBlanca(), new CellaBlanca(), new CellaNegra(0, 4), new CellaNegra(0, 11), new CellaNegra(4, 17), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(), new CellaNegra(36, 7), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(12,0), new CellaBlanca(), new CellaBlanca(), new CellaNegra(10,0), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra(0,25), new CellaNegra(0, 14)},
                    {new CellaNegra(3,0), new CellaBlanca(), new CellaBlanca(), new CellaNegra(0,20), new CellaNegra(20,11), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(17,0), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra(0,8), new CellaNegra(6,0), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(), new CellaNegra(0, 11), new CellaNegra(13, 7), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra(10, 4), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(28,0), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra()},
                    {new CellaNegra(6,0), new CellaBlanca(), new CellaBlanca(), new CellaNegra(), new CellaNegra(), new CellaNegra(8,0), new CellaBlanca(), new CellaBlanca(), new CellaNegra()},
            };

            for (int i = 0; i < 9; ++i) {
                assertArrayEquals(board[i], correctBoard[i]);
            }

        } catch (IOException e) {
            System.out.print("Error leyendo archivo: " + e.toString());
        }

    }
}
