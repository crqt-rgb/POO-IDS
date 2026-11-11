/**
 * ARCHIVO: EstudianteArte.java
 * CLASE DERIVADA (Subclase)
 * HERENCIA: Extiende de 'Estudiante' para modelar alumnos del área artística.
 */
public class EstudianteArte extends Estudiante {
    
    // ATRIBUTO ÚNICO de esta subclase
    private double calificacionExhibicion;

    /**
     * CONSTRUCTOR: Emplea 'super(...)' para inicializar los atributos heredados de la superclase.
     */
    public EstudianteArte(String matricula, String nombre, String carrera, double nota1, double nota2, double nota3, double calificacionExhibicion) {
        super(matricula, nombre, carrera, nota1, nota2, nota3);
        this.calificacionExhibicion = calificacionExhibicion;
    }

    /**
     * SOBREESCRITURA (@Override): Modifica el cálculo del promedio combinando 
     * las notas teóricas (80%) con la calificación de la exhibición artística (20%).
     */
    @Override
    public double calcularPromedio() {
        double promedioTeorico = (this.nota1 + this.nota2 + this.nota3) / 3.0;
        double promedioPonderado = (promedioTeorico * 0.80) + (this.calificacionExhibicion * 0.20);
        return Math.round(promedioPonderado * 100.0) / 100.0;
    }

    /**
     * MÉTODO EXCLUSIVO de EstudianteArte: Permite reevaluar la nota de exhibición artística.
     */
    public void evaluarExhibicion(double nuevaNotaExhibicion) {
         this.calificacionExhibicion = nuevaNotaExhibicion;
         System.out.println("🎨 Exhibición artística reevaluada para " + this.nombre);
     }
    

    /**
     * SOBREESCRITURA (@Override): Complementa el reporte detallado con el desglose artístico.
     */
    @Override
    public void mostrarReporteDetallado() {
        super.mostrarReporteDetallado(); // Hereda la estructura visual base
        System.out.println(" Nota Exhibición Artística: " + this.calificacionExhibicion);
        System.out.println("=============================================\n");
    }
}