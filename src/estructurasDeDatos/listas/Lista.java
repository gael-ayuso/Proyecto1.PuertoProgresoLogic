package estructurasDeDatos.listas;

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
        while (actual != null) {
            System.out.println(actual.getDato());
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

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {

    }
}
