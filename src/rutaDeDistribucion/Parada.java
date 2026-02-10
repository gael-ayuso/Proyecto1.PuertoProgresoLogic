package rutaDeDistribucion;

public class Parada {
    private String nombreParada;

    public Parada(String nombreParada) {
        this.nombreParada = nombreParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    @Override
    public String toString() {
        return nombreParada + "->";
    }

}
