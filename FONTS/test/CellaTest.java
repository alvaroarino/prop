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
        assertTrue(cella.getValor_blanca() == -1);
        assertTrue(cella.color() == ColorCella.Blanca);

        cella = new CellaNegra();
        assertTrue(cella.getValorEsquerre() == -1);
        assertTrue(cella.getValorDret() == -1);
        assertTrue(cella.color() == ColorCella.Negra);
    }

    @Test
    public void introValorBlancaTest(){
        cella = new CellaBlanca();
        cella.intro_valor_blanca(15);
        assertTrue(cella.getValor_blanca() == 15);
    }

    @Test
    public void getValorBlancaTest() {
        cella = new CellaBlanca();
        assertTrue(cella.getValor_blanca() == -1);

        cella.intro_valor_blanca(2);
        assertTrue(cella.getValor_blanca() == 2);
    }

    @Test
    public void setValorFilaTest() {
        cella = new CellaNegra();
        cella.setValorFila(15);
        assertTrue(cella.getValorDret() == 15);
    }

    @Test
    public void setValorColumnaTest() {
        cella = new CellaNegra();
        cella.setValorColumna(15);
        assertTrue(cella.getValorEsquerre() == 15);
    }

    @Test
    public void acumularValorDerechaTest() {
        cella = new CellaNegra();
        assertTrue(cella.getValorDret() == -1);
        cella.acumular_valor_derecha(15);
        assertTrue(cella.getValorDret() == 15);
        cella.acumular_valor_derecha(20);
        assertTrue(cella.getValorDret() == 35);
    }

    @Test
    public void acumularValorIzquierdaTest() {
        cella = new CellaNegra();
        assertTrue(cella.getValorEsquerre() == -1);
        cella.acumular_valor_izquierda(100);
        assertTrue(cella.getValorEsquerre() == 100);
        cella.acumular_valor_izquierda(20);
        assertTrue(cella.getValorEsquerre() == 120);
    }

    @Test
    public void colorTest() {
        cella = new CellaBlanca();
        assertTrue(cella.color() == ColorCella.Blanca);

        cella = new CellaNegra();
        assertTrue(cella.color() == ColorCella.Negra);
    }

    @Test
    public void getValorDretTest() {
        cella = new CellaNegra();
        assertTrue(cella.getValorDret() == -1);
        cella = new CellaNegra(2,20);
        assertTrue(cella.getValorDret() == 2);
        assertTrue(cella.getValorDret() != 20);
    }

    @Test
    public void getValorEsquerreTest() {
        cella = new CellaNegra();
        assertTrue(cella.getValorEsquerre() == -1);
        cella = new CellaNegra(2,20);
        assertTrue(cella.getValorEsquerre() != 2);
        assertTrue(cella.getValorEsquerre() == 20);
    }
}
