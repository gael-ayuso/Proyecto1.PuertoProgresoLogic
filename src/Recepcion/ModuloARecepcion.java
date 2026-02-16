/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recepcion;


import estructurasDeDatos.colas.ListaSQueue;

import java.util.Scanner;

/**
 *
 * @author compu
 */
public class ModuloARecepcion {
    private ListaSQueue colaCamiones;
    
    public ModuloARecepcion() {
        colaCamiones = new ListaSQueue();
    }


    //Despliega el menu de recepcion del modulo de recepcion
    //Permite agregar camiones al final de la cola y dar ingreso a patio
    //Adicional permite ver el proximo camion a atender y listar todos los camiones en espera
    
    public void menuRecepcion(Scanner sc) {
        int opcion;
        
        do {
            System.out.println("\n SUB-MENU 1: ZONA DE RECEPCION (GATE)");
            System.out.println("[1] Registrar llegada de camion (Enqueue)");
            System.out.println("[2] Dar ingreso a patio (Dequeue)");
            System.out.println("[3] Ver proximo camion a atender (peek)");
            System.out.println("[4] Listar todos los camiones en espera");
            System.out.println("[5] Volver al Menu Principal");
            System.out.println("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                System.out.println("[1] Registrar llegada de camion (Enqueue)");
                System.out.println("[2] Dar ingreso a patio (Dequeue)");
                System.out.println("[3] Ver proximo camion a atender (peek)");
                System.out.println("[4] Listar todos los camiones en espera");
                System.out.println("[5] Volver al Menu Principal");
                System.out.println("Seleccione una opcion: ");
            }
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    registrarCamion(sc);
                    break;  
                case 2:
                    ingresarPatio();
                    break;
                case 3:
                    verProximoCamion();
                    break;
                case 4:
                    listarCamiones();
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");

                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 5);
    }


    //Agrega un camion a la cola de espera solicitando su placa
    private void registrarCamion(Scanner sc) {
        System.out.println("Ingresa la placa del camion: ");
        String placa = sc.nextLine();

        if (placa == null || placa.trim().isEmpty()) {
            System.out.println("Error: La placa no puede estar vacia");
            return;
        }

        placa = placa.trim();

        Camion camion = new Camion(placa);
        colaCamiones.enqueue(camion);

        System.out.println("Camion agregado a la cola exitosamente");
    }

    //Da ingreso al patio al proximo camion de la cola
    private void ingresarPatio() {
        if (colaCamiones.isEmpty()) {
            System.out.println("No hay camiones en la cola");
            return;
        }

        Camion camion = (Camion) colaCamiones.dequeue();
        if (camion != null) {
            System.out.println("El proximo camion a ingresar es: ");
            System.out.println(camion);
        } else {
            System.out.println("Error al obtener el camion de la cola");
        }
    }

    //Consulta proximo camion a atender
    public Camion verProximoCamion() {
        if (colaCamiones.isEmpty()) {
            System.out.println("No hay camiones en la cola");
            return null;
        }
        Camion camion = (Camion) colaCamiones.front();
        if (camion != null) {
            System.out.println("Proximo camion a atender: " + camion);
        }
        return camion;
    }

    //Muestra todos los camiones en espera
    private void listarCamiones() {
        if (colaCamiones.isEmpty()) {
            System.out.println("No hay camiones en la cola");
            return;
        }

        System.out.println("Camiones en espera: ");
        ListaSQueue aux = new ListaSQueue();

        while (!colaCamiones.isEmpty()) {
            Camion c = (Camion) colaCamiones.dequeue();
            if (c != null) {
                System.out.println("->" + c);
                aux.enqueue(c);
            }
        }

        while (!aux.isEmpty()) {
            Object camion = aux.dequeue();
            if (camion != null) {
                colaCamiones.enqueue(camion);
            }
        }
    }

    //Devuelve el numero de camiones en espera
    public int getCamionesEnEspera() {
        return colaCamiones.size();
    }

    //Devuelve true si la cola esta vacia
    public boolean isEmpty() {
        return colaCamiones.isEmpty();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ModuloARecepcion modulo = new ModuloARecepcion();
        modulo.menuRecepcion(sc);
        sc.close();
    }
}