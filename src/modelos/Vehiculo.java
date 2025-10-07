package modelos;
import util.TipoCombustible;

public class Vehiculo {

    private String idVehiculo;
    private String marca;
    private String modelo;
    private String numeroPlaca;
    private int anioFabricacion;
    private TipoCombustible tipoCombustible;
    private String kilometraje;

    public Vehiculo(String idVehiculo, String marca, String modelo, String numeroPlaca, int anioFabricacion, TipoCombustible tipoCombustible, String kilometraje) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
        this.anioFabricacion = anioFabricacion;
        this.tipoCombustible = tipoCombustible;
        this.kilometraje = kilometraje;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
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

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public TipoCombustible setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }
}
