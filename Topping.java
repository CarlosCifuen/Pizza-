public class Topping extends Ingrediente {

    private boolean frio;
    private boolean dulce;

    public Topping(String nombre, float precio, boolean frio, boolean dulce) {
        super(nombre, precio);
        this.frio = frio;
        this.dulce = dulce;
    }

    public boolean isFrio() {
        return frio;
    }

    public boolean isDulce(){
        return dulce;
    }

    @Override 
    public void preparar() {
        System.out.println("Preparando el topping:" + getNombre() + ". \n es frio: " + frio + "\n es dulce: " + dulce);
    }

    @Override
    public String describir() {
        return "Topping: " + getNombre() + "\nPrecio: $" + getPrecio() + "\nFrio: " + frio + "\nDulce: " + dulce + "\n";
    }
}

