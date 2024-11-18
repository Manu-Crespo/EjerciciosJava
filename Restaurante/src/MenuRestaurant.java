import java.util.ArrayList;
import java.util.Scanner;
public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        System.out.print("Ingrese la cantidad de platos que desea cargar: ");
        int cantidadPlatos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("\n--- Plato " + (i + 1) + " ---");
            System.out.print("Ingrese el nombre del plato: ");
            String nombrePlato = scanner.nextLine();

            System.out.print("Ingrese el precio del plato: ");
            double precioPlato = Double.parseDouble(scanner.nextLine());

            System.out.print("Es una bebida? (true/false): ");
            boolean esBebida = Boolean.parseBoolean(scanner.nextLine());

            // Crear el objeto Plato
            Plato plato = new Plato(nombrePlato, precioPlato, esBebida);

            // Si no es una bebida, agregar ingredientes
            if (!esBebida) {
                System.out.print("Ingrese la cantidad de ingredientes: ");
                int cantidadIngredientes = Integer.parseInt(scanner.nextLine());

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.println("\n--- Ingrediente " + (j + 1) + " ---");
                    System.out.print("Nombre del ingrediente: ");
                    String nombreIngrediente = scanner.nextLine();

                    System.out.print("Cantidad: ");
                    double cantidad = Double.parseDouble(scanner.nextLine());

                    System.out.print("Unidad de medida: ");
                    String unidad = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidad);
                    plato.agregarIngrediente(ingrediente);
                }
            }

            // Agregar el plato al menú
            platosMenu.add(plato);
        }

        // Mostrar el menú completo
        System.out.println("\n--- MENÚ ---");
        for (Plato plato : platosMenu) {
            System.out.println(plato);
        }

        scanner.close();
    }
}