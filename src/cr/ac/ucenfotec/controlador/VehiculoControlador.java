package cr.ac.ucenfotec.controlador;
import cr.ac.ucenfotec.modelos.Vehiculo;
import cr.ac.ucenfotec.modelos.Cliente;


public class VehiculoControlador {


    public void registrar(Cliente cliente, String marca, String modelo, String numeroPlaca, int anioFabricacion, String kilometraje) {

        Vehiculo vehiculo = new Vehiculo(marca, modelo, numeroPlaca, anioFabricacion, kilometraje);
        cliente.agregarVehiculo(vehiculo);
    }

}
