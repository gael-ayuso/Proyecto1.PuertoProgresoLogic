package estructurasDeDatos.listas;

public abstract class ListaD extends Lista{
    protected NodoDoble inicio;
    protected NodoDoble ultimo;

    public boolean vacio() {
        return inicio == null;
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
