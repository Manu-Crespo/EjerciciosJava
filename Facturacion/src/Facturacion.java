import java.util.ArrayList;
import java.util.Scanner;

public class Facturacion {
    private static ArrayList<Articulo> articulos = new ArrayList<>();

    public static void main(String[] args) {
        // Llenar la lista de artículos
        llenarArrayListDeArticulos();

        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        // Solicitar los datos de la factura
        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFechaFactura(scanner.nextLine());

        System.out.print("Ingrese el número de la factura: ");
        factura.setNumeroFactura(Long.parseLong(scanner.nextLine()));

        System.out.print("Ingrese el nombre del cliente: ");
        factura.setCliente(scanner.nextLine());

        while (true) {
            // Mostrar el menú de artículos antes de solicitar el código
            menuDeArticulosparaFactura();

            System.out.print("Ingrese el código del artículo (o 'salir' para terminar): ");
            String codigo = scanner.nextLine();
            if (codigo.equalsIgnoreCase("salir")) break;

            Articulo articulo = buscarArticulo(Long.parseLong(codigo));
            if (articulo == null) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            double precioUnitario = articulo.getPrecio();
            double descuento = cantidad > 5 ? precioUnitario * 0.1 : 0;
            double subTotal = (precioUnitario - descuento) * cantidad;

            DetalleFactura detalle = new DetalleFactura(
                    String.valueOf(articulo.getCodigo()),
                    articulo.getDescripcion(),
                    cantidad,
                    precioUnitario,
                    descuento,
                    subTotal
            );
            factura.agregarDetalle(detalle);
        }

        factura.calcularMontoTotal();

        // Mostrar los datos de la factura
        System.out.println("\nFACTURA:");
        System.out.println("Fecha: " + factura.getFechaFactura());
        System.out.println("Número: " + factura.getNumeroFactura());
        System.out.println("Cliente: " + factura.getCliente());
        System.out.println("Detalles:");
        System.out.printf("%-10s %-20s %-10s %-15s %-10s %-10s\n", "Código", "Nombre", "Cantidad", "Precio Unitario", "Descuento", "Subtotal");

        for (DetalleFactura detalle : factura.getDetallesFactura()) {
            System.out.printf("%-10s %-20s %-10d %-15.2f %-10.2f %-10.2f\n",
                    detalle.getCodigoArticulo(),
                    detalle.getNombreArticulo(),
                    detalle.getCantidad(),
                    detalle.getPrecioUnitario(),
                    detalle.getDescuentoItem(),
                    detalle.getSubTotal()
            );
        }

        System.out.println("Total: $" + factura.getTotalCalculadoFactura());
        scanner.close();
    }

    // Método para llenar el ArrayList de artículos
    private static void llenarArrayListDeArticulos() {
        articulos.add(new Articulo(101, "Leche", 25));
        articulos.add(new Articulo(102, "Gaseosa", 30));
        articulos.add(new Articulo(103, "Fideos", 15));
        articulos.add(new Articulo(104, "Arroz", 28));
        articulos.add(new Articulo(105, "Vino", 120));
        articulos.add(new Articulo(106, "Manteca", 20));
        articulos.add(new Articulo(107, "Lavandina", 18));
        articulos.add(new Articulo(108, "Detergente", 46));
        articulos.add(new Articulo(109, "Jabón en Polvo", 96));
        articulos.add(new Articulo(110, "Galletas", 60));
    }

    // Método para buscar un artículo por código
    private static Articulo buscarArticulo(long codigo) {
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }
        return null;
    }

    // Método para mostrar el menú de artículos
    private static void menuDeArticulosparaFactura() {
        System.out.println("\n--- LISTA DE ARTÍCULOS DISPONIBLES ---");
        System.out.printf("%-10s %-20s %-10s\n", "Código", "Descripción", "Precio");
        for (Articulo articulo : articulos) {
            System.out.printf("%-10d %-20s %-10.2f\n", articulo.getCodigo(), articulo.getDescripcion(), articulo.getPrecio());
        }
        System.out.println();
    }
}
