/**
 * ARCHIVO: SistemaGestion.java
 * PROPÓSITO: Aplicación para la gestión académica y control de notas de estudiantes.
 * AUTOR: Carlos Quezada
 * FECHA: Octubre 2026
 * DESCRIPCIÓN: Clase con múltiples métodos de cálculo, formateo de datos
 *              y un menú interactivo por consola en el método principal.
 */



// Clase que representa la entidad del Estudiante
class Estudiante {
    // Atributos de la clase
    public String matricula;     // Código de identificación único
    public String nombre;        // Nombre completo del alumno
    public String carrera;       // Programa de estudios actual
    public double nota1;         // Calificación del primer parcial
    public double nota2;         // Calificación del segundo parcial
    public double nota3;         // Calificación del tercer parcial
    public int asistencias;      // Contador inicial de clases asistidas
    public final int totalClases = 20; // Total de clases programadas en el periodo (Constante)

    /**
     * Constructor para inicializar los atributos del estudiante.
     */
    public Estudiante(String matricula, String nombre, String carrera, double nota1, double nota2, double nota3) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.asistencias = 0; // Inicia en cero por defecto
    }

    /**
     * Suma asistencias validando que no superen el límite del periodo académico.
     */
    public void registrarAsistencia(int cantidad) {
        if (cantidad > 0 && (this.asistencias + cantidad) <= this.totalClases) {
            this.asistencias += cantidad;
            System.out.println("   Se registraron " + cantidad + " asistencias para " + this.nombre + ".");
        } else {
            System.out.println("❌ Error: La cantidad excede el límite de " + this.totalClases + " clases.");
        }
    }

    /**
     * Calcula el promedio aritmético simple de los tres parciales.
     */
    public double calcularPromedio() {
        double promedio = (this.nota1 + this.nota2 + this.nota3) / 3.0;
        return Math.round(promedio * 100.0) / 100.0; // Redondeo a 2 decimales
    }

    /**
     * Calcula el porcentaje de asistencia del alumno.
     */
    public double calcularPorcentajeAsistencia() {
        double porcentaje = ((double) this.asistencias / this.totalClases) * 100.0;
        return Math.round(porcentaje * 100.0) / 100.0;
    }

    /**
     * Determina la condición final evaluando notas y asistencias de forma estricta.
     */
    public String determinarEstadoAcademico() {
        double promedioFinal = this.calcularPromedio();
        double porcentajeAsist = this.calcularPorcentajeAsistencia();

        if (promedioFinal >= 70.0 && porcentajeAsist >= 80.0) {
            return "APROBADO";
        } else if (promedioFinal >= 50.0 && promedioFinal < 70.0) {
            return "EXAMEN DE REPARACIÓN";
        } else {
            return "REPROBADO";
        }
    }

    /**
     * Imprime en pantalla una boleta de calificaciones organizada de forma visual.
     */
    public void mostrarReporteDetallado() {
        double promedio = this.calcularPromedio();
        double porcentajeAsist = this.calcularPorcentajeAsistencia();
        String estado = this.determinarEstadoAcademico();

        System.out.println("\n=============================================");
        System.out.println("         BOLETA ACADÉMICA - " + this.matricula);
        System.out.println("=============================================");
        System.out.println("Estudiante: " + this.nombre);
        System.out.println("Carrera:    " + this.carrera);
        System.out.println("---------------------------------------------");
        System.out.println("Nota Parcial 1: " + this.nota1);
        System.out.println("Nota Parcial 2: " + this.nota2);
        System.out.println("Nota Parcial 3: " + this.nota3);
        System.out.println("---------------------------------------------");
        System.out.println("Promedio Final: " + promedio + " / 100");
        System.out.println("Asistencia:     " + this.asistencias + "/" + this.totalClases + " (" + porcentajeAsist + "%)");
        System.out.println("Condición:      [" + estado + "]");
        System.out.println("=============================================\n");
    }
}
