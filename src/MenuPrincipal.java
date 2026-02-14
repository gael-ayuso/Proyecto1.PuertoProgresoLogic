import PatioDeContenedores.Vista.PatioDContenedores;
import Recepcion.ModuloARecepcion;
import estructurasDeDatos.SubMenu;
import rutaDeDistribucion.ListaRutas;
import rutaDeDistribucion.Rutas;

import java.util.Scanner;

public class MenuPrincipal {

    private ModuloARecepcion moduloARecepcion;
    private PatioDContenedores patioDContenedores;
    private ListaRutas rutas;


    public void menuPrincipal() {
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
                case 1 -> {
                    if(moduloARecepcion == null) {
                        moduloARecepcion = new ModuloARecepcion();
                    }
                    moduloARecepcion.menuRecepcion(scanner);
                }
                case 2 -> {
                    if(patioDContenedores == null) {
                        patioDContenedores = new PatioDContenedores();
                    }
                    patioDContenedores.menuRecepcion(scanner);
                }
                case 3 -> {
                    if(rutas == null) {
                        rutas = new ListaRutas();
                    }
                    rutas.menuRecepcion(scanner);
                }
                case 4 -> new ReporteGeneral(this).menuRecepcion(scanner);
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida");
            }
        }while (opcion != 5);
    }

    public ModuloARecepcion getModuloARecepcion() {
        return moduloARecepcion;
    }

    public ListaRutas getRutas() {
        return rutas;
    }


    public PatioDContenedores getPatioDContenedores() {
        return patioDContenedores;
    }
}
