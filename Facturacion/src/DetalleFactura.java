public class DetalleFactura {
    private String codigoArticulo;
    private String nombreArticulo;
    private int cantidad;
    private double precioUnitario;
    private double descuentoItem;
    private double subTotal;

    public DetalleFactura(String codigoArticulo, String nombreArticulo, int cantidad, double precioUnitario, double descuentoItem, double subTotal) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuentoItem = descuentoItem;
        this.subTotal = subTotal;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getDescuentoItem() {
        return descuentoItem;
    }

    public double getSubTotal() {
        return subTotal;
    }
}