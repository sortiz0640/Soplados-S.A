package cr.ac.ucenfotec.controlador;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Vehiculo;
import cr.ac.ucenfotec.util.Estado;
import cr.ac.ucenfotec.BaseDatos;
import java.io.IOException;
import java.util.ArrayList;

public class ClienteControlador {

    // Metodo booleano. Guarda en listaClientes un nuevo cliente si este no existe
    public boolean registrar(String nombre, String cedula, String telefono, String correo) {

        Cliente nuevoCliente = new Cliente(nombre, cedula, telefono, correo);
        boolean existe = getCliente(cedula)!=null;

        if (existe) {
            return false;
        }

        BaseDatos.listaClientes.add(nuevoCliente);
        return true;

    }

    // Busca en el arreglo listaClientes si un cliente ya existe mediante su cedula
    public Cliente getCliente(String cedula) {
        for (Cliente cliente : BaseDatos.listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    // Eliminar cliente segun cedula de listaClientes
    public boolean eliminar(String cedula) throws IOException {

        for (Cliente cliente : BaseDatos.listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                BaseDatos.listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }


    // Metodo que verifica que el cliente tenga la propiedad de un vehiculo, recibe cedula y el número de placa
    public Estado buscarVehiculo(String placa, String cedula) throws IOException {

        // [1] Verifica que el cliente especificado exista
        Cliente cliente = getCliente(cedula);

        if (cliente == null) {
            return Estado.NO_CLIENTE;
        }

        // [2] Si existe, se crea una instancia de la lista de vehiculos del cliente
        ArrayList<Vehiculo> listaVehiculos = cliente.getVehiculos();

        // [3] Se verifica que la lista no este vacia
        if (listaVehiculos.isEmpty()) {
            return Estado.NULL_VEHICULO;
        }

        // [4] Verifica que la placa específica concuerde con la de algún vehículo almacenado
        for (Vehiculo i : listaVehiculos) {
            if(i.getNumeroPlaca().equals(placa)) {
                return Estado.SI_VEHICULO; // La placa especificada concuerda con la de un vehículo registrado
            }
        }

        // [5] Si existen vehiculos pero no el especificado basándonos en el número de placa
        return Estado.NO_VEHICULO;

    }

}
