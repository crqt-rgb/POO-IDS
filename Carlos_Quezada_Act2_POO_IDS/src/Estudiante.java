/**
 * ARCHIVO: Estudiante.java
 * CLASE BASE (Superclase)
 * DESCRIPCIÓN: Define los atributos, constructores y métodos comunes (como cálculo 
 * de promedios, asistencias y reportes) que heredarán todas las clases derivadas.
 */
public class Estudiante {
    // ATRIBUTOS BASE: Compartidos por cualquier tipo de estudiante mediante herencia
    protected String matricula;     // Identificador único
    protected String nombre;        // Nombre completo
    protected String carrera;       // Carrera cursada
    protected double nota1, nota2, nota3; // Calificaciones parciales
    protected int asistencias;      // Conteo de clases asistidas
    public final int totalClases = 20; // Constante del periodo

    /**
     * Constructor de la clase base para inicializar los datos generales.
     */
    public Estudiante(String matricula, String nombre, String carrera, double nota1, double nota2, double nota3) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.asistencias = 0; // Inicializa por defecto
    }

    /**
     * Método heredable para registrar asistencias con validación de límite.
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
     * Método base para calcular el promedio aritmético. 
     * Puede ser sobrescrito (@Override) en las clases derivadas si tienen reglas distintas.
     */
    public double calcularPromedio() {
        double promedio = (this.nota1 + this.nota2 + this.nota3) / 3.0;
        return Math.round(promedio * 100.0) / 100.0;
    }

    /**
     * Calcula el porcentaje de asistencia en base a las clases totales.
     */
    public double calcularPorcentajeAsistencia() {
        double porcentaje = ((double) this.asistencias / this.totalClases) * 100.0;
        return Math.round(porcentaje * 100.0) / 100.0;
    }

    /**
     * Determina el estado académico base considerando notas y asistencias.
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
     * Despliega la boleta base en consola.
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
    }
}