/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recepcion;

import Colas.ListaSQueue;
import Modelo.Camion;
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
    
    private void registrarCamion(Scanner sc) {
        System.out.println("Ingresa la placa del camion: ");
        String placa = sc.nextLine();
        
        Camion camion = new Camion(placa);
        colaCamiones.enqueue(camion);
        
        System.out.println("Camion agregado a la cola exitosamente");
    }
    
    private void ingresarPatio() {
        if(colaCamiones.isEmpty()) {
            System.out.println("No hay camiones en la cola");
            return;
        }
        
        Camion camion = (Camion) colaCamiones.dequeue();
        System.out.println("El proximo camion a ingresar es: ");
        System.out.println(camion);
    }
    
    private void verProximoCamion() {
        if(colaCamiones.isEmpty()) {
            System.out.println("No hay camiones en la cola");
            return;
        }
        
        Camion camion = (Camion) colaCamiones.front();
        System.out.println("El proximo camion es: ");
        System.out.println(camion);
    }
    
    private void listarCamiones() {
        if(colaCamiones.isEmpty()) {
            System.out.println("No hay camiones en la cola");
            return;
        }
        
        System.out.println("Camiones en espera: ");
        ListaSQueue aux = new ListaSQueue();
        
        while(!colaCamiones.isEmpty()) {
            Camion c = (Camion) colaCamiones.dequeue();
            System.out.println("->" + c);
            aux.enqueue(c);
        }
        
        while(!aux.isEmpty()) {
            colaCamiones.enqueue(aux.dequeue());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ModuloARecepcion modulo = new ModuloARecepcion();
        modulo.menuRecepcion(sc);
        sc.close();
    }
}
