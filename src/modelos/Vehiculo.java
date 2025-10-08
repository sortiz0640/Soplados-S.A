package modelos;

public class Vehiculo {

    private String marca;
    private String modelo;
    private String numeroPlaca;
    private int anioFabricacion;
    private String kilometraje;

    public Vehiculo(String marca, String modelo, String numeroPlaca, int anioFabricacion, String kilometraje) {

        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo[" +
                "marca:'" + marca + '\'' +
                ", modelo:'" + modelo + '\'' +
                ", numeroPlaca:'" + numeroPlaca + '\'' +
                ", anioFabricacion:" + anioFabricacion +
                ", kilometraje:'" + kilometraje + '\'' +
                ']';
    }
}
