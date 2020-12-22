import dades.CtrlDataKakuro;
import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.kakuro.Kakuro;
import org.junit.Test;

import java.io.IOException;

/**
 * The type Kakuro test.
 */
public class KakuroTest {

    /**
     * Test generar.
     */
    @Test
    public void testGenerar() {
        int n = 9;
        int m = 9;

        Kakuro kk = new Kakuro(n, m);
        kk.generar();

        //assertTrue(kk.getBoard().getDimm() == m && kk.getBoard().getDimn() == n);
    }

    /**
     * Test solver.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSolver() throws IOException {
        CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();
        //Cella[][] tauler = ctrlDataKakuro.getData("kakuro-test.txt");
        Cella[][] tauler = {
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
        Kakuro kakuro = new Kakuro(tauler.length, tauler[0].length);
        kakuro.getBoard().setTauler(tauler);
        kakuro.getBoard().solve();
    }
}
