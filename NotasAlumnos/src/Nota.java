public class Nota {
    private String catedra;
    private double notaExamen;

    // Constructor
    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    // Getters
    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    // Método para mostrar la información de la nota
    @Override
    public String toString() {
        return "Materia: " + catedra + " - Nota: " + notaExamen;
    }
}

