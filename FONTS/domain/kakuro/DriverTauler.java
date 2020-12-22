package domain.kakuro;

import domain.cella.Cella;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type Driver tauler.
 */
public class DriverTauler {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Driver de la classe Tauler");
        try {
            Tauler t = new Tauler();
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. Tauler(int n,int m)");
            System.out.println("2. setTauler(Cella[][] cjt)");
            System.out.println("3. getDimn()");
            System.out.println("4. getDimm()");

            System.out.println("5. getCella(int i, int j)");

            boolean fi = false;
            while (!fi) {

                String l, op;
                String[] x;
                l = b.readLine();
                x = l.split(" ");
                op = x[0];
                String inputData;

                try {
                    System.out.println("Has seleccionat l'opció " + op);
                    switch (op) {
                        case "0":
                            fi = true;
                            break;
                        case "1":
                            t = new Tauler(7,8);
                            System.out.println("Tauler inicialitzat amb n files m columnes: " + t);
                            break;
                        case "2":
                            Cella [][] Cjt = new Cella[7][8];
                            t.setTauler(Cjt);
                            System.out.println("S'ha fet un set amb Cella[][] cjt: " + t);
                            break;
                        case "3":
                           t = new Tauler(7,8);
                           System.out.println("S'ha obtingut el número de files " + t.getDimn() );
                            break;
                        case "4":
                            t = new Tauler(7,8);
                            System.out.println("S'ha obtingut el número de columnes " + t.getDimm());
                            break;
                        case "5":
                            t = new Tauler(3,3);
                            Cella c = t.getCella(1,1);
                            System.out.println("S'obté la cel·la Cel·la:" + c);
                            break;

                        default:
                            System.out.println(op + " no és una opció");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
            System.out.println("Fi del driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}







