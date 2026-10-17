import java.util.Scanner;

// Clase Principal contenedora del programa ejecutable
public class Gestion {
    
    // Método de ejecución principal (Entry Point)
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("--- Inicializando Base de Datos Académica en Java ---");

        // 1. Instanciación de Objetos Estudiante
        Estudiante alumno1 = new Estudiante("STU-2026-A", "Oriatna Martínez", "Ingeniería Mecánica", 85.0, 90.0, 78.0);
        Estudiante alumno2 = new Estudiante("STU-2026-B", "Carlos Quezada", "Ingeniería Quimíca", 60.0, 55.0, 68.0);
        Estudiante alumno3 = new Estudiante("STU-2026-C", "Montserrat Martínez", "Licenciatura en Arte", 90.0, 85.0,96.0);
        
        // Preconfiguración inicial de asistencias a través de los métodos del objeto
        alumno1.registrarAsistencia(18);
        alumno2.registrarAsistencia(12);
        alumno3.registrarAsistencia(20);

        // 2. Bucle y Menú Interactivo en Consola
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("--- SISTEMA DE CONTROL DE ESTUDIANTES ---");
            System.out.println("1. Ver boleta de Oriatna Martínez");
            System.out.println("2. Ver boleta de Carlos Quezada");
            System.out.println("3. Ver boleta de Monserrat Martínez");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción (1-4): ");

            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    // Llamado al método de despliegue de datos
                    alumno1.mostrarReporteDetallado();
                    break;

                case "2":
                    // Llamado al método de despliegue de datos
                    alumno2.mostrarReporteDetallado();
                    break;

                case "3":
                	// Llamado al método de despliegue de datos
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
