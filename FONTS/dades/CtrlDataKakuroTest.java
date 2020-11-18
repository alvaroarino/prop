package dades;

import domain.cella.Cella;
import static org.junit.Assert.*;

import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import org.junit.Test;

import java.io.IOException;

/**
 * The type Ctrl data kakuro test.
 */
public class CtrlDataKakuroTest {
    /**
     * Test get data.
     */
    @Test
    public void testGetData() {
        CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();

        try {
            Cella[][] board = ctrlDataKakuro.getData("kakuro-test.txt");
            Cella[][] correctBoard = {
                    {new CellaNegra(), new CellaNegra(), new CellaNegra(-1, 19), new CellaNegra(-1, 12), new CellaNegra(), new CellaNegra(), new CellaNegra(), new CellaNegra(-1, 7), new CellaNegra(-1, 10)},
                    {new CellaNegra(), new CellaNegra(14, -1), new CellaBlanca(), new CellaBlanca(), new CellaNegra(-1, 4), new CellaNegra(-1, 11), new CellaNegra(4, 17), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(), new CellaNegra(36, 7), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(12,-1), new CellaBlanca(), new CellaBlanca(), new CellaNegra(10,-1), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra(-1,25), new CellaNegra(-1, 14)},
                    {new CellaNegra(3,-1), new CellaBlanca(), new CellaBlanca(), new CellaNegra(-1,20), new CellaNegra(20,11), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(17,-1), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra(-1,8), new CellaNegra(6,-1), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(), new CellaNegra(-1, 11), new CellaNegra(13, 7), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra(10, 4), new CellaBlanca(), new CellaBlanca()},
                    {new CellaNegra(28,-1), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaBlanca(), new CellaNegra()},
                    {new CellaNegra(6,-1), new CellaBlanca(), new CellaBlanca(), new CellaNegra(), new CellaNegra(), new CellaNegra(8,-1), new CellaBlanca(), new CellaBlanca(), new CellaNegra()},
            };

            assertEquals(board.length, correctBoard.length);
            assertEquals(board[0].length, board[0].length);

            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (board[i][j].color() == ColorCella.Blanca) assertEquals(board[i][j].getValor_blanca(), correctBoard[i][j].getValor_blanca());
                    if (board[i][j].color() == ColorCella.Negra) {
                        assertEquals(board[i][j].getValorDret(), correctBoard[i][j].getValorDret());
                        assertEquals(board[i][j].getValorEsquerre(), correctBoard[i][j].getValorEsquerre());
                    }
                }
            }

        } catch (IOException e) {
            System.out.print("Error leyendo archivo: " + e.toString());
        }

    }
}
