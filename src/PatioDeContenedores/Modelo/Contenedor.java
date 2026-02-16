/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatioDeContenedores.Modelo;

import estructurasDeDatos.listas.ListaSimple;
import estructurasDeDatos.listas.Nodo;

/**
 *
 * @author danielcauich
 */



public class Contenedor {
    private String id;
    private ListaSimple productos;

    public Contenedor(String id) {
        this.id = id;
        this.productos = new ListaSimple();
    }

    //Devuelve el id del contenedor
    public String getId() {
        return id;
    }

    // Devuelve la lista de productos del contenedor
    public ListaSimple getProductos() {
        return productos;
    }

    // Opción 2 del submenú de inspeccion: Agregar producto
    public void agregarProducto(Producto p) {
        productos.insertaFinal(p);
    }

    //  submenú de inspeccion: Calcular peso total
    public double calcularPesoTotal() {
        double total = 0.0;

        Nodo actual = productos.getInicio(); // asumiendo que existe getInicio()
        while (actual != null) {
            Producto p = (Producto) actual.getDato();
            total += p.getPeso();
            actual = actual.getSiguiente();
        }

        return total;
    }

    //imprime los productos del contenedor
    public void listarProductos() {
        Nodo actual = productos.getInicio();
        if (actual == null) {
            System.out.println("(Sin productos)");
            return;
        }

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    //Reemplaza la lista de productos por otra nueva
    public void setProductos(ListaSimple productos) {
        this.productos = productos;
    }

    //ToString
    @Override
    public String toString() {
        return "Contenedor{id='" + id + "'}";
    }
}
