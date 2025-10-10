package cr.ac.ucenfotec.controlador;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Vehiculo;
import cr.ac.ucenfotec.util.Estado;
import cr.ac.ucenfotec.BaseDatos;
import java.io.IOException;
import java.util.ArrayList;

public class ClienteControlador {

    public boolean registrar(String nombre, String cedula, String telefono, String correo) throws IOException {

        Cliente nuevoCliente = new Cliente(nombre, cedula, telefono, correo);
        boolean existe = getCliente(cedula)!=null;

        if (existe) {
            return false;
        }

        BaseDatos.listaClientes.add(nuevoCliente);
        return true;

    }

    public Cliente getCliente(String cedula) {
        for (Cliente cliente : BaseDatos.listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean eliminar(String cedula) throws IOException {

        for (Cliente cliente : BaseDatos.listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                BaseDatos.listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public Estado buscarVehiculo(String placa, String cedula) throws IOException {

        Cliente cliente = getCliente(cedula);

        if (cliente == null) {
            return Estado.NO_CLIENTE;
        }

        ArrayList<Vehiculo> listaVehiculos = cliente.getVehiculos();

        if (listaVehiculos.isEmpty()) {
            return Estado.NULL_VEHICULO;  // Cambio aquí
        }

        for (Vehiculo i : listaVehiculos) {
            if(i.getNumeroPlaca().equals(placa)) {
                return Estado.SI_VEHICULO;
            }
        }

        return Estado.NO_VEHICULO;

    }

}
