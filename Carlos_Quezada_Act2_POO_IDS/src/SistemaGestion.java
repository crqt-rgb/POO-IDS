import java.util.Scanner;
/**
 * ARCHIVO: SistemaGestion.java
 * CLASE PRINCIPAL (Entry Point)
 * DESCRIPCIÓN: Instancia objetos de las clases derivadas y ofrece un menú 
 * interactivo en consola para probar la herencia y sus métodos.
 */
public class SistemaGestion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("--- Inicializando Sistema Académico (Aplicando Herencia) ---");

        // 1. INSTANCIACIÓN DE OBJETOS DE LAS SUBCLASES
        // Alumnos de Ingeniería (Subclase EstudianteIngenieria)
        EstudianteIngenieria alumno1 = new EstudianteIngenieria("STU-2026-A", "Oriatna Martínez", "Ingeniería Mecánica", 85.0, 90.0, 78.0, true);
        EstudianteIngenieria alumno2 = new EstudianteIngenieria("STU-2026-B", "Carlos Quezada", "Ingeniería Química", 60.0, 55.0, 68.0, false);
        
        // Alumno de Arte (Subclase EstudianteArte)
        EstudianteArte alumno3 = new EstudianteArte("STU-2026-C", "Montserrat Martínez", "Licenciatura en Arte", 90.0, 85.0, 96.0, 95.0);
        
        // 2. PRUEBA DE MÉTODOS HEREDADOS DE LA CLASE BASE
        // Todos los objetos heredan el método 'registrarAsistencia' de la clase 'Estudiante'
        alumno1.registrarAsistencia(18);
        alumno2.registrarAsistencia(12);
        alumno3.registrarAsistencia(20);

        // 3. BUCLE Y MENÚ INTERACTIVO EN CONSOLA
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\n--- MENÚ DE CONTROL ACADÉMICO ---");
            System.out.println("1. Ver boleta de Oriatna Martínez (Ingeniería - Lab Aprobado)");
            System.out.println("2. Ver boleta de Carlos Quezada (Ingeniería - Lab Pendiente)");
            System.out.println("3. Ver boleta de Montserrat Martínez (Arte - Ponderación Artística)");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción (1-4): ");

            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    // Llama al método polimórfico 'mostrarReporteDetallado' sobrescrito en EstudianteIngenieria
                    alumno1.mostrarReporteDetallado();
                    break;

                case "2":
                    // Demostración de uso de método exclusivo de la subclase
                    System.out.println("\n[Sugerencia] Carlos tiene el laboratorio pendiente.");
                    alumno2.mostrarReporteDetallado();
                    break;

                case "3":
                    // Llama al método sobrescrito en EstudianteArte (con promedio ponderado)
                    alumno3.mostrarReporteDetallado();
                    break;

                case "4":
                    System.out.println("\nCerrando el sistema académico. ¡Hasta pronto!");
                    ejecutando = false;
                    break;

                default:
                    System.out.println("❌ Opción no válida. Por favor, intente de nuevo.\n");
                    break;
            }
        }
        teclado.close(); // Liberación del recurso Scanner
    }
}