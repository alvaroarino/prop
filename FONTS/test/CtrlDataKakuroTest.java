import dades.CtrlDataKakuro;
import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import domain.kakuro.Kakuro;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

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
            Kakuro board = ctrlDataKakuro.getData("kakuro-test.txt");
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

            assertEquals(board.getBoard().getDimn(), correctBoard.length);
            assertEquals(board.getBoard().getDimm(), correctBoard[0].length);

            for (int i = 0; i < board.getBoard().getDimn(); ++i) {
                for (int j = 0; j < board.getBoard().getDimm(); ++j) {
                    if (board.getBoard().getCella(i,j).color() == ColorCella.Blanca) assertEquals(board.getBoard().getCella(i,j).getValor_blanca(), correctBoard[i][j].getValor_blanca());
                    if (board.getBoard().getCella(i,j).color() == ColorCella.Negra) {
                        assertEquals(board.getBoard().getCella(i,j).getValorDret(), correctBoard[i][j].getValorDret());
                        assertEquals(board.getBoard().getCella(i,j).getValorEsquerre(), correctBoard[i][j].getValorEsquerre());
                    }
                }
            }

        } catch (IOException e) {
            System.out.print("Error leyendo archivo: " + e.toString());
        }

    }
}
