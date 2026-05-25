import java.util.ArrayList;

public class Cocina {

    private ArrayList<Orden> ordenes;
    private Orden ordenActual;
    private float DineroAcumulado;

    public Cocina() {
        this.ordenes = new ArrayList<Orden>();
        this.ordenActual = null;
        this.DineroAcumulado = 0;
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
        ordenActual = (ordenes.get(0));
        procesarOrden(ordenActual);
        return ordenActual;
    }

    public void almacenarOrden(Orden neworden) {
        ordenes.add(neworden);
    }

    public void procesarOrden(Orden orden) {
        ordenActual.setEstado(EstadoOrden.EN_PROCESO);
    }

    public void entregarOrden() {
        if (ordenActual != null && ordenActual.getEstado() == EstadoOrden.EN_PROCESO) {
            ordenActual.setEstado(EstadoOrden.COMPLETADA);
            System.out.println("Orden #" + ordenActual.getNumeroOrden() + " entregada.");
            DineroAcumulado += ordenActual.calcularTotal();
            ordenes.remove(ordenActual);
            ordenActual = null;
            System.out.println("Dinero acumulado: $" + DineroAcumulado);
        } else {
            System.out.println("No hay una orden en proceso para entregar.");
        }
    }

    public float getDineroAcumulado() {
        return DineroAcumulado;
    }

}