package cr.ac.ucenfotec.controlador;
import cr.ac.ucenfotec.modelos.Vehiculo;
import cr.ac.ucenfotec.modelos.Cliente;
public class VehiculoControlador {

    public Vehiculo registrar(Cliente cliente, String marca, String modelo, String numeroPlaca, int anioFabricacion, String kilometraje) {

        // Verifica que el cliente no tenga un vehiculo previamente registrado con la misma placa
        for (Vehiculo vehiculo : cliente.getVehiculos()) {
            if (vehiculo.getNumeroPlaca().equals(numeroPlaca)) {
                return null;
            }
        }
        // Se crea una instancia del vehiculo y se agrega a la lista de vehiculos del cliente, luego lo retorna
        Vehiculo vehiculo = new Vehiculo(marca, modelo, numeroPlaca, anioFabricacion, kilometraje);
        cliente.agregarVehiculo(vehiculo);
        return vehiculo;
    }

}
