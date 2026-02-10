package estructurasDeDatos.pilas;


import estructurasDeDatos.listas.ListaSimple;

public class ListaSPila implements Pila {

    protected ListaSimple lista;
    protected int contador;

    public ListaSPila() {
        lista = new ListaSimple();
        contador = 0;
    }

    @Override
    public void push(Object o) {
        lista.insertaInicio(o);
        contador++;
    }

    @Override
    public Object pop() {
        if(lista.vacio()){
            System.out.println("La lista de pila esta vacia");
            return null;
        }
        contador--;
        return lista.eliminaInicio();
    }

    @Override
    public Object top() {
        if(lista.vacio()){
            System.out.println("La lista de pila esta vacia");
            return null;
        }
        return lista.getInicio();
    }

    @Override
    public int size() {
        return contador;
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }
}
