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


    //Muestra el menu principal del sistema y redirige a los submenus correspondientes
    //Los cuales son Recepcion, Patio de contenedores, Logistica y Reporte general

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

    //Devuelve el modulo de recepcion para poder acceder a sus metodos
    public ModuloARecepcion getModuloARecepcion() {
        return moduloARecepcion;
    }

    //Devuelve la lista de rutas para poder acceder a sus metodos
    public ListaRutas getRutas() {
        return rutas;
    }

    //Devuelve el patio de contenedores para poder acceder a sus metodos
    public PatioDContenedores getPatioDContenedores() {
        return patioDContenedores;
    }
}
