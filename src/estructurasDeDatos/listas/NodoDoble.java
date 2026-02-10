package estructurasDeDatos.listas;

public class NodoDoble extends Nodo{
    protected NodoDoble siguiente;
    protected NodoDoble anterior;
    public NodoDoble() {}

    public NodoDoble(Object dato, NodoDoble siguiente, NodoDoble anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoDoble(Object dato) {
        this.dato = dato;
        siguiente = anterior = null;
    }

    @Override
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
