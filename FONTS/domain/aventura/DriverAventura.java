package domain.aventura;

import domain.cella.Cella;
import domain.cella.ColorCella;
import domain.kakuro.Kakuro;
import domain.kakuro.Tauler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The type Driver aventura.
 */
public class DriverAventura {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        boolean fi = false;
        while (!fi) {

            System.out.println("Jugar Aventura amb 5, 10 o 15 nivells, o sortir");
            System.out.println("1. 5");
            System.out.println("2. 10");
            System.out.println("3. 15");
            System.out.println("4. Sortir");

            String l, op;
            String[] x;
            l = b.readLine();
            x = l.split(" ");
            op = x[0];
            Aventura av;

            try {
                System.out.println("Has seleccionat l'opció " + op);
                switch (op) {
                    case "1":
                        av = new Aventura(5);
                        jugar(av);
                        break;
                    case "2":
                        av = new Aventura(10);
                        jugar(av);
                        break;
                    case "3":
                        av = new Aventura(15);
                        jugar(av);
                        break;
                    case "4":
                        fi = true;
                        break;

                    default:
                        System.out.println(op + " no és una opció");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * Jugar.
     *
     * @param av the av
     * @throws IOException the io exception
     */
    public static void jugar(Aventura av) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int estat = 1;
        for (int i = 0; i < av.getNumNivells(); ++i) {
            Kakuro k = av.getKakuro(i);
            k.generar();
            boolean fi = false;
            while (!fi) {

                Tauler t = k.getBoard();
                t.print();

                System.out.println("Afegeix Numero, Pausa, Comproba, Obté el temps o Surt");
                System.out.println("1. Afegeix Numero");
                System.out.println("2. Pausa o Reiniciar");
                System.out.println("3. Comproba (Només funciona correctament si el kakuro está complet)");
                System.out.println("4. Obtenir Temps");
                System.out.println("5. Sortir");

                String l, op;
                String[] x;
                l = b.readLine();
                x = l.split(" ");
                op = x[0];

                try {
                    System.out.println("Has seleccionat l'opció " + op);
                    switch (op) {
                        case "1":
                            System.out.println("Introdueix per ordre fila, columna y valor");
                            AfegeixNumero(t);
                            break;

                        case "2":
                            if (estat == 1) {
                                av.pause();
                                estat = 0;
                            } else {
                                av.restart();
                                estat = 1;
                            }
                            break;

                        case "3":
                            t.solve();
                            break;

                        case "4":
                            System.out.println(av.getTemps());
                            break;

                        case "5":
                            fi = true;
                            break;

                        default:
                            System.out.println(op + " no és una opció");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void AfegeixNumero(Tauler t) throws IOException {
        int n, m, valor;

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        String l;
        String[] x;
        l = b.readLine();
        x = l.split(" ");

        n = (x[0].charAt(0) - '0');
        m = (x[1].charAt(0) - '0');
        valor = (x[2].charAt(0) - '0');

        Cella c = t.getCella(n, m);

        if (c.color() == ColorCella.Blanca) {
            c.intro_valor_blanca(valor);
        }
        else {
            System.out.println("Aquesta no es una cella blanca!");
        }
    }
}
