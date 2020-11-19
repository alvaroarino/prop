package domain.kakuro;

import java.util.Scanner;

public class KakuroDriver {
    public void testGenerar() {

    }

    public static void main(String[] args) {
        System.out.println("Driver de la classe Kakuro");
        Scanner entrada = new  Scanner(System.in);
        int n, m, negres, blanques;
        System.out.println("Introdueix una dimensió, escriu primer el número de files n");
        n = Integer.parseInt(entrada.nextLine());
        System.out.println("Ara el número de columnes m");
        m = Integer.parseInt(entrada.nextLine());
        System.out.println("Indica el nombre de caselles negres que desitges");
        negres = Integer.parseInt(entrada.nextLine());
        System.out.println("Indica el nombre de caselles blanques que desitges");
        blanques = Integer.parseInt(entrada.nextLine());

        Kakuro kk = new Kakuro(n, m);
        kk.generar_usuario(n,m,negres,blanques);


    }
}
