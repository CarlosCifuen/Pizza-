public class Base extends Ingrediente {

    private String coccion;

    public Base(String nombre, float precio, String coccion) {
        super(nombre, precio);
        this.coccion = coccion;
    }

    public String getCoccion() {
        return coccion;
    }

    public void setCoccion(String coccion) {
        this.coccion = coccion;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando la base: " + getNombre() + " \ncon cocción: " + coccion);  
    }

    @Override
    public String describir() {
        return "Base: " + getNombre() + "\nPrecio: $" + getPrecio() + "\nCocción: " + coccion;
    }

}
