import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner myScanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\nBienvenido a la pizzeria!" + "\n1. Tomar orden manualmente" + "\n2. Generar orden aleatoria" + "\n3. Procesar orden en cocina" + "\n4. Ensamblar pizza" +  "\n5. Entregar orden" +  "\n6. Salir");
            opcion = myScanner.nextInt();
            myScanner.nextLine();

            switch (opcion) {
                case 1:
                    controlador.tomarOrden();
                    break;
                case 2:
                    controlador.generarOrdenRandom();
                    break;
                case 3:
                    controlador.procesarOrden();
                    break;
                case 4:
                    controlador.ensamblarPizza();
                    break;
                case 5:
                    controlador.entregarOrden();
                    break;
                case 6:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        myScanner.close();
    }
}