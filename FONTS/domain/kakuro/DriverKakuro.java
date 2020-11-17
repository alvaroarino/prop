package domain.kakuro;

import domain.kakuro.Kakuro;

/**
 * The type Driver kakuro.
 */
public class DriverKakuro {

    /**
     * Test generar.
     */
    public void testGenerar() {

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Kakuro kk = new Kakuro(9, 9);
        kk.generar();
    }

}