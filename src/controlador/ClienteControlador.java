package controlador;
import modelos.Cliente;
import util.Consola;
import app.BaseDatos;
import java.io.IOException;

public class ClienteControlador {

    public boolean registrar(String nombre, String cedula, String telefono, String correo) throws IOException {

        Cliente nuevoCliente = new Cliente(nombre, cedula, telefono, correo);
        boolean existe = buscar(cedula)!=null;

        if (!existe) {
            return false;
        }

        BaseDatos.listaClientes.add(nuevoCliente);
        return true;

    }

    public Cliente buscar(String cedula) {
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
}
