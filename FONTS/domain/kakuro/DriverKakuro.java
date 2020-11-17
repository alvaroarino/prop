package domain.kakuro;

import domain.kakuro.Kakuro;

public class DriverKakuro {

    public void testGenerar() {

    }

    public static void main(String[] args) {
        Kakuro kk = new Kakuro(9, 9);
        kk.generar();
    }

}