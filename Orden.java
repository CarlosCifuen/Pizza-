import java.util.ArrayList;

public class Orden {

    private String nombreCliente;
    private int numeroOrden;
    private ArrayList<Pizza> pizzas;
    private EstadoOrden estado;

    public Orden(String nombreCliente, int numeroOrden) {
        this.nombreCliente = nombreCliente;
        this.numeroOrden = numeroOrden;
        this.pizzas = new ArrayList<>();
        this.estado = EstadoOrden.EN_ESPERA;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public int getCantidadPizzas() {
        return pizzas.size();
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public void agregarPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public float calcularTotal() {
        float total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.calcularPrecio();
        }
        return total;
    }  
    
    public String describirOrden() {
        String descripcion = "Orden #" + numeroOrden + " para " + nombreCliente + "\nEstado: " + estado + "\n";
        for (Pizza pizza : pizzas) {
            descripcion += pizza.describirPizza() + "\n";
        }
        descripcion += "Total a pagar: $" + calcularTotal();
        return descripcion;
    }
}
