/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PatioDeContenedores.Vista;

/**
 *
 * @author danielcauich
 */

import PatioDeContenedores.Modelo.Contenedor;
import PatioDeContenedores.Modelo.Producto;
import estructurasDeDatos.SubMenu;
import estructurasDeDatos.pilas.ListaSPila;
import estructurasDeDatos.pilas.Pila;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class PatioDContenedores implements SubMenu {

    private static final int NUM_PILAS = 3;   // columnas del patio
    private static final int ALTURA_MAX = 5;  // altura máxima X por pila

    private final Pila[] patio;

    public PatioDContenedores() {
        this.patio = crearPatio();
    }

    //Muesta el menu de recepcion del modulo de patio de contenedores
    //Permite ingresar y retirar contenedor para ruta
    //Ver tope de las pilas y inspeccionar contenedor
    @Override
    public void menuRecepcion(Scanner scanner) {
        int opcionYard;
        do {

            System.out.println("SUB-MENÚ 2: PATIO DE CONTENEDORES (YARD)\n");
            System.out.println("[1] Ingresar contenedor desde Recepción (Push a una Pila)\n" +
                    "[2] Retirar contenedor para Ruta (Pop de una Pila)\n" +
                    "[3] Ver tope de las pilas (Peek)\n" +
                    "[4] INSPECCIONAR CONTENEDOR (Gestión de contenido interno)\n" +
                    "[5] Volver al Menu Principal");
            System.out.println("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                System.out.print("Seleccione una opcion: ");
            }
            opcionYard = scanner.nextInt();
            scanner.nextLine();

            switch (opcionYard) {
                case 1 -> ingresarContenedor(scanner);
                case 2 -> retirarContenedor(scanner);
                case 3 -> imprimirEstadoPatio();
                case 4 -> inspeccionarContenedor(scanner);
                case 5 -> System.out.println("Regresando al menu principal...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcionYard != 5);
    }

    //Construye un arreglo de pilas para el patio de contenedores
    private Pila[] crearPatio() {
        Pila[] p = new Pila[NUM_PILAS];
        for (int i = 0; i < NUM_PILAS; i++) {
            p[i] = new ListaSPila();
        }
        return p;
    }


    //Solicita una pila a la que se quiere ingresar un contenedor y lo ingresa
    private void ingresarContenedor(Scanner scanner) {
        Integer idx = pedirIndicePila(scanner);
        if (idx == null) return;

        if (patio[idx].size() >= ALTURA_MAX) {
            System.out.println("No se puede: la pila ya alcanzo la altura maxima (" + ALTURA_MAX + ").");
            return;
        }

        System.out.print("ID del contenedor: ");
        String idCont = scanner.nextLine().trim();
        if (idCont.isEmpty()) {
            System.out.println("ID invalido. No puede estar vacio.");
            return;
        }

        Contenedor c = new Contenedor(idCont);
        patio[idx].push(c);

        System.out.println("OK: Contenedor '" + idCont + "' apilado en la pila " + (idx + 1) + ".");
    }

    //Retira el contenedor de la pila seleccionada para enviar a ruta
    private void retirarContenedor(Scanner scanner) {
        Integer idx = pedirIndicePila(scanner);
        if (idx == null) return;

        if (patio[idx].isEmpty()) {
            System.out.println("No se puede retirar: la pila esta vacia.");
            return;
        }

        Contenedor c = (Contenedor) patio[idx].pop();
        if (c != null) {
            System.out.println("Retirado para Ruta -> " + c.getId() + " (pila " + (idx + 1) + ").");
        }
    }

    //Muestra el tope de cada pila del patio
    private void verTopes() {
        System.out.println("\nTopes del patio:");
        for (int i = 0; i < NUM_PILAS; i++) {
            Contenedor t = (Contenedor) patio[i].top();
            if (t == null) {
                System.out.println("Pila " + (i + 1) + ": (vacia)");
            } else {
                System.out.println("Pila " + (i + 1) + ": tope = " + t.getId());
            }
        }
    }

    //Permite seleccionar una pila y contenedor por id para inspeccionar su contenido

    private void inspeccionarContenedor(Scanner scanner) {
        Integer idx = pedirIndicePila(scanner);
        if (idx == null) return;

        if (patio[idx].isEmpty()) {
            System.out.println("La pila esta vacia.");
            return;
        }

        System.out.print("ID del contenedor a revisar: ");
        String objetivoId = scanner.nextLine().trim();

        if (objetivoId.isEmpty()) {
            System.out.println("ID invalido. No puede estar vacio.");
            return;
        }

        Contenedor encontrado = buscarContenedorEnPila(idx, objetivoId);
        if (encontrado == null) return;

        menuInspeccion(scanner, encontrado);
    }


    //Solicita al usuario el numero de la pila
    private Integer pedirIndicePila(Scanner scanner) {
        System.out.println("Elige pila (1-" + NUM_PILAS + "): ");

        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Entrada invalida. Debe ingresar un numero.");
            System.out.print("Elige pila (1-" + NUM_PILAS + "): ");
        }

        int p = scanner.nextInt();
        scanner.nextLine();

        if (p < 1 || p > NUM_PILAS) {
            System.out.println("Pila invalida. Debe estar entre 1 y " + NUM_PILAS + ".");
            return null;
        }
        return p - 1;
    }

    //Busca un contenedor en una pila por su id
    private Contenedor buscarContenedorEnPila(int idx, String objetivoId) {
        Pila aux = new ListaSPila();
        Contenedor encontrado = null;

        while (!patio[idx].isEmpty()) {
            Contenedor actual = (Contenedor) patio[idx].top();
            if (actual != null && actual.getId().equals(objetivoId)) {
                encontrado = actual;
                break;
            }
            aux.push(patio[idx].pop());
        }

        if (encontrado == null) {
            System.out.println("No se encontro el contenedor '" + objetivoId + "'.");
            restaurarPila(idx, aux);
            return null;
        }

        restaurarPila(idx, aux);
        return encontrado;
    }

    //Restaura una pila a su estado anterior
    private void restaurarPila(int idx, Pila aux) {
        while (!aux.isEmpty()) {
            patio[idx].push(aux.pop());
        }
    }

    //Menu de inspeccion de contenedor
    //Permite agregar productos y calcular peso total
    private void menuInspeccion(Scanner scanner, Contenedor contenedor) {
        int opcionInspeccion;
        do {
            System.out.println("\nRevision del contenedor " + contenedor.getId());
            System.out.println(">> [1] Agregar producto (Insertar en Lista Simple)");
            System.out.println(">> [2] Calcular peso total (Recorrer Lista)");
            System.out.println(">> [0] Volver");
            System.out.print("Opcion: ");

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                System.out.print("Opcion: ");
            }
            opcionInspeccion = scanner.nextInt();
            scanner.nextLine();

            switch (opcionInspeccion) {

                case 1 -> agregarProducto(scanner, contenedor);
                case 2 -> {
                    System.out.println("Productos actuales:");
                    contenedor.listarProductos();
                    System.out.println("Peso total = " + contenedor.calcularPesoTotal());
                }
                case 0 -> System.out.println("Volviendo al menu del patio...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcionInspeccion != 0);
    }

    //Solicita datos de producto al usuario para agregarlo al contenedor

    private void agregarProducto(Scanner scanner, Contenedor contenedor) {
        System.out.print("ID producto: ");
        String pid = scanner.nextLine().trim();

        if (pid.isEmpty()) {
            System.out.println("ID invalido. No puede estar vacio.");
            return;
        }

        System.out.print("Nombre producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Nombre invalido. No puede estar vacio.");
            return;
        }

        double peso;
        System.out.print("Peso: ");
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            System.out.print("Peso invalido. Debe ingresar un numero. Peso: ");
        }
        peso = scanner.nextDouble();
        scanner.nextLine();

        if (peso <= 0) {
            System.out.println("Peso invalido. Debe ser mayor a 0.");
            return;
        }

        contenedor.agregarProducto(new Producto(pid, nombre, peso));
        System.out.println("Producto agregado.");
    }

    //Imprime el estado actual de cada pila del patio
    public void imprimirEstadoPatio() {
        for (int i = 0; i < NUM_PILAS; i++) {
            System.out.println(formatearLineaPila(i));
        }
    }

    //Da formato de impresion de la pila para el reporte general
    private String formatearLineaPila(int idx) {
        int ocupados = patio[idx].size();
        int pesoTotalKg = calcularPesoTotalPilaKg(idx);

        String nombrePila = String.valueOf((char) ('A' + idx)); // A, B, C
        String barras = construirBarras(ocupados, ALTURA_MAX);

        String base = ">> Pila " + nombrePila + ": [" + barras + "] (" + ocupados + "/" + ALTURA_MAX + ")";
        if (ocupados >= ALTURA_MAX) {
            return base + " - ¡CRÍTICO: LLENA";
        }

        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.US); // 1,200
        return base + " - Peso Total: " + nf.format(pesoTotalKg) + " kg";
    }

    //Construye una cadena de barras para representar la altura de la pila
    private String construirBarras(int ocupados, int capacidad) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ocupados; i++) sb.append("|");
        for (int i = ocupados; i < capacidad; i++) sb.append(" ");
        return sb.toString();
    }

    //Calcula el peso total de todos los productos contenidos en una pila
    private int calcularPesoTotalPilaKg(int idx) {
        // Recorremos la pila sin perder el orden (pop -> aux -> restaurar)
        Pila aux = new ListaSPila();
        double total = 0.0;

        while (!patio[idx].isEmpty()) {
            Contenedor c = (Contenedor) patio[idx].pop();
            if (c != null) total += c.calcularPesoTotal();
            aux.push(c);
        }

        while (!aux.isEmpty()) {
            patio[idx].push(aux.pop());
        }

        return (int) Math.round(total);
    }
}

