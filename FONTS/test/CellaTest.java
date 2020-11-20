import domain.cella.Cella;
import domain.cella.CellaBlanca;
import domain.cella.CellaNegra;
import domain.cella.ColorCella;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellaTest {

    Cella cella = new Cella();

    @Test
    public void Cella() {
        cella = new CellaBlanca();
        assertEquals(cella.getValor_blanca(), -1);
        assertSame(cella.color(), ColorCella.Blanca);

        cella = new CellaNegra();
        assertEquals(cella.getValorEsquerre(), -1);
        assertEquals(cella.getValorDret(), -1);
        assertSame(cella.color(), ColorCella.Negra);
    }

    @Test
    public void introValorBlancaTest(){
        cella = new CellaBlanca();
        cella.intro_valor_blanca(15);
        assertEquals(15, cella.getValor_blanca());
    }

    @Test
    public void getValorBlancaTest() {
        cella = new CellaBlanca();
        assertEquals(cella.getValor_blanca(), -1);

        cella.intro_valor_blanca(2);
        assertEquals(2, cella.getValor_blanca());
    }

    @Test
    public void setValorFilaTest() {
        cella = new CellaNegra();
        cella.setValorFila(15);
        assertEquals(15, cella.getValorDret());
    }

    @Test
    public void setValorColumnaTest() {
        cella = new CellaNegra();
        cella.setValorColumna(15);
        assertEquals(15, cella.getValorEsquerre());
    }

    @Test
    public void acumularValorDerechaTest() {
        cella = new CellaNegra();
        assertEquals(cella.getValorDret(), -1);
        cella.acumular_valor_derecha(15);
        assertEquals(15, cella.getValorDret());
        cella.acumular_valor_derecha(20);
        assertEquals(35, cella.getValorDret());
    }

    @Test
    public void acumularValorIzquierdaTest() {
        cella = new CellaNegra();
        assertEquals(cella.getValorEsquerre(), -1);
        cella.acumular_valor_izquierda(100);
        assertEquals(100, cella.getValorEsquerre());
        cella.acumular_valor_izquierda(20);
        assertEquals(120, cella.getValorEsquerre());
    }

    @Test
    public void colorTest() {
        cella = new CellaBlanca();
        assertSame(cella.color(), ColorCella.Blanca);

        cella = new CellaNegra();
        assertSame(cella.color(), ColorCella.Negra);
    }

    @Test
    public void getValorDretTest() {
        cella = new CellaNegra();
        assertEquals(cella.getValorDret(), -1);
        cella = new CellaNegra(2,20);
        assertEquals(2, cella.getValorDret());
        assertTrue(cella.getValorDret() != 20);
    }

    @Test
    public void getValorEsquerreTest() {
        cella = new CellaNegra();
        assertEquals(cella.getValorEsquerre(), -1);
        cella = new CellaNegra(2,20);
        assertTrue(cella.getValorEsquerre() != 2);
        assertEquals(20, cella.getValorEsquerre());
    }
}
