/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author compu
 */
public class Nodo {
    protected Object dato;
    protected Nodo siguiente;
    
    protected Nodo() {}

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(Object dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
