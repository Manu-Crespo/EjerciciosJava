import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CargaNotas {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();

        // Pedir la cantidad de alumnos a ingresar
        int cantidadAlumnos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos alumnos desea ingresar?"));

        for (int i = 0; i < cantidadAlumnos; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno número " + (i + 1) + ":");

            // Crear una nueva instancia de Alumno
            Alumno alumno = new Alumno(nombre);
            alumno.agregarNotas();
            alumnos.add(alumno);
        }

        // Mostrar los datos de todos los alumnos
        System.out.println("\n--- INFORMACIÓN DE LOS ALUMNOS ---");
        for (Alumno alumno : alumnos) {
            alumno.mostrarDatos();
        }
    }
}
