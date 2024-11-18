import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Alumno {
    private String nombreCompleto;
    private ArrayList<Nota> notas;

    // Constructor
    public Alumno(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        this.notas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    // Método para agregar notas al alumno
    public void agregarNotas() {
        int cantidadNotas = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántas notas ingresará para " + nombreCompleto + "?"));

        // Validar que ingrese al menos una nota
        while (cantidadNotas < 1) {
            JOptionPane.showMessageDialog(null, "Debe ingresar al menos 1 nota.");
            cantidadNotas = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántas notas ingresará para " + nombreCompleto + "?"));
        }

        for (int i = 0; i < cantidadNotas; i++) {
            String materia = JOptionPane.showInputDialog("Nombre de la materia:");
            double notaExamen = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno: "));
            Nota nota = new Nota(materia, notaExamen);
            notas.add(nota);
        }
    }

    // Método para calcular el promedio de las notas
    public double calcularPromedio() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return notas.isEmpty() ? 0 : suma / notas.size();
    }

    // Método para mostrar los datos del alumno
    public void mostrarDatos() {
        System.out.println("\nAlumno: " + nombreCompleto);
        System.out.println("Notas:");
        for (Nota nota : notas) {
            System.out.println(nota);
        }
        System.out.printf("Promedio: %.2f%n", calcularPromedio());
    }
}

