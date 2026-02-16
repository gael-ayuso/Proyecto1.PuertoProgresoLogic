/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatioDeContenedores.Modelo;

/**
 *
 * @author danielcauich
 */

public class Producto {
    private String id;
    private String nombre;
    private double peso;

    public Producto(String id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }

    //Devuelve el id del producto
    public String getId() { 
    return id; 
    }

    //Devuelve el nombre del producto
    public String getNombre() {
    return nombre; 
    }

    //Devuelve el peso del producto
    public double getPeso() {
    return peso; 
    }

    //Modifica el nombre del producto
    public void setNombre(String nombre) { 
    this.nombre = nombre; 
    }

    //Modifica el peso del producto
    public void setPeso(double peso) { 
    this.peso = peso;
    }

    //ToString
    @Override
    public String toString() {
        return "Producto{id='" + id + "', nombre='" + nombre + "', peso=" + peso + "}";
    }
}
