package domain.partida;

import domain.cella.Cella;
import domain.cella.ColorCella;
import domain.kakuro.Tauler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * The type Driver partida.
 */
public class DriverPartida {
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

            System.out.println("Jugar partida Aleatòria o Introduïr paràmetres?");
            System.out.println("1. Aleatòria");
            System.out.println("2. Generar amb Paràmetres");
            System.out.println("3. Sortir");

            String l, op;
            String[] x;
            l = b.readLine();
            x = l.split(" ");
            op = x[0];
            Partida p;

            try {
                System.out.println("Has seleccionat l'opció " + op);
                switch (op) {
                    case "1":
                        p = new Partida();
                        jugar(p);
                        break;
                    case "2":
                        System.out.println("Entra els valors de files i columnes i el nom per la partida");
                        l = b.readLine();
                        x = l.split(" ");
                        op = x[0];
                        int n = parseInt(op,10);
                        op = x[1];
                        int m = parseInt(op,10);

                        p = new Partida(n, m, x[2]);
                        jugar(p);
                        break;
                    case "3":
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
     * @param p the p
     * @throws IOException the io exception
     */
    public static void jugar(Partida p) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int estat = 1;

        p.getKakuro().generar();

        boolean fi = false;
        while (!fi) {

            Tauler t = (p.getKakuro()).getBoard();
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
                            p.pause();
                            estat = 0;
                        }
                        else {
                            p.restart();
                            estat = 1;
                        }
                        break;
                    case "3":
                        t.solve();
                        break;
                    case "4":
                        System.out.println(p.getTime());
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

