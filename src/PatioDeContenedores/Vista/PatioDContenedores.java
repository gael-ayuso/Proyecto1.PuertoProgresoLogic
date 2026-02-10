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

import java.util.Scanner;


public class PatioDContenedores implements SubMenu {

    
    private static final int NUM_PILAS = 3;   // columnas del patio
    private static final int ALTURA_MAX = 5;  // altura máxima X por pila

    @Override
    public void menuRecepcion(Scanner scanner) {
        // Crear las pilas del patio
        Pila[] patio = new Pila[NUM_PILAS];
        for (int i = 0; i < NUM_PILAS; i++) {
            patio[i] = new ListaSPila();
        }

        int opcionYard = 0;

        do {
            System.out.println("Menu");
            System.out.println("1. Ingresar contenedor desde Recepcion (Push a una Pila)");
            System.out.println("2. Retirar contenedor para Ruta (Pop de una Pila)");
            System.out.println("3. Ver tope de las pilas (Peek)");
            System.out.println("4. Inspeccionar contenedor");
            System.out.println("5. Volver");
            System.out.print("Ingrese una opcion: ");
            opcionYard = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionYard) {

                case 1: { 
                    //push
                    System.out.print("Elige pila (1-" + NUM_PILAS + "): ");
                    int p = scanner.nextInt();
                    scanner.nextLine();

                    if (p < 1 || p > NUM_PILAS) {
                        System.out.println("Pila invalida.");
                        break;
                    }

                    int idx = p - 1;

                    if (patio[idx].size() >= ALTURA_MAX) {
                        System.out.println("No se puede: la pila ya alcanzo la altura maxima (" + ALTURA_MAX + ").");
                        break;
                    }

                    System.out.print("ID del contenedor: ");
                    String idCont = scanner.nextLine();

                    Contenedor c = new Contenedor(idCont);
                    patio[idx].push(c);

                    System.out.println("OK: Contenedor '" + idCont + "' apilado en la pila " + p + ".");
                    break;
                }

                case 2: { 
                    // Pop
                    System.out.print("Elige pila (1-" + NUM_PILAS + "): ");
                    int p = scanner.nextInt();
                    scanner.nextLine();

                    if (p < 1 || p > NUM_PILAS) {
                        System.out.println("Pila invalida.");
                        break;
                    }

                    int idx = p - 1;

                    Contenedor c = (Contenedor) patio[idx].pop();
                    if (c != null) {
                        System.out.println(" Retirado para Ruta -> " + c.getId() + " (pila " + p + ").");
                    }
                    break;
                }

                case 3: { 
                    // Peek
                    System.out.println("Topes del patio");
                    for (int i = 0; i < NUM_PILAS; i++) {
                        Contenedor t = (Contenedor) patio[i].top();
                        if (t == null) {
                            System.out.println("Pila " + (i + 1) + ": (vacia)");
                        } else {
                            System.out.println("Pila " + (i + 1) + ": tope = " + t.getId());
                        }
                    }
                    break;
                }

                case 4: { 
                    // Inspeccionar contenedor
                    System.out.print("Elige pila (1-" + NUM_PILAS + "): ");
                    int p = scanner.nextInt();
                    scanner.nextLine();

                    if (p < 1 || p > NUM_PILAS) {
                        System.out.println("Pila invalida.");
                        break;
                    }

                    int idx = p - 1;

                    if (patio[idx].isEmpty()) {
                        System.out.println("La pila esta vacia.");
                        break;
                    }

                    System.out.print("ID del contenedor a revisar: ");
                    String objetivoId = scanner.nextLine();

                    // Pila auxiliar
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
                        while (!aux.isEmpty()) patio[idx].push(aux.pop());
                        break;
                    }

                    int opcionInspeccion = 0;
                    do {
                        System.out.println("Revision del contenedor " + encontrado.getId() + "   ");
                        System.out.println("1. Calcular peso total");
                        System.out.println("2. Agregar producto");
                        System.out.println("0. Volver");
                        System.out.print("Opcion: ");
                        opcionInspeccion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionInspeccion) {
                            case 1:
                                System.out.println("Productos actuales:");
                                encontrado.listarProductos();
                                System.out.println("Peso total = " + encontrado.calcularPesoTotal());
                                break;

                            case 2: {
                                System.out.print("ID producto: ");
                                String pid = scanner.nextLine();
                                System.out.print("Nombre producto: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Peso: ");
                                double peso = scanner.nextDouble();
                                scanner.nextLine();

                                encontrado.agregarProducto(new Producto(pid, nombre, peso));
                                System.out.println(" producto agregado.");
                                break;
                            }

                            case 0:
                                System.out.println("Volviendo al menu del patio...");
                                break;

                            default:
                                System.out.println("Opcion invalida.");
                        }

                    } while (opcionInspeccion != 0);

                    // Restaurar pila
                    while (!aux.isEmpty()) patio[idx].push(aux.pop());

                    break;
                }

                case 5:
                    System.out.println("Saliendo....");

                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcionYard != 5);

        scanner.close();
    }
}
