package dades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverCtrlDataUsuaris {
    public static void main(String[] args) {
        System.out.println("Driver de la classe del controlador de Dades d'Usuari");
        try {
            CtrlDataUsuaris userData = CtrlDataUsuaris.getInstance();
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("1. getData()");
            System.out.println("2. writeData()");

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
                            String data = userData.getData();
                            System.out.print("Les dades obtenides són: ");
                            System.out.print(data);
                            if (data.equals("")) throw new Exception("Les dades llegides són buides");
                            break;
                        case "2":
                            inputData = x[1];
                            userData.writeData();
                            String newData = userData.getData();
                            if (newData.equals(inputData)) throw new Exception("Les dades no s'han registrat.");
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
