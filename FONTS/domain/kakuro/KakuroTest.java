package domain.kakuro;

import static org.junit.Assert.*;

import dades.CtrlDataKakuro;
import domain.cella.Cella;
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

        kk.board.print();
        assertTrue(kk.board.getDimm() == m && kk.board.getDimn() == n);
    }

    /**
     * Test solver.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSolver() throws IOException {
        CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();
        Cella[][] tauler = ctrlDataKakuro.getData("kakuro1.txt");
        Kakuro kakuro = new Kakuro(tauler.length, tauler[0].length);
        kakuro.board.setTauler(tauler);
        kakuro.board.solucionar();
    }
}
