import java.util.ArrayList;
class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    // Constructor
    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    // Metodos Get
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEsBebida() {
        return esBebida;
    }

    // Metodo para agregar ingredientes
    public void agregarIngrediente(Ingrediente ingrediente) {
        if (!esBebida) {
            ingredientes.add(ingrediente);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreCompleto).append("\n");
        sb.append("Precio: $ ").append(precio).append("\n");
        if (!esBebida) {
            sb.append("Ingredientes:\n");
            for (Ingrediente ingrediente : ingredientes) {
                sb.append(ingrediente).append("\n");
            }
        }
        return sb.toString();
    }
}