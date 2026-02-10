package estructurasDeDatos.listas;

public class ListaSimple extends Lista {
    @Override
    public void insertaInicio(Object dato) {
        if(vacio()){
            super.inicio = super.ultimo = new Nodo(dato);

        }else{
            super.inicio = new Nodo(dato, super.inicio);
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if(vacio()){
            super.inicio = super.ultimo = new Nodo(dato);
        }else{
            Nodo temp = new Nodo(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }

    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if(vacio()){
            System.out.println("La lista esta vacia");
        }else{
            if(inicio == ultimo){
                eliminado = inicio.getDato();
                inicio = ultimo = null;
            }else{
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
            }
        }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if(vacio()){
            System.out.println("La lista esta vacia");
        }else{
            if(inicio == ultimo){
                eliminado = ultimo.getDato();
                inicio = ultimo = null;
            }else{
                eliminado = ultimo.getDato();
                Nodo actual = inicio;
                while(actual.getSiguiente()!=ultimo){
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
                ultimo = actual;
            }
        }
        return eliminado;
    }

    public void insertaEnOrden(int dato) {
        if(vacio()){
            insertaInicio(dato);
        }else{
            if(inicio == ultimo){
                if(dato < (Integer)inicio.getDato()){
                    insertaInicio(dato);
                }else{
                    insertaFinal(dato);
                }
            }else{
                Nodo antes = null, despues = inicio;
                while(despues != null && dato > (Integer)despues.getDato()){
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if(antes == null){
                    insertaInicio(dato);
                }else{
                    if(despues == null) {
                        insertaFinal(dato);
                    }else{
                        Nodo nuevo = new Nodo(dato, despues);
                        antes.setSiguiente(nuevo);
                    }
                }
            }
        }
    }
}
