package domain.kakuro;

import dades.CtrlDataKakuro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * The type Kakuro driver.
 */
public class KakuroDriver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Driver de la classe Kakuro");

        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. Generar Kakuro amb paràmetres d'usuari");
            System.out.println("2. Generar Kakuro aleatori");
            System.out.println("3. Solucionar Kakuro (fitxer data-files/kakuro-test.txt");


            boolean fi = false;
            while (!fi) {
                String linea, opcion;
                String [] entrada;
                linea = b.readLine();
                entrada = linea.split(" ");
                opcion = entrada[0];
                Kakuro kakuro = new Kakuro();
                try {
                   // Kakuro kakuro = new Kakuro();
                    System.out.println("Has seleccionat l'opció " + opcion);
                    switch (opcion){
                        case "0":
                            fi = true;
                            break;
                        case "1":
                            //Kakuro kakuro = new Kakuro();
                            Scanner intro = new Scanner(System.in);
                            int n, m, negres, blanques;
                            System.out.println("Introdueix una dimensió, escriu primer el número de files n");
                            n = Integer.parseInt(intro.nextLine());
                            System.out.println("Ara el número de columnes m");
                            m = Integer.parseInt(intro.nextLine());
                            System.out.println("Indica el nombre de caselles negres que desitges");
                            negres = Integer.parseInt(intro.nextLine());
                            System.out.println("Indica el nombre de caselles blanques que desitges");
                            blanques = Integer.parseInt(intro.nextLine());

                            if (negres + blanques != (n*m)) {
                                throw new Exception("La quantitat de caselles introduïdes no coincideix amb la dimensió escollida, selecciona una altra opció o introdueix de nou les dades");
                            }

                            kakuro = new Kakuro(n,m);
                            //kakuro.generar_usuario(n, m, negres, blanques);
                            break;
                        case "2": {
                            kakuro.generar();
                            System.out.println("S'ha creat un Kakuro de forma al·leatòria");
                            break;
                        }

                        case "3":
                            CtrlDataKakuro ctrlDataKakuro = CtrlDataKakuro.getInstance();
                            Kakuro kak = ctrlDataKakuro.getData("kakuro-test.txt");
                            kak.getBoard().solve();
                            break;
                        default:
                            System.out.println(opcion + " no és una opció");
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








