package estructurasDeDatos.listas;

public abstract class ListaD extends Lista{
    protected NodoDoble inicio;
    protected NodoDoble ultimo;

    @Override
    public boolean vacio() {
        return inicio == null;
    }

    @Override
    public Nodo getInicio() {
        return inicio; // NodoDoble hereda de Nodo, esto funciona perfecto
    }

    @Override
    public void setInicio(Nodo inicio) {
        this.inicio = (NodoDoble) inicio;
    }

    @Override
    public Nodo getUltimo() {
        return ultimo;
    }

    @Override
    public void setUltimo(Nodo ultimo) {
        this.ultimo = (NodoDoble) ultimo;
    }

    public void imprimir() {
        super.setInicio(inicio);
        super.imprimir();
    }

    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
        while(actual != null){
            System.out.println(actual.getDato() + "->");
            actual = actual.getAnterior();
        }
    }
}
