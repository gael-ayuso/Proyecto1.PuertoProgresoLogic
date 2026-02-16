package rutaDeDistribucion;

import estructurasDeDatos.listas.ListaDoble;
import estructurasDeDatos.listas.Nodo;
import estructurasDeDatos.listas.NodoDoble;

import java.util.Scanner;

public class ListaParadas extends ListaDoble {
    protected int contador;

    public ListaParadas() {
        super();
        contador = 0;
    }


    //Agrega parada al final de la lista
    public void agregarParadaAlFinal(String nombreParada) {
        if (nombreParada == null || nombreParada.trim().isEmpty()) {
            System.out.println("El nombre de la parada no puede estar vacio");
            return;
        }
        Parada parada = new Parada(nombreParada);
        insertaFinal(parada);
        contador++;
        System.out.println("Parada agregada correctamente");
    }

    //Inserta una parada entre dos destinos consecutivos
    //Busca un nodo cuyo anterior y siguiente coincidan cons los parametros de anterior y siguiente
    //En dado caso que no se cumpla, no se inserta la nueva parada

    public void agregarParadaEntreDestinos(String nombreParada, String anterior, String siguiente) {
        if (nombreParada == null || nombreParada.trim().isEmpty()) {
            System.out.println("El nombre de la parada no puede estar vacio");
            return;
        }
        if (anterior == null || anterior.trim().isEmpty()) {
            System.out.println("El nombre de la parada anterior no puede estar vacio");
            return;
        }
        if (siguiente == null || siguiente.trim().isEmpty()) {
            System.out.println("El nombre de la parada siguiente no puede estar vacio");
            return;
        }
        if (vacio()) {
            System.out.println("La lista de rutas esta vacia");
        } else {
            boolean insertado = false;
            NodoDoble actual = inicio;
            while (actual != null && actual.getSiguiente() != null) {
                Parada datoActual = (Parada) actual.getDato();
                Parada datoSiguiente = (Parada) actual.getSiguiente().getDato();

                if (anterior.equals(datoActual.getNombreParada()) && siguiente.equals(datoSiguiente.getNombreParada())) {
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


    //Elimina una parada de la lista por su nombre
    //Busca el nodo cuyo dato sea igual al nombre de la parada a eliminar y lo elimina
    public void eliminarParada(String nombreParada) {
        if (nombreParada == null || nombreParada.trim().isEmpty()) {
            System.out.println("El nombre de la parada no puede estar vacio");
            return;
        }
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

    //Simula el recorrido de la lista de rutas
    //Permite moverse por la lista con anterior y siguiente

    public void simularRecorrido(Scanner scanner) {
        int opcion;
        if (!vacio()) {
            NodoDoble aux = inicio;
            do {
                System.out.println("\nParadas programadas: " + contador);
                System.out.println("Siguiente parada: " + aux.getDato());
                System.out.println("Anterior (1) o siguiente (2), regresar menu anterior (0):");

                while (!scanner.hasNextInt()) {
                    System.out.println("Opcion invalida. Ingrese un numero");
                    scanner.nextLine();
                    System.out.println("\nParadas programadas: " + contador);
                    System.out.println("Siguiente parada: " + aux.getDato());
                    System.out.println("Anterior (1) o siguiente (2), regresar menu anterior (0):");
                }

                opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) {
                    if (aux.getAnterior() != null) {
                        aux = aux.getAnterior();
                    } else {
                        System.out.println("\nEstas en el inicio de la lista");
                    }
                } else if (opcion == 2) {
                    if (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    } else {
                        System.out.println("\nEstas en el final de la lista");
                    }
                } else if (opcion == 0) {
                    System.out.println("Regresando...\n");
                } else {
                    System.out.println("Opcion invalida. Ingrese 0, 1 o 2");
                }


            } while (opcion != 0);
        } else {
            System.out.println("La lista de rutas esta vacia\n");
        }

    }

    //Devuelve la cantidad de paradas en la lista
    public int getContador() {
        return contador;
    }

    //Imprime la lista de rutas
    @Override
    public void imprimir() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
        }
        System.out.println();
    }


}