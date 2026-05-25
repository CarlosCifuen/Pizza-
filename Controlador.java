import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

    private Cocina cocina;
    private Scanner myScanner;
//  private Vista vista; (aun no existe la clase Vista)
    private GenOrdenes genOrdenes;
    private Pizza pizzaArmada;

    public Controlador() {
    this.cocina = new Cocina();
    this.genOrdenes = new GenOrdenes(cocina);
    this.myScanner = new Scanner(System.in);
    this.pizzaArmada = null;
//  this.vista = new Vista(); (aun no existe la clase Vista)  
    }

    public void enviarOrdenACocina(Orden neworden) {
        cocina.almacenarOrden(neworden);
    }

    public void generarOrdenRandom() {
    Orden orden = genOrdenes.generarOrden();
    enviarOrdenACocina(orden);
    System.out.println(orden.describirOrden());
    }

public void ensamblarPizza() {
    if (cocina.getOrdenes().isEmpty() || cocina.getordenActual() == null){
        System.out.println("No hay una orden en proceso para ensamblar una pizza.");
        return;
    } else {
        Pizza pizzaEnConstruccion = cocina.getordenActual().getPizzas().get(0);
        System.out.println(pizzaEnConstruccion.describirPizza());
        pizzaArmada = new Pizza();
        boolean ensamblando = true;
        while (ensamblando) {
            System.out.println("== Opciones para la pizza :J ==");
            System.out.println("1. Agregar Base");
            System.out.println("2. Agregar Salsa");
            System.out.println("3. Agregar Topping");
            System.out.println("4. Quitar último ingrediente");
            System.out.println("5. Mostrar orden");
            System.out.println("6. Entregar orden");
            System.out.println("7. Volver al menú principal");
            int opcion = myScanner.nextInt();
            switch (opcion) {
                case 1:
                    if (pizzaArmada.getIngredientes().size() == 0) {
                        System.out.println("Selecciona el tipo de base:");
                        System.out.println("1. Base Suave");
                        System.out.println("2. Base Media");
                        System.out.println("3. Base Crujiente");
                        int opcionBase = myScanner.nextInt();
                        Base base;
                        switch (opcionBase) {
                            case 1:
                                base = new Base("Base Suave", 5.0f, "Suave");
                                break;
                            case 2:
                                base = new Base("Base Media", 5.0f, "Media");
                                break;
                            case 3:
                                base = new Base("Base Crujiente", 5.0f, "Crujiente");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                base = null;
                        }
                        if (base != null) {
                            pizzaArmada.agregarIngrediente(base);
                        }
                    } else {
                        System.out.println("La pizza ya tiene una base.");
                    }
                    break;
                case 2:
                    if (pizzaArmada.getIngredientes().size() == 1) {
                        System.out.println("Selecciona el tipo de salsa:");
                        System.out.println("1. Salsa Picante");
                        System.out.println("2. Salsa Normal");
                        int opcionSalsa = myScanner.nextInt();
                        Salsa salsa;
                        switch (opcionSalsa) {
                            case 1:
                                salsa = new Salsa("Salsa Picante", 2.0f, true);
                                break;
                            case 2:
                                salsa = new Salsa("Salsa Normal", 2.0f, false);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                salsa = null;
                        }
                        if (salsa != null) {
                            pizzaArmada.agregarIngrediente(salsa);
                        }
                    } else {
                        System.out.println("La pizza debe tener una base antes de agregar salsa, o ya tiene salsa.");
                    }
                    break;
                case 3:
                    if (pizzaArmada.getIngredientes().size() >= 2 && pizzaArmada.getIngredientes().size() < 8) {
                        System.out.println("Selecciona el tipo de topping:");
                        System.out.println("1. Camarones");
                        System.out.println("2. Pez");
                        System.out.println("3. Hielo");
                        System.out.println("4. Piña");
                        System.out.println("5. Salchicha");
                        System.out.println("6. Calamar");
                        int opcionTopping = myScanner.nextInt();
                        Topping topping;
                        switch (opcionTopping) {
                            case 1:
                                topping = new Topping("Camarones", 2.0f, true, false);
                                break;
                            case 2:
                                topping = new Topping("Pez", 1.5f, false, false);
                                break;
                            case 3:
                                topping = new Topping("Hielo", 0.5f, false, true);
                                break;
                            case 4:
                                topping = new Topping("Piña", 1.0f, false, true);
                                break;
                            case 5:
                                topping = new Topping("Salchicha", 1.5f, true, false);
                                break;
                            case 6:
                                topping = new Topping("Calamar", 2.0f, false, false);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                topping = null;
                        }
                        if (topping != null) {
                            pizzaArmada.agregarIngrediente(topping);
                        }
                    } else {
                        System.out.println("La pizza debe tener al menos una base y una salsa antes de agregar toppings, o ya tiene el máximo de ingredientes.");
                    }
                    break;
                case 4:
                    pizzaArmada.quitarIngrediente();
                    break;
                case 5:

                    mostrarOrdenActual();
                    break;
                case 6:
                    entregarOrden();
                    ensamblando = false;
                    pizzaArmada = null;
                    break;
                case 7:
                    ensamblando = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

    public boolean compararPizzas(Pizza pizza1, Pizza pizza2) {
        if (pizza1.getIngredientes().size() != pizza2.getIngredientes().size()) {
            return false;
        }
        for (int i = 0; i < pizza1.getIngredientes().size(); i++) {
            String nombre1 = pizza1.getIngredientes().get(i).getNombre();
            String nombre2 = pizza2.getIngredientes().get(i).getNombre();
            if (!nombre1.equals(nombre2)) {
                return false;
            }
        }
        return true;
    }

    public void entregarOrden() {
        Pizza pizzaObjetivo = cocina.getordenActual().getPizzas().get(0);
        if (compararPizzas(pizzaObjetivo, pizzaArmada)) {
            System.out.println("La pizza armada esta correcta :D");
            cocina.entregarOrden();
            pizzaArmada = null;
        } else {
            System.out.println("La pizza armada no coincide con la orden. >:T");
        }
    }

    public void mostrarOrdenActual() {
    if (cocina.getordenActual() != null) {
        System.out.println(cocina.getordenActual().describirOrden());
    } else {
        System.out.println("No hay una orden en proceso.");
        }
    }

}    
    


