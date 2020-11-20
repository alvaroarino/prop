import static org.junit.Assert.*;

import dades.CtrlDataKakuro;
import domain.cella.Cella;
import domain.kakuro.Kakuro;
import domain.kakuro.Tauler;
import org.junit.Test;

import java.io.IOException;

public class KakuroTest {

    @Test
    public void testGenerar() {
        int n = 20;
        int m = 20;

        Kakuro kk = new Kakuro(n, m);
        kk.generar();

        assertTrue(kk.getBoard().getDimm() == m && kk.getBoard().getDimn() == n);
    }

    @Test
    public void testSolver() throws IOException {
        CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();
        Cella[][] tauler = ctrlDataKakuro.getData("kakuro-test.txt");
        Kakuro kakuro = new Kakuro(tauler.length, tauler[0].length);
        kakuro.getBoard().setTauler(tauler);
        kakuro.getBoard().solucionar();
    }
}
