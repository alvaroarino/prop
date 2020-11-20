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
    public void testnoPresente() {
        Tauler t = new Tauler(3,3);
        t.getCella(1,1).intro_valor_blanca(5);
        t.getCella(2,2).intro_valor_blanca(4);

       boolean cont1 = t.noPresente(4,1,2);
       boolean cont2 = t.noPresente(5,2,1);
        boolean cont3 = t.noPresente(6,2,1);

        assertTrue(cont1 == true );
        assertTrue(cont2 == true );
        assertTrue(cont3 != true );


    }

    @Test
    public void testrellenar_blancas1() {

        Tauler t = new Tauler(3,3);

        t.rellenar_blancas1();

        int valor1 = t.getCella(1,1).getValor_blanca();
        int valor2 = t.getCella(1,2).getValor_blanca();
        int valor3 = t.getCella(2,1).getValor_blanca();
        int valor4 = t.getCella(2,2).getValor_blanca();

        assertTrue(valor1 != valor2  );
        assertTrue(valor1 != valor3  );
        assertTrue(valor2 != valor4  );
        assertTrue(valor3 != valor4  );

    }

    @Test
    public void testhacer_sumas() {

        Tauler t = new Tauler(3,3);
        t.getCella(1,1).intro_valor_blanca(2);
        t.getCella(1,2).intro_valor_blanca(3);
        t.getCella(2,1).intro_valor_blanca(4);
        t.getCella(2,2).intro_valor_blanca(5);

        t.hacer_sumas();

        assertTrue(t.getCella(0,1).getValorEsquerre() == 6 );
        assertTrue(t.getCella(0,2).getValorEsquerre() == 8 );
        assertTrue(t.getCella(1,0).getValorDret() == 5  );
        assertTrue(t.getCella(2,0).getValorDret() == 9 );

    }

    @Test
    public void testsolucionar(){

        Tauler t = new Tauler(3,3);

        t.getCella(0,1).setValorColumna(4);
        t.getCella(0,2).setValorColumna(6);
        t.getCella(1,0).setValorFila(3);
        t.getCella(2,0).setValorFila(7);

        t.solucionar();
        assertTrue(t.getCella(1,1).getValor_blanca() == 1);
        assertTrue(t.getCella(1,2).getValor_blanca() == 2);
        assertTrue(t.getCella(2,1).getValor_blanca() == 3);
        assertTrue(t.getCella(2,2).getValor_blanca() == 4);


    }



}

