import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import domain.kakuro.Tauler;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Tauler test.
 */
public class TaulerTest {

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor() {
        Tauler t;
        int x = 7;
        int y = 8;
        t = new Tauler(x,y);

        assertTrue(t.getDimn() == x && t.getDimm() == y);
    }


    /**
     * Testset tauler.
     */
    @Test
    public void testsetTauler() {
        Tauler nou = new Tauler(9,9);

        Cella[][] t = {
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

        nou.setTauler(t);

        assertEquals(nou.getDimn(), t.length);
        assertEquals(nou.getDimm(), t[0].length);

        for (int i = 0; i < t.length; ++i) {
            for (int j = 0; j < t[0].length; ++j) {
                if (t[i][j].color() == ColorCella.Blanca) assertEquals(t[i][j].getValor_blanca(), nou.getCella(i,j).getValor_blanca());
                if (t[i][j].color() == ColorCella.Negra) {
                    assertEquals(t[i][j].getValorDret(), nou.getCella(i,j).getValorDret());
                    assertEquals(t[i][j].getValorEsquerre(), nou.getCella(i,j).getValorEsquerre());
                }
            }
        }
    }


    /**
     * Test get dimn.
     */
    @Test
    public void testGetDimn() {
        int n = 7;
        Tauler t;
        t = new Tauler (n,8);

        assertEquals(t.getDimn(), n);
    }

    /**
     * Test get dimm.
     */
    @Test
    public void testGetDimm() {
        int m = 7;
        Tauler t;
        t = new Tauler (8,m);

        assertEquals(t.getDimm(), m);
    }

    /**
     * Test pintar celda.
     */
    @Test
    public void testPintar_celda() {
        Tauler nou = new Tauler(8,8);
        nou.pintar_celda(4,4,1);
        assertSame(nou.getCella(4, 4).color(), ColorCella.Negra);
    }

    /**
     * Testpintar negras.
     */
    @Test
    public void testpintar_negras() {}

    /**
     * Testno presente.
     */
    @Test
    public void testnoPresente() {
        Tauler t = new Tauler(3,3);
        t.getCella(1,1).intro_valor_blanca(5);
        t.getCella(2,2).intro_valor_blanca(4);

        boolean cont1 = t.noPresente(4,1,2);
        boolean cont2 = t.noPresente(5,2,1);
        boolean cont3 = t.noPresente(6,2,1);

        assertTrue(cont1);
        assertTrue(cont2);
        assertFalse(cont3);

    }

    /**
     * Test rellenar blancas 1.
     */
    @Test
    public void testRellenar_blancas1() {

        Tauler t = new Tauler(3,3);

        t.rellenar_celdas_blancas();

        int valor1 = t.getCella(1,1).getValor_blanca();
        int valor2 = t.getCella(1,2).getValor_blanca();
        int valor3 = t.getCella(2,1).getValor_blanca();
        int valor4 = t.getCella(2,2).getValor_blanca();

        assertTrue(valor1 != valor2  );
        assertTrue(valor1 != valor3  );
        assertTrue(valor2 != valor4  );
        assertTrue(valor3 != valor4  );

    }

    /**
     * Testhacer sumas.
     */
    @Test
    public void testhacer_sumas() {

        Tauler t = new Tauler(3,3);
        t.getCella(1,1).intro_valor_blanca(2);
        t.getCella(1,2).intro_valor_blanca(3);
        t.getCella(2,1).intro_valor_blanca(4);
        t.getCella(2,2).intro_valor_blanca(5);

        t.hacer_sumas();

        assertEquals(6, t.getCella(0, 1).getValorEsquerre());
        assertEquals(8, t.getCella(0, 2).getValorEsquerre());
        assertEquals(5, t.getCella(1, 0).getValorDret());
        assertEquals(9, t.getCella(2, 0).getValorDret());
    }

    /**
     * Test solucionar.
     */
    @Test
    public void testSolucionar(){

        Tauler t = new Tauler(3,3);

        t.getCella(0,1).setValorColumna(4);
        t.getCella(0,2).setValorColumna(6);
        t.getCella(1,0).setValorFila(3);
        t.getCella(2,0).setValorFila(7);

        t.solve();
        assertEquals(1, t.getCella(1, 1).getValor_blanca());
        assertEquals(2, t.getCella(1, 2).getValor_blanca());
        assertEquals(3, t.getCella(2, 1).getValor_blanca());
        assertEquals(4, t.getCella(2, 2).getValor_blanca());
    }



}

