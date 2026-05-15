import java.util.ArrayList;

public class Cocina {

    private ArrayList<Orden> ordenes;
    private Orden ordenActual;

    public Cocina() {
        this.ordenes = new ArrayList<>();
        this.ordenActual = null;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public ArrayList<Orden> hayOrdenesEnEspera() {
        ArrayList<Orden> ordenesEnEspera = new ArrayList<>();
        for (Orden orden : ordenes) {
            if (orden.getEstado() == EstadoOrden.EN_ESPERA) {
                ordenesEnEspera.add(orden);
            }
        }
        return ordenesEnEspera;
    }

    public boolean hayOrdenEnProceso() {
        for (Orden orden : ordenes) {
            if (orden.getEstado() == EstadoOrden.EN_PROCESO) {
                return true;
            }
        }
        return false;
    }

    public int numerodeOrdenesEnEspera() {
        int contador = 0;
        for (Orden orden : ordenes) {
            if (orden.getEstado() == EstadoOrden.EN_ESPERA) {
                contador++;
            }
        }
        return contador;
    }

    public Orden getordenActual() {
        return ordenActual;
    }

    public void almacenarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public void procesarOrden(Orden orden) {
        if (orden.getEstado() == EstadoOrden.EN_ESPERA) {
            orden.setEstado(EstadoOrden.EN_PROCESO);
            this.ordenActual = orden;
            System.out.println("Procesando orden #" + orden.getNumeroOrden() + " para " + orden.getNombreCliente());
        } else {
            System.out.println("La orden #" + orden.getNumeroOrden() + " no está en espera.");
        }
    }

    public void ensamblarPizza() {
        if (ordenActual != null && ordenActual.getEstado() == EstadoOrden.EN_PROCESO) {
            for (Pizza pizza : ordenActual.getPizzas()) {
              for (Ingrediente ingrediente : pizza.getIngredientes()) {
                ingrediente.preparar();
            }
        }
        } else {
            System.out.println("No hay una orden en proceso para ensamblar la pizza.");
        }
    }

    public void entregarOrden() {
        if (ordenActual != null && ordenActual.getEstado() == EstadoOrden.EN_PROCESO) {
            ordenActual.setEstado(EstadoOrden.COMPLETADA);
            System.out.println("Orden #" + ordenActual.getNumeroOrden() + " entregada.");
            this.ordenActual = null;
        } else {
            System.out.println("No hay una orden en proceso para entregar.");
        }
    }

}
