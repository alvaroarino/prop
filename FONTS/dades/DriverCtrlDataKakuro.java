package dades;

import domain.kakuro.Kakuro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type Driver ctrl data kakuro.
 */
public class DriverCtrlDataKakuro {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Driver de la classe del controlador de Dades de Kakuro");
        System.out.println("Actualement només es pot llegir dades");
        try {
            CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. getData()");

            boolean fi = false;
            while (!fi){

                String l, op;
                String [] x;
                l = b.readLine();
                x = l.split(" ");
                op = x[0];
                String inputData;

                try {
                    System.out.println("Has seleccionat l'opció "+op);
                    switch (op){
                        case "0":
                            fi = true;
                            break;
                        case "1":
                            Kakuro kakuro = ctrlDataKakuro.getData("kakuro-test.txt");

                            kakuro.getBoard().print();
                            //if (tauler.length == 0) throw new Exception("Les dades llegides són buides");
                            break;
                        default:
                            System.out.println(op + " no és una opció");
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
            System.out.println("Fi del driver");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
