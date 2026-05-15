public abstract class Ingrediente {

    private String nombre;
    private float precio;

    public Ingrediente(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public abstract void preparar();

    public abstract String describir();
}
