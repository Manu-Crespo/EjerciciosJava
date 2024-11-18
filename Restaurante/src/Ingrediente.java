class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadDeMedida;

    // Constructor
    public Ingrediente(String nombre, double cantidad, String unidadDeMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
    }
    // Metodos Get
    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    @Override
    public String toString() {
        return nombre + " " + cantidad + " " + unidadDeMedida;
    }
}
