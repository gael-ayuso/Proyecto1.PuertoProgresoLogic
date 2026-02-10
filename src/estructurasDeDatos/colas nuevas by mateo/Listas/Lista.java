/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author compu
 */
public abstract class Lista {
    
    protected Nodo inicio;
    protected Nodo ultimo;
    protected String nombre;
    
    public Lista() {
        this("lista");
    }

    public Lista(String nombre) {
        this.nombre = nombre;
        inicio = ultimo = null;
    }
    
    public void imprimir() {
        Nodo actual = inicio;
        while(actual!=null) {
            System.out.println(actual.getDato() + "-->");
            actual = actual.getSiguiente();
        }
    }
    
    public abstract void insertaInicio(Object dato);
    public abstract void insertaFinal(Object dato);
    public abstract Object eliminaInicio();
    public abstract Object eliminaFinal();
    
    public boolean vacio() {
        return getInicio() == null;
    }

    /**
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the ultimo
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
