import static org.junit.Assert.*;

import dades.CtrlDataKakuro;
import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import domain.kakuro.Kakuro;
import domain.kakuro.Tauler;
import org.junit.Test;

import java.io.IOException;

public class TaulerTest {



    @Test

    public void TaulerTest() {

        Tauler t;
        int x = 7;
        int y = 8;
        t = new Tauler(x,y);

        assertTrue(t.getDimn() == x && t.getDimm() == y);

    }


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


    @Test
    public void testgetDimn() {

    int n = 7;
    Tauler t;
    t = new Tauler (n,8);


        assertTrue(t.getDimn() == n );

    }

    @Test
    public void testgetDimm() {

        int m = 7;
        Tauler t;
        t = new Tauler (8,m);


        assertTrue(t.getDimm() == m );

    }




    @Test
    public void testpintar_celda() {
        Tauler nou = new Tauler(8,8);
        nou.pintar_celda(4,4,1);
        assertTrue(nou.getCella(4,4).color() == ColorCella.Negra);

    }

    @Test
    public void testpintar_negras() {


    }

    @Test
    public void testnoPresenteCol() {

        Tauler nou = new Tauler(8,8);
        Cella[][] CjtCelles = new Cella[8][8];
        nou.setTauler(CjtCelles);
        CjtCelles[0][4] = new CellaNegra();

        for(int i = 1; i < 8; ++i) {
            if( i != 4) {
                CellaBlanca cella = new CellaBlanca();
                cella.intro_valor_blanca(i);
                CjtCelles[i][4] = cella;
            }
            else {
                CjtCelles[i][4] = new CellaBlanca();
            }
        }
        assertTrue(nou.noPresenteCol(4,4,4) == true);

    }

    @Test
    public void testnoPresenteCol1() {

    }

    @Test
    public void testrellenar_blancas1() {

    }

    @Test
    public void testhacer_sumas() {

    }

    @Test
    public void testsolucionar(){

    }




    @Test
    public void testprint() {





    }








}

