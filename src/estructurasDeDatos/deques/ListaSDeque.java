package estructurasDeDatos.deques;


import estructurasDeDatos.listas.ListaSimple;

public class ListaSDeque implements Deque {

    ListaSimple lista;
    int contador;

    public ListaSDeque(){
        lista = new ListaSimple();
        contador = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void insertFirst(Object o) {

    }

    @Override
    public void insertLast(Object o) {

    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object first() {
        return null;
    }

    @Override
    public Object last() {
        return null;
    }
}
