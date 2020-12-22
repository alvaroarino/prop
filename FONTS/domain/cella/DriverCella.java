package domain.cella;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type Driver cella.
 */
public class DriverCella {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Driver de la classe del domini Cella");
        try {
            Cella cell = new Cella();
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introdueix una opció i els paràmetres corresponents:");
            System.out.println("0. Sortir del driver");
            System.out.println("1. Cella()");
            System.out.println("2. CellaNegra()");
            System.out.println("3. CellaNegra(int dreta, int esquerra");
            System.out.println("4. CellaBlanca()");

            System.out.println("5. intro_valor_blanca(int z) + getValor_blanca()");

            System.out.println("6. setValorFila(int val)");
            System.out.println("7. setValorColumna(int val)");

            System.out.println("8. acumular_valor_derecha(int s)");
            System.out.println("9. acumular_valor_izquierda(int s)");

            System.out.println("10. color()");
            System.out.println("11. getValorDret()");
            System.out.println("12. getValorEsquerre()");

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
                            cell = new Cella();
                            System.out.println("Cella inicialitzada sense color: " + cell);
                            break;
                        case "2":
                            cell = new CellaNegra();
                            System.out.println("Cella inicialitzada de color negre: " + cell);
                            break;
                        case "3":
                            cell = new CellaNegra(2, 4);
                            System.out.println("Cella negra amb valors " + cell.getValorDret() + " " + cell.getValorEsquerre());
                            break;
                        case "4":
                            cell = new CellaBlanca();
                            System.out.println("Cella inicialitzada de color blanc: " + cell);
                            break;
                        case "5":
                            cell = new CellaBlanca();
                            System.out.println("Quin valor vols introduir a la cella blanca:");
                            inputData = b.readLine();
                            cell.intro_valor_blanca(Integer.parseInt(inputData));
                            System.out.println("Cella blanca té valor: " + cell.getValor_blanca());
                            break;
                        case "6":
                            cell = new CellaNegra();
                            System.out.println("Quin valor de fila vols introduir a la cella negra:");
                            inputData = b.readLine();
                            cell.setValorFila(Integer.parseInt(inputData));
                            System.out.println("Cella negra té valor de fila: " + cell.getValorDret());
                            break;
                        case "7":
                            cell = new CellaNegra();
                            System.out.println("Quin valor de fila vols introduir a la cella negra:");
                            inputData = b.readLine();
                            cell.setValorColumna(Integer.parseInt(inputData));
                            System.out.println("Cella negra té valor de columna: " + cell.getValorEsquerre());
                            break;
                        case "8":
                            System.out.println("Introdueix un valor de fila per la cella: ");
                            inputData = b.readLine();
                            cell = new CellaNegra(Integer.parseInt(inputData), 0);
                            System.out.println("La cella té el següent valor de fila: " + cell.getValorDret());
                            System.out.println("Quin valor de fila vols acumular:");
                            inputData = b.readLine();
                            int s = Integer.parseInt(inputData);
                            if (s <= -1) throw new Exception("El valor introduit es menor de 0");
                            cell.acumular_valor_derecha(s);
                            System.out.println("Cella negra té valor de fila despres d'acumular: " + cell.getValorDret());
                            break;
                        case "9":
                            System.out.println("Introdueix un valor de columna per la cella: ");
                            inputData = b.readLine();
                            cell = new CellaNegra(0, Integer.parseInt(inputData));
                            System.out.println("La cella té el següent valor de columna: " + cell.getValorEsquerre());
                            System.out.println("Quin valor de columna vols acumular:");
                            inputData = b.readLine();
                            int t = Integer.parseInt(inputData);
                            if (t <= -1) throw new Exception("El valor introduit es menor de 0");
                            cell.acumular_valor_izquierda(t);
                            System.out.println("Cella negra té valor de columna despres d'acumular: " + cell.getValorEsquerre());
                            break;
                        case "10":
                            System.out.println("Quin color de cella vols crear:");
                            System.out.println("1. Blanc");
                            System.out.println("2. Negra");
                            inputData = b.readLine();
                            int value = Integer.parseInt(inputData);
                            if (value == 1) {
                                cell = new CellaBlanca();
                                if (cell.color() == ColorCella.Blanca) System.out.println("El color de la cella es Blanca");
                                else if (cell.color() == ColorCella.Blanca) System.out.println("El color de la cella no es Blanca");
                            } else if (value == 2) {
                                cell = new CellaNegra();
                                if (cell.color() == ColorCella.Negra) System.out.println("El color de la cella es Negra");
                                else if (cell.color() == ColorCella.Blanca) System.out.println("El color de la cella no es Negra");
                            } else {
                                throw new Exception("Opció no válida");
                            }
                            break;
                        case "11":
                            System.out.println("Introdueix un valor de columna per la cella: ");
                            inputData = b.readLine();
                            cell = new CellaNegra();
                            cell.setValorColumna(Integer.parseInt(inputData));
                            System.out.println("Valor dret: " + cell.getValorEsquerre());
                            break;
                        case "12":
                            System.out.println("Introdueix un valor de fila per la cella: ");
                            inputData = b.readLine();
                            cell = new CellaNegra();
                            cell.setValorFila(Integer.parseInt(inputData));
                            System.out.println("Valor dret: " + cell.getValorDret());
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
