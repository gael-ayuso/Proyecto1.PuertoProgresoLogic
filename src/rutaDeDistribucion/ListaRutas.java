package rutaDeDistribucion;

import estructurasDeDatos.SubMenu;
import estructurasDeDatos.listas.ListaSimple;
import estructurasDeDatos.listas.Nodo;

import java.util.Scanner;

public class ListaRutas implements SubMenu {

    ListaSimple listaRutas = new ListaSimple();
    int contadorRutas = 0;

    @Override
    public void menuRecepcion(Scanner sc) {
        int opcion;
        do {
            System.out.println(
                    "[1] Crear nueva ruta\n" +
                    "[2] Ver rutas programadas\n"+
                    "[3] Modificar ruta\n"+
                    "[4] Eliminar ruta\n"+
                    "[0] Volver al Menu Principal");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1 -> crearNuevaRuta(sc);
                case 2 -> imprimirRutasProgramadas();
                case 3 -> modificarRuta(sc);
                case 4 -> eliminarRuta(sc);
                case 0 -> System.out.println("Regresando al menu principal...");
            }

        }while(opcion != 0);

    }

    private void crearNuevaRuta(Scanner sc) {
        Rutas nueva = new Rutas(contadorRutas);
        listaRutas.insertaFinal(nueva);
        contadorRutas++;

        System.out.println("Ruta creada: #" + nueva.getNumeroDeRuta());
        nueva.menuRecepcion(sc);
    }

    private void imprimirRutasProgramadas() {
        if (listaRutas.vacio()) {
            System.out.println("(No hay rutas programadas)");
            return;
        }

        System.out.println("\nRutas programadas:");
        Nodo actual = listaRutas.getInicio();
        while (actual != null) {
            Rutas r = (Rutas) actual.getDato();
            System.out.println(
                    ">> Ruta #" + r.getNumeroDeRuta() +
                    "\n>>Paradas: " + r.getParadasProgramadas());
            actual = actual.getSiguiente();
            System.out.println();
        }
    }

    private void modificarRuta(Scanner sc) {
        if (listaRutas.vacio()) {
            System.out.println("No hay rutas para modificar.");
            return;
        }
        imprimirRutasProgramadas();

        System.out.print("Ingrese el numero de la ruta a modificar: ");
        int numeroRuta = sc.nextInt();
        sc.nextLine();

        Rutas ruta = buscarRuta(numeroRuta);
        if (ruta == null) {
            System.out.println("No existe la ruta #" + numeroRuta);
            return;
        }

        ruta.menuRecepcion(sc);
    }

    private void eliminarRuta(Scanner sc) {
        if (listaRutas.vacio()) {
            System.out.println("No hay rutas para eliminar.");
            return;
        }
        imprimirRutasProgramadas();

        System.out.print("Ingrese el numero de la ruta a eliminar: ");
        int numeroRuta = sc.nextInt();
        sc.nextLine();

        boolean eliminada = eliminarRutaPorNumero(numeroRuta);
        if (eliminada) {
            System.out.println("Ruta #" + numeroRuta + " eliminada correctamente.");
        } else {
            System.out.println("No existe la ruta #" + numeroRuta);
        }
    }

    private Rutas buscarRuta(int numeroRuta) {
        Nodo actual = listaRutas.getInicio();
        while (actual != null) {
            Rutas r = (Rutas) actual.getDato();
            if (r.getNumeroDeRuta() == numeroRuta) return r;
            actual = actual.getSiguiente();
        }
        return null;
    }

    private boolean eliminarRutaPorNumero(int numeroRuta) {
        if (listaRutas.vacio()) return false;

        Nodo anterior = null;
        Nodo actual = listaRutas.getInicio();

        while (actual != null) {
            Rutas ruta = (Rutas) actual.getDato();

            if (ruta.getNumeroDeRuta() == numeroRuta) {
                Nodo siguiente = actual.getSiguiente();

                if (anterior == null) {
                    listaRutas.setInicio(siguiente);
                } else {
                    anterior.setSiguiente(siguiente);
                }

                if (siguiente == null) {
                    listaRutas.setUltimo(anterior);
                }

                contadorRutas--;
                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }


    public int getRutasActivas() {
        return contadorRutas;
    }

    public Rutas getPrimeraRuta() {
        if (listaRutas.vacio()) return null;
        return (Rutas) listaRutas.getInicio().getDato();
    }

    public void imprimirRutasActivas() {
        if(listaRutas.vacio()) {
            System.out.println("(No hay rutas activas)");
            return;
        }

        Nodo actual = listaRutas.getInicio();
        while(actual != null){
            Rutas ruta = (Rutas) actual.getDato();
            System.out.println("Numero de ruta: " + ruta.getNumeroDeRuta() + " | Paradas programadas: " + ruta.getParadasProgramadas());
            System.out.println("------------------------------------");
            Parada siguiente = ruta.getPrimeraParada();
            if (siguiente == null) {
                System.out.println(">> Proximo destino: (sin paradas programadas)");
            } else {
                System.out.println(">> Proximo destino: " + siguiente.getNombreParada());
            }
            actual = actual.getSiguiente();
        }
    }
}
