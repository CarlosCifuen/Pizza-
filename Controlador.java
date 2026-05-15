import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

    private Cocina cocina;
    private Scanner myScanner;
//  private Vista vista; (aun no existe la clase Vista)
    private GenOrdenes genOrdenes;

    public Controlador() {
    this.cocina = new Cocina();
    this.genOrdenes = new GenOrdenes(cocina);
    this.myScanner = new Scanner(System.in);
//  this.vista = new Vista(); (aun no existe la clase Vista)  
    }

    public void tomarOrden() {
        System.out.println("Nombre del cliente:");
        String nombreCliente = myScanner.nextLine();
        Orden neworden = new Orden(nombreCliente, cocina.getOrdenes().size() + 1);
        System.out.println("Cuantas pizzas deseas ordenar?");
        int cantidadPizzas = myScanner.nextInt();
        myScanner.nextLine(); // Consumir el salto de línea
        for (int i = 0; i < cantidadPizzas; i++) {
            System.out.println("Creando pizza #" + (i + 1));
            crearPizza(neworden);

        }
        enviarOrdenACocina(neworden);
        System.out.println("Orden #" + neworden.getNumeroOrden() + " tomada para " + neworden.getNombreCliente());
    }

public void crearPizza(Orden orden) {
    Pizza pizza = new Pizza();
    
    // Base
    boolean baseValida = false;
    while (!baseValida) {
        System.out.println("Que coccion quiere para la base? \n Suave \n Media \n Crujiente");
        String cox = myScanner.nextLine();
        if (cox.equalsIgnoreCase("media")) {
            pizza.agregarIngrediente(new Base("Base Media", 5.0f, "Media"));
            baseValida = true;
        } else if (cox.equalsIgnoreCase("crujiente")) {
            pizza.agregarIngrediente(new Base("Base Crujiente", 5.0f, "Crujiente"));
            baseValida = true;
        } else if (cox.equalsIgnoreCase("suave")) {
            pizza.agregarIngrediente(new Base("Base Suave", 4.0f, "Suave"));
            baseValida = true;
        } else {
            System.out.println("Opción no válida, intente de nuevo.");
        }
    }

    // Salsa
    boolean salsaValida = false;
    while (!salsaValida) {
        System.out.println("Quiere salsa picante? (si/no)");
        String salsaPicante = myScanner.nextLine();
        if (salsaPicante.equalsIgnoreCase("si")) {
            pizza.agregarIngrediente(new Salsa("Salsa Picante", 1.0f, true));
            salsaValida = true;
        } else if (salsaPicante.equalsIgnoreCase("no")) {
            pizza.agregarIngrediente(new Salsa("Salsa Normal", 0.5f, false));
            salsaValida = true;
        } else {
            System.out.println("Opción no válida, intente de nuevo.");
        }
    }

    // Toppings
    boolean cantidadValida = false;
    int cantidadIngredientes = 0;
    while (!cantidadValida) {
        System.out.println("Cuantos toppings deseas agregar? (MAXIMO 6)");
        cantidadIngredientes = myScanner.nextInt();
        myScanner.nextLine();
        if (cantidadIngredientes < 0 || cantidadIngredientes > 6) {
            System.out.println("Cantidad no válida, intente de nuevo.");
        } else {
            cantidadValida = true;
        }
    }

    for (int j = 0; j < cantidadIngredientes; j++) {
        boolean toppingValido = false;
        while (!toppingValido) {
            System.out.println("Que topping deseas agregar? \n Camarones \n Pez \n Hielo \n Piña \n Salchicha \n Calamar");
            String topping = myScanner.nextLine();
            if (topping.equalsIgnoreCase("camarones")) {
                pizza.agregarIngrediente(new Topping("Camarones", 2.0f, true, false));
                toppingValido = true;
            } else if (topping.equalsIgnoreCase("pez")) {
                pizza.agregarIngrediente(new Topping("Pez", 1.5f, false, false));
                toppingValido = true;
            } else if (topping.equalsIgnoreCase("hielo")) {
                pizza.agregarIngrediente(new Topping("Hielo", 0.5f, false, true));
                toppingValido = true;
            } else if (topping.equalsIgnoreCase("piña")) {
                pizza.agregarIngrediente(new Topping("Piña", 1.0f, false, true));
                toppingValido = true;
            } else if (topping.equalsIgnoreCase("salchicha")) {
                pizza.agregarIngrediente(new Topping("Salchicha", 1.5f, true, false));
                toppingValido = true;
            } else if (topping.equalsIgnoreCase("calamar")) {
                pizza.agregarIngrediente(new Topping("Calamar", 2.0f, false, false));
                toppingValido = true;
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
         orden.agregarPizza(pizza);
}

    public void enviarOrdenACocina(Orden neworden) {
        cocina.almacenarOrden(neworden);
    }

    public void generarOrdenRandom() {
    Orden orden = genOrdenes.generarOrden();
    enviarOrdenACocina(orden);
    System.out.println("Orden random generada para: " + orden.getNombreCliente());
    }


    public void procesarOrden() {
    ArrayList<Orden> ordenesEnEspera = cocina.hayOrdenesEnEspera();
    if (ordenesEnEspera.isEmpty()) {
        System.out.println("No hay ordenes en espera para procesar.");
    } else {
        Orden ordenAProcesar = ordenesEnEspera.get(0); // Procesar la primera orden en espera
        cocina.procesarOrden(ordenAProcesar);
        }
    }

    public void ensamblarPizza() {
    cocina.ensamblarPizza();
    }

    public void entregarOrden() {
    cocina.entregarOrden();
    }

}    
    


