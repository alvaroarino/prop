package domain.usuari;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverUsuari {
    public static void main(String[] args) {
        System.out.println("Driver de la classe Usuari");
        try {
            Usuari user = new Usuari();
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("1. Usuari ()");
            System.out.println("2. Usuari(String nom, String username)");

            System.out.println("3. getID() ");
            System.out.println("4. setName(String name)");
            System.out.println("5. setPass(String pass) ");
            System.out.println("6. getFi() ");

            System.out.println("7. addProfile()");

            boolean fi = false;
            while (!fi){

                String l, op;
                String [] x;
                l = b.readLine();
                x = l.split(" ");
                op = x[0];
                int e1, e2;

                try {
                    System.out.println("Has seleccionat l'opció "+op);
                    switch (op){
                        case "0":
                            fi = true;
                            break;
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                            break;
                        case "5":
                            break;
                        case "6":
                            break;
                        case "7":
                            break;
                        default:
                            System.out.println(op+" no és una opció");
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
