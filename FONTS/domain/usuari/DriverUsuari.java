package domain.usuari;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type Driver usuari.
 */
public class DriverUsuari {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Driver de la classe Usuari");
        Usuari user = new Usuari();

        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. Usuari()");
            System.out.println("2. Usuari(String nom, String username)");

            System.out.println("3. getID()");
            System.out.println("4. getNom()");
            System.out.println("5. getUsername()");
            System.out.println("6. getNumPerfils()");

            System.out.println("7. setName(String name)");
            System.out.println("8. setPass(String pass) ");
            System.out.println("9. addProfile()");

            boolean fi = false;
            while (!fi){

                String linea, opcion;
                String [] entrada;
                linea = b.readLine();
                entrada = linea.split(" ");
                opcion = entrada[0];

                try {
                    System.out.println("Has seleccionat l'opció " + opcion);
                    switch (opcion){
                        case "0":
                            fi = true;
                            break;
                        case "1":
                            user = new Usuari();
                            System.out.println("Usuari creat: " + user.getNom() + " " + user.getUsername());
                            break;
                        case "2":
                            System.out.println("Introdueix un nom:");
                            String nom = b.readLine();
                            String username = "";
                            boolean valid = false;
                            while(!valid) {
                                System.out.println("Introdueix un username:");
                                username = b.readLine();
                                entrada = username.split(" ");
                                if (entrada.length > 1) System.out.println("El username no pot contenir espais");
                                else {
                                    valid = true;
                                }
                            }
                            user = new Usuari(nom, username);
                            System.out.println("Usuari creat: " + user.getNom() + " " + user.getUsername());
                            break;
                        case "3":
                            System.out.println("L'ID de l'usuari actual es: " + user.getId());
                            break;
                        case "4":
                            System.out.println("El nom actual de l'usuari és: " + user.getNom());
                            break;
                        case "5":
                            System.out.println("L'username actual de l'usuari és: " + user.getUsername());
                            break;
                        case "6":
                            if (user.getNumPerfils() == 0) System.out.println("No hi ha perfils creats");
                            else System.out.println("Número de perfils creats: " + user.getNumPerfils());
                            break;
                        case "7":
                            System.out.println("Introdueix el nou nom:");
                            String newNom = b.readLine();
                            user.setName(newNom);
                            System.out.println("Usuari modificat: " + user.getNom() + " " + user.getUsername());
                            break;
                        case "8":
                            System.out.println("Introdueix la contrasenya:");
                            String pass = b.readLine();
                            user.setPass(pass);
                            System.out.println("Contrasenya introduida, nombre de caracters: " + pass.length());
                            break;
                        case "9":
                            System.out.println("Es procedirà a crear un perfil amb les dades actuals de l'usuari...");
                            //user.addProfile();
                            System.out.println("Perfil creat amb exit, nombre total de perfils: " + user.getNumPerfils());
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
