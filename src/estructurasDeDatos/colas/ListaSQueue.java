package estructurasDeDatos.colas;


import estructurasDeDatos.listas.ListaSimple;

public class ListaSQueue implements Queue {

    protected ListaSimple lista;
    protected int contador;

    public ListaSQueue() {
        lista = new ListaSimple();
        contador = 0;
    }

    @Override
    public void enqueue(Object dato) {
        lista.insertaFinal(dato);
        contador++;
    }

    @Override
    public Object dequeue() {
        if(lista.vacio()){
            System.out.println("La cola esta vacia");
            return null;
        }
        contador--;
        return lista.eliminaInicio();
    }

    @Override
    public int size() {
        return contador;
    }

    @Override
    public Object front() {
        if(lista.vacio()){
            System.out.println("La cola esta vacia");
            return null;
        }
        return lista.getInicio().getDato();
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }
}
