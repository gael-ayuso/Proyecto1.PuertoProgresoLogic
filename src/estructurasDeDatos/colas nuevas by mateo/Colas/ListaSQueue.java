/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import listas.ListaSimple;

/**
 *
 * @author compu
 */
public class ListaSQueue implements Queue {
    protected ListaSimple lista;
    protected int cont;
    
    public ListaSQueue() {
        lista = new ListaSimple();
        cont = 0;
    }

    @Override
    public void enqueue(Object dato) {
        lista.insertaFinal(dato);
        cont++;
    }

    @Override
    public Object dequeue() {
        if (lista.vacio()) {
            System.out.println("Cola vacia");
            return null;
        }
        else {
            cont--;
            return lista.eliminaInicio();
        }
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public Object front() {
        if (lista.vacio()) {
            System.out.println("Cola vacia");
            return null;
        }
        else {
            return lista.getInicio().getDato();
        }
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }
}
