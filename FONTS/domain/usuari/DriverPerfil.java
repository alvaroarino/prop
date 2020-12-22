package domain.usuari;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type Driver perfil.
 */
public class DriverPerfil {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Driver de la classe Perfil");
        Perfil perfil = new Perfil();

        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. Perfil()");
            System.out.println("2. Perfil(String nom)");

            System.out.println("3. setNom()");

            System.out.println("4. getNom()");

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
                            System.out.println("Usuari creat: " + perfil.getNom());
                            break;
                        case "2":
                            System.out.println("Introdueix un nom:");
                            String nom = b.readLine();
                            perfil = new Perfil(nom);
                            System.out.println("Usuari creat: " + perfil.getNom());
                            break;
                        case "3":
                            System.out.println("Introdueix el nou nom:");
                            String newNom = b.readLine();
                            perfil.setNom(newNom);
                            System.out.println("Perfil modificat: " + perfil.getNom());
                            break;
                        case "4":
                            System.out.println("El nom actual del perfil és: " + perfil.getNom());
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
