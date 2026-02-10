import PatioDeContenedores.Vista.PatioDContenedores;
import Recepcion.ModuloARecepcion;
import estructurasDeDatos.SubMenu;
import rutaDeDistribucion.Rutas;

import java.util.Scanner;

public class MenuPrincipal {

    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            System.out.println(
                    "PUERTO PROGRESO LOGIC SYSTEM v1.0 - GESTIÓN PORTUARIA\n" +
                    "======================================================\n" +
                    "[1] ZONA DE RECEPCIÓN (Colas - Camiones)\n" +
                    "[2] PATIO DE CONTENEDORES (Pilas - Almacenamiento)\n" +
                    "[3] LOGÍSTICA Y RUTAS (Listas Dobles - Distribución)\n" +
                    "[4] REPORTE GENERAL\n" +
                    "[5] SALIR\n" +
                    "Seleccione una opción:"
            );
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1 -> new ModuloARecepcion().menuRecepcion(scanner);
                case 2 -> new PatioDContenedores().menuRecepcion(scanner);
                case 3 -> new Rutas().menuRecepcion(scanner);
                case 4 -> System.out.println("Reporte generado");
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida");
            }
        }while (opcion != 5);
    }
}
