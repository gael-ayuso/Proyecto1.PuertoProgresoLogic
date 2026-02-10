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

    public String getId() { 
    return id; 
    }
    
    public String getNombre() {
    return nombre; 
    }
    
    public double getPeso() {
    return peso; 
    }

    public void setNombre(String nombre) { 
    this.nombre = nombre; 
    }
    
    public void setPeso(double peso) { 
    this.peso = peso;
    }

    @Override
    public String toString() {
        return "Producto{id='" + id + "', nombre='" + nombre + "', peso=" + peso + "}";
    }
}
