package rutaDeDistribucion;

import estructurasDeDatos.listas.ListaDoble;
import estructurasDeDatos.listas.Nodo;
import estructurasDeDatos.listas.NodoDoble;

import java.util.Scanner;

public class ListaParadas extends ListaDoble {

    public int getContador() {
        return contador;
    }

    protected int contador;

    public ListaParadas() {
        super();
        contador = 0;
    }

    public void agregarParadaAlFinal(String nombreParada){
        Parada parada = new Parada(nombreParada);
        insertaFinal(parada);
        contador++;
        System.out.println("Parada agregada correctamente");
    }
    public void agregarParadaEntreDestinos(String nombreParada, String anterior, String siguiente){
        if(vacio()){
            System.out.println("La lista de rutas esta vacia");
        }else {
            boolean insertado = false;
            NodoDoble actual = inicio;
            while (actual != null && actual.getSiguiente() != null) {
                Object datoActual = actual.getDato();
                Object datoSiguiente = actual.getSiguiente().getDato();

                if (anterior.equals(datoActual) && siguiente.equals(datoSiguiente)) {
                    NodoDoble next = actual.getSiguiente();
                    NodoDoble nuevo = new NodoDoble(new Parada(nombreParada), next, actual);

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

    public void eliminarParada(String nombreParada){
        if (vacio()) {
            System.out.println("La lista de rutas esta vacia");
        } else {
            boolean eliminado = false;

            NodoDoble actual = inicio;
            while (actual != null) {
                Object dato = actual.getDato();
                String nombreActual = (dato instanceof Parada) ? ((Parada) dato).getNombreParada() : String.valueOf(dato);

                if (nombreParada.equals(nombreActual)) {
                    if (actual == ultimo) {
                        ultimo = actual.getAnterior();
                        if (ultimo != null) {
                            ultimo.setSiguiente(null);
                        } else {
                            inicio = null;
                        }
                    } else if (actual == inicio) {
                        inicio = actual.getSiguiente();
                        if (inicio != null) {
                            inicio.setAnterior(null);
                        } else {
                            ultimo = null;
                        }
                    } else {
                        actual.getAnterior().setSiguiente(actual.getSiguiente());
                        actual.getSiguiente().setAnterior(actual.getAnterior());
                    }
                    contador--;
                    eliminado = true;
                    break;
                }

                actual = actual.getSiguiente();
            }

            if (eliminado) {
                System.out.println("Parada eliminada correctamente");
            } else {
                System.out.println("La parada no existe en la lista");
            }
        }
    }

    public  void simularRecorrido(Scanner scanner){
//        imprimir();
//        System.out.println("Cantidad de paradas: " + contador);
        int opcion;
        if(!vacio()){
            NodoDoble aux = inicio;
            do{
                System.out.println("\nParadas programadas: " + contador);
                System.out.println("Siguiente parada: " +  inicio.getDato());
                System.out.println("Anterior (1) o siguiente (2), regresar menu anterior (0):");
                opcion = scanner.nextInt();
                scanner.nextLine();

                if(opcion == 1){
                    if(aux.getAnterior() != null){
                        aux = aux.getAnterior();
                    }else {
                        System.out.println("\nEstas en el inicio de la lista");
                    }
                }else if(opcion == 2){
                    if(aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }else {
                        System.out.println("\nEstas en el final de la lista");
                    }
                }if(opcion == 0){
                    System.out.println("Regresando...\n");
                }


            }while(opcion != 0);
        }else {
            System.out.println("La lista de rutas esta vacia\n");
        }

    }

    @Override
    public void imprimir() {
        Nodo actual = inicio;
        while(actual != null){
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
        }
        System.out.println();
    }


}
