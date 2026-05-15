import java.util.ArrayList;

public class Pizza {

    private ArrayList<Ingrediente> ingredientes;
    private EstadoPizza estado;

    public Pizza() {
        this.ingredientes = new ArrayList<>();
        this.estado = EstadoPizza.ESPERANDO;
    }

    public ArrayList<Ingrediente> getIngredientes(){
        return ingredientes;
    }

    public EstadoPizza getEstado() {
        return estado;
    }

    public void setEstado(EstadoPizza estado) {
        this.estado = estado;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public float calcularPrecio() {
        float precioTotal = 0;
        for (Ingrediente ingrediente : ingredientes) {
            precioTotal += ingrediente.getPrecio();
        }
        return precioTotal;
    }

}
