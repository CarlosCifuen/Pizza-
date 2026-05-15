import java.util.ArrayList;
import java.util.Random;


public class GenOrdenes {

private Random random;
private Cocina cocina;

public GenOrdenes(Cocina cocina) {
    this.random = new Random();
    this.cocina = cocina;    
    }

        public Orden generarOrden() {
        // nombres random de clientes pingüinos :)
        String[] nombres = {"Tux", "Wheezy", "Skipper", "Kowalski", "Rico", "Pingu", "Pablo"};
        String nombreRandom = nombres[random.nextInt(nombres.length)];
        
        Orden orden = new Orden(nombreRandom, cocina.getOrdenes().size() + 1);
        
        int cantidadPizzas = random.nextInt(3) + 1; // entre 1 y 3 pizzas
        for (int i = 0; i < cantidadPizzas; i++) {
            orden.agregarPizza(generarPizza());
        }
        return orden;
    }

    public Pizza generarPizza() {
        Pizza pizza = new Pizza();
        
        // Base
        String[] bases = {"Base Suave", "Base Media", "Base Crujiente"};
        String baseRandom = bases[random.nextInt(bases.length)];
        float precioBase = baseRandom.equals("Base Suave") ? 4.0f : 5.0f;
        pizza.agregarIngrediente(new Base(baseRandom, precioBase, baseRandom.split(" ")[1]));
        
        // Salsa
        boolean salsaPicante = random.nextBoolean();
        pizza.agregarIngrediente(new Salsa(salsaPicante ? "Salsa Picante" : "Salsa Normal", 1.0f, salsaPicante));
        
        // Toppings
        String[] toppings = {"Camarones", "Pez", "Hielo", "Piña", "Salchicha", "Calamar"};
        float[] precios = {2.0f, 1.5f, 0.5f, 1.0f, 1.5f, 2.0f};
        boolean[] frio = {true, false, false, false, true, false};
        boolean[] dulce = {false, false, true, true, false, false};

        int cantidadToppings = random.nextInt(6) + 1; // entre 1 y 6
        ArrayList<Integer> indices = new ArrayList<>();

        while (indices.size() < cantidadToppings) {
            int indice = random.nextInt(toppings.length);
            if (!indices.contains(indice)) { // evitar repetidos
                indices.add(indice);
                pizza.agregarIngrediente(new Topping(
                    toppings[indice], 
                    precios[indice], 
                    frio[indice], 
                    dulce[indice]
                ));
            }
        }
 
        return pizza;
    }    
}