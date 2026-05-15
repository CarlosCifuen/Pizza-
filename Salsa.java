public class Salsa extends Ingrediente {

    private boolean picante;

    public Salsa(String nombre, float precio, boolean picante) {
        super(nombre, precio);
        this.picante = picante;
    }

    public boolean isPicante() {
        return picante;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando la salsa: " + getNombre() + "\nEs picante: " + picante);  
    }

    @Override
    public String describir() {
        return "Salsa: " + getNombre() + "\nPrecio: $" + getPrecio() + "\nPicante: " + picante;
    }

}
