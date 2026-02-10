package rutaDeDistribucion;

import estructurasDeDatos.SubMenu;
import estructurasDeDatos.listas.ListaDoble;
import estructurasDeDatos.listas.Nodo;
import estructurasDeDatos.listas.NodoDoble;

import java.util.Scanner;

public class Rutas extends ListaRutas implements SubMenu {

    public Rutas(){
        super();
    }


    @Override
    public void menuRecepcion() {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "[1] Agregar nueva parada al final (Append)\n" +
                            "[2] Insertar parada entre destinos (Insert)\n" +
                            "[3] Cancelar parada (Delete node)\n" +
                            "[4] SIMULAR RECORRIDO (Navegación Anterior/Siguiente)\n" +
                            "[5] Volver al Menú Principal"
            );

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el nombre de la nueva parada: ");
                    String nombreParada = scanner.nextLine();
                    agregarParadaAlFinal(nombreParada);
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre de la nueva parada: ");
                    String nombreParada = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la parada anterior: ");
                    String nombreParadaAnterior = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la parada siguiente: ");
                    String nombreParadaSiguiente = scanner.nextLine();
                    agregarParadaEntreDestinos(nombreParada, nombreParadaAnterior, nombreParadaSiguiente);
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre de la parada a eliminar: ");
                    String nombreParada = scanner.nextLine();
                    eliminarParada(nombreParada);
                }
                case 4 -> {
                    simularRecorrido();
                }
                case 5 -> {
                    System.out.println("Regresando al menu principal...");
                }
                default -> System.out.println("Opcion invalida");
            }

        }while (opcion != 5);
    }

    @Override
    public void agregarParadaAlFinal(String nombreParada) {
        insertaFinal(nombreParada);
        contador++;
        System.out.println("Parada agregada correctamente");
    }

    @Override
    public void agregarParadaEntreDestinos(String nombreParada, String anterior, String siguiente) {
        if(super.vacio()){
            System.out.println("La lista de rutas esta vacia");
        }else {
            boolean insertado = false;
            NodoDoble actual = inicio;
            while (actual != null && actual.getSiguiente() != null) {
                Object datoActual = actual.getDato();
                Object datoSiguiente = actual.getSiguiente().getDato();

                if (anterior.equals(datoActual) && siguiente.equals(datoSiguiente)) {
                    NodoDoble next = actual.getSiguiente();
                    NodoDoble nuevo = new NodoDoble(nombreParada, next, actual);

                    actual.setSiguiente(nuevo);
                    next.setAnterior(nuevo);

                    contador++;
                    insertado = true;
                    break;
                }
                actual = actual.getSiguiente();
            }
            if (insertado) {
                System.out.println("Parada agregada correctamente");
            } else {
                System.out.println("La parada no se pudo agregar correctamente");
            }
        }
    }

    @Override
    public void eliminarParada(String nombreParada) {
        if(super.vacio()){
            System.out.println("La lista de rutas esta vacia");
        }else{
            boolean eliminado = false;

            NodoDoble actual = inicio;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
                if(actual.getDato().equals(nombreParada)){
                    if(actual == ultimo){
                        ultimo = actual.getAnterior();
                        ultimo.setSiguiente(null);

                    }else if(actual == inicio){
                        inicio = actual.getSiguiente();
                        inicio.setAnterior(null);
                    }else{
                        actual.getAnterior().setSiguiente(actual.getSiguiente());
                        actual.getSiguiente().setAnterior(actual.getAnterior());
                    }
                    contador--;
                    eliminado = true;
                }
            }

            if(eliminado){
                System.out.println("Parada eliminada correctamente");
            }else{
                System.out.println("La parada no existe en la lista");
            }
        }
    }

    @Override
    public void simularRecorrido() {
        imprimir();
        System.out.println("Cantidad de paradas: " + contador);
    }

    @Override
    public void imprimir() {
        Nodo actual = inicio;
        while(actual != null){
            System.out.print(actual.getDato() + "->");
            actual = actual.getSiguiente();
        }
    }

    public static void main(String[] args) {
        new Rutas().menuRecepcion();
    }
}
