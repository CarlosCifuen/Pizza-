import java.util.Stack;

public class Pizza {

    private Stack<Ingrediente> ingredientes;
    private EstadoPizza estado;

    public Pizza() {
        this.ingredientes = new Stack<>();
        this.estado = EstadoPizza.ESPERANDO;
    }

    public Stack<Ingrediente> getIngredientes(){
        return ingredientes;
    }

    public EstadoPizza getEstado() {
        return estado;
    }

    public void setEstado(EstadoPizza estado) {
        this.estado = estado;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        if (ingredientes.size() < 8) { 
            ingredientes.push(ingrediente);
        } else {
            System.out.println("No se pueden agregar más ingredientes a la pizza.");
        }
    }

    public void quitarIngrediente() {
        if (!ingredientes.isEmpty()) {
            ingredientes.pop();
        } else {
            System.out.println("No hay ingredientes para quitar.");
        }
    }

    public float calcularPrecio() {
        float precioTotal = 0;
        for (Ingrediente ingrediente : ingredientes) {
            precioTotal += ingrediente.getPrecio();
        }
        return precioTotal;
    }

    public String describirPizza() {
        String descripcion = "Pizza con los siguientes ingredientes:\n";
        for (Ingrediente ingrediente : ingredientes) {
            descripcion += ingrediente.describir() + "\n";
        }
        descripcion += "Precio total: $" + calcularPrecio();
        return descripcion;
    }
}
