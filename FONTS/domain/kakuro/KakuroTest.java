package domain.kakuro;

import static org.junit.Assert.*;
import org.junit.Test;

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
}
