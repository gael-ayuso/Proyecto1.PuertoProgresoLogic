package rutaDeDistribucion;

import estructurasDeDatos.listas.ListaDoble;

public abstract class ListaRutas extends ListaDoble {

    public int getContador() {
        return contador;
    }

    protected int contador;

    public ListaRutas() {
        super();
        contador = 0;
    }

    public abstract void agregarParadaAlFinal(String nombreParada);
    public abstract void agregarParadaEntreDestinos(String nombreParada, String anterior, String siguiente);

    public abstract void eliminarParada(String nombreParada);

    public abstract void simularRecorrido();

}
