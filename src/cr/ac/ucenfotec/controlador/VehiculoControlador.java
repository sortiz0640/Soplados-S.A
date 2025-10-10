package cr.ac.ucenfotec.controlador;
import cr.ac.ucenfotec.modelos.Vehiculo;
import cr.ac.ucenfotec.modelos.Cliente;


public class VehiculoControlador {


    public Vehiculo registrar(Cliente cliente, String marca, String modelo, String numeroPlaca, int anioFabricacion, String kilometraje) {

        for (Vehiculo vehiculo : cliente.getVehiculos()) {
            if (vehiculo.getNumeroPlaca().equals(numeroPlaca)) {
                return null;
            }
        }

        Vehiculo vehiculo = new Vehiculo(marca, modelo, numeroPlaca, anioFabricacion, kilometraje);
        cliente.agregarVehiculo(vehiculo);
        return vehiculo;
    }

}
