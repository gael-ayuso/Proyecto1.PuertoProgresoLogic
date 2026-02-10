package estructurasDeDatos.listas;

public class ListaDoble extends ListaD{
    @Override
    public void insertaInicio(Object dato) {
        if(vacio()){
            inicio = ultimo = new NodoDoble(dato);
        }else{
            NodoDoble nuevo = new NodoDoble(dato, inicio, null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if(vacio()){
            inicio = ultimo = new NodoDoble(dato);
        }else{
            NodoDoble nuevo = new NodoDoble(dato, null, ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if(vacio()){
            System.out.println("Lista Vacia");
        }else{
            if(inicio == ultimo){
                eliminado = inicio.getDato();
                inicio = ultimo = null;
            }else{
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
                inicio.setSiguiente(null);
            }
        }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if(vacio()){
            System.out.println("Lista Vacia");
        }else{
            if(inicio == ultimo){
                eliminado = ultimo.getDato();
                inicio = ultimo = null;
            }else{
                eliminado = ultimo.getDato();
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
        return eliminado;
    }

    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        lista.insertaInicio("1");
        lista.insertaInicio("2");
        lista.insertaInicio("3");
        lista.insertaInicio(">:(");
        lista.insertaInicio(2.3);
        lista.insertaInicio(false);
        lista.imprimir();
        lista.eliminaFinal();
        System.out.println("Imprimir al reves");
        lista.imprimir();
//        lista.imprimirAlReves();
    }
}
