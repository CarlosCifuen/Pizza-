import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner myScanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\nBienvenido a la pizzeria!" + "\n1. Recibir orden" + "\n2. Armar pizza" + "\n3. Cerrar la cocina");
         
         try {
            opcion = Integer.parseInt(myScanner.nextLine());
            } catch (NumberFormatException e){
                        System.out.println("Por favor ingresa un número válido. -_-");
                        continue;
                        }

            switch (opcion) {
            case 1: controlador.generarOrdenRandom(); break;
            case 2: controlador.ensamblarPizza(); break;
            case 3: System.out.println("Hasta luego!"); break;

            default: System.out.println("Opción no válida. -_-");
            }
        }
        myScanner.close();
    }
}

