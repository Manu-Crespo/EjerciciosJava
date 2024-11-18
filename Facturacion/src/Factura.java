import java.util.ArrayList;

public class Factura {
    private String fechaFactura;
    private long numeroFactura;
    private double totalCalculadoFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura;

    public Factura() {
        detallesFactura = new ArrayList<>();
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        detallesFactura.add(detalle);
    }

    public ArrayList<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void calcularMontoTotal() {
        totalCalculadoFactura = 0;
        for (DetalleFactura detalle : detallesFactura) {
            totalCalculadoFactura += detalle.getSubTotal();
        }
    }

    public double getTotalCalculadoFactura() {
        return totalCalculadoFactura;
    }
}