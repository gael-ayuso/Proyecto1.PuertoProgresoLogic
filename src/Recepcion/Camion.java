/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recepcion;

/**
 *
 * @author compu
 */
public class Camion {
    //atributos
    private String placa;
    
    //constructor
    public Camion(String placa) {
        this.placa = placa;
    }
    
    //metodos get
    public String getPlaca() {
        return placa;
    }
    
    //metodo toString

    @Override
    public String toString() {
        return "placa=" + getPlaca();
    }
}
