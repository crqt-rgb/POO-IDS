
/**
 * ARCHIVO: EstudianteIngenieria.java
 * CLASE DERIVADA (Subclase)
 * HERENCIA: Extiende de 'Estudiante' reutilizando código y adaptándolo a ingeniería.
 */
public class EstudianteIngenieria extends Estudiante {
    
    // ATRIBUTO ÚNICO de esta subclase
    private boolean proyectoLaboratorioAprobado;

    /**
     * CONSTRUCTOR: Utiliza 'super(...)' para invocar el constructor de la clase base
     * e inicializar los atributos heredados, además de asignar el atributo propio.
     */
    public EstudianteIngenieria(String matricula, String nombre, String carrera, double nota1, double nota2, double nota3, boolean proyectoLabAprobado) {
        super(matricula, nombre, carrera, nota1, nota2, nota3); // Reutilización de constructor base
        this.proyectoLaboratorioAprobado = proyectoLabAprobado;
    }

    /**
     * SOBREESCRITURA (@Override): Modifica el estado académico para agregar la regla estricta
     * de ingeniería (exigir la aprobación del laboratorio).
     */
    @Override
    public String determinarEstadoAcademico() {
        String estadoBase = super.determinarEstadoAcademico(); // Llamada a método de la clase base
        if (estadoBase.equals("APROBADO") && !this.proyectoLaboratorioAprobado) {
            return "RETENIDO (Falta Proyecto de Laboratorio)";
        }
        return estadoBase;
    }

    /**
     * MÉTODO EXCLUSIVO de EstudianteIngenieria: Permite actualizar el estatus del laboratorio.
     */
    public void actualizarEstatusLaboratorio(boolean nuevoEstatus) {
        this.proyectoLaboratorioAprobado = nuevoEstatus;
        System.out.println("⚙️ Estatus de laboratorio actualizado para el ing. " + this.nombre);
    }

    /**
     * SOBREESCRITURA (@Override): Extiende el reporte base añadiendo la información del laboratorio.
     */
    @Override
    public void mostrarReporteDetallado() {
        super.mostrarReporteDetallado(); // Llama al reporte de la clase base
        System.out.println(" Requisito Lab: " + (this.proyectoLaboratorioAprobado ? "APROBADO ✅" : "PENDIENTE ❌"));
        System.out.println("=============================================\n");
    }
}