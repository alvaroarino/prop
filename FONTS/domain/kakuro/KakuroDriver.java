package domain.kakuro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KakuroDriver {
    public static void main(String[] args) {
        System.out.println("Driver de la classe Kakuro");




        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. Generar Kakuro amb paràmetres d'usuari");
            System.out.println("2. Generar Kakuro aleatori");



            boolean fi = false;
            while (!fi){

                Kakuro kakuro = new Kakuro();
                String linea, opcion;
                String [] entrada;
                linea = b.readLine();
                entrada = linea.split(" ");
                opcion = entrada[0];

                try {
                    Kakuro kakuro = new Kakuro();
                    System.out.println("Has seleccionat l'opció " + opcion);
                    switch (opcion){
                        case "0":
                            fi = true;
                            break;
                        case "1":
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
                                System.out.println("La quantitat de caselles introduïdes no coincideix amb la dimensió escollida, selecciona una altra opció o introdueix de nou les dades");
                                break;
                            }
                            Kakuro kk = new Kakuro(n,m);
                            kk.generar_usuario(n, m, negres, blanques);
                            break;

                        case "2":
                            kakuro.generar();
                            System.out.println("S'ha creat un Kakuro de forma al·leatòria");
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








