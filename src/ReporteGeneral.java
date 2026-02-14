import Recepcion.Camion;
import estructurasDeDatos.SubMenu;
import rutaDeDistribucion.Rutas;

import java.util.Scanner;

public class ReporteGeneral implements SubMenu {
    private final MenuPrincipal menuPrincipal;

    public ReporteGeneral(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    @Override
    public void menuRecepcion(Scanner sc) {
        System.out.println("[ESTADO DE RECEPCIÓN]:\n");
        if(menuPrincipal.getModuloARecepcion() != null) {
            if(!menuPrincipal.getModuloARecepcion().isEmpty()){
                System.out.println(">> Camiones en espera: "+ menuPrincipal.getModuloARecepcion().getCamionesEnEspera() +"\n");
                System.out.println(">> Proximo en turno: Placa [" + menuPrincipal.getModuloARecepcion().verProximoCamion().getPlaca() + "]");
            }else{
                System.out.println(">> No hay camiones en espera");
            }
        }else{
            System.out.println(">> Módulo no inicializado");
        }


        System.out.println("\n[ESTADO DE INVENTARIO]:");
        if (menuPrincipal.getPatioDContenedores() != null) {
            menuPrincipal.getPatioDContenedores().imprimirEstadoPatio();
        } else {
            System.out.println("\n>> Módulo no inicializado");
        }

        System.out.println("\n[ESTADO DE LOGÍSTICA]:");
        if(menuPrincipal.getRutas() != null) {
            int activas = menuPrincipal.getRutas().getRutasActivas();
            System.out.println(">> Rutas activas:"+ activas +"\n");
            if(activas > 0) menuPrincipal.getRutas().imprimirRutasActivas();
        }else{
            System.out.println("\n>> Módulo no inicializado");
        }


        System.out.println("Presione cualquier tecla para volver al menú principal...");
        sc.nextLine();
    }

}