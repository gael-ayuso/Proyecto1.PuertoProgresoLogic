package rutaDeDistribucion;

import estructurasDeDatos.SubMenu;
import estructurasDeDatos.listas.Nodo;
import estructurasDeDatos.listas.NodoDoble;

import java.util.Scanner;

public class Rutas implements SubMenu {

    private ListaParadas listaParadas = new ListaParadas();
    private int numeroDeRuta;

    public Rutas(int numeroDeRuta) {
        this.numeroDeRuta = numeroDeRuta;
    }
    @Override
    public void menuRecepcion(Scanner sc) {
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
                    listaParadas.agregarParadaAlFinal(nombreParada);
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre de la nueva parada: ");
                    String nombreParada = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la parada anterior: ");
                    String nombreParadaAnterior = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la parada siguiente: ");
                    String nombreParadaSiguiente = scanner.nextLine();
                    listaParadas.agregarParadaEntreDestinos(nombreParada, nombreParadaAnterior, nombreParadaSiguiente);
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre de la parada a eliminar: ");
                    String nombreParada = scanner.nextLine();
                    listaParadas.eliminarParada(nombreParada);
                }
                case 4 -> {
                    listaParadas.simularRecorrido(scanner);
                }
                case 5 -> {
                    System.out.println("Regresando al menu principal...");
                }
                default -> System.out.println("Opcion invalida");
            }

        }while (opcion != 5);
    }

    public int getParadasProgramadas(){
        return listaParadas.getContador();
    }

    public Parada getPrimeraParada(){
        if(listaParadas.vacio()) return null;

        if(listaParadas.getInicio() == null) return null;
        if(listaParadas.getInicio().getDato() == null) return null;
        return (Parada) listaParadas.getInicio().getDato();
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        new Rutas().menuRecepcion(scanner);
//    }


    public int getNumeroDeRuta() {
        return numeroDeRuta;
    }
}
