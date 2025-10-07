package controlador;
import modelos.Cliente;
import util.Consola;
import app.BaseDatos;
import java.io.IOException;

public class ClienteControlador {

    public void registrar() throws IOException {
        String nombre = Consola.readln("Ingrese el nombre del cliente");
        String cedula = Consola.readln("Ingrese el cedula del cliente");
        String telefono = Consola.readln("Ingrese el telefono del cliente");
        String correo = Consola.readln("Ingrese el correo del cliente");

        Cliente nuevoCliente = new Cliente(nombre, cedula, telefono, correo);
        BaseDatos.listaClientes.add(nuevoCliente);
        Consola.println("Cliente registrado correctamente");
    }

    public Cliente buscar() throws IOException {
        String cedula = Consola.readln("Ingrese la cedula del cliente: ");
        boolean encontrado = false;

        for (Cliente cliente : BaseDatos.listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                Consola.println("Cliente encontrado correctamente");
                encontrado = true;
                return cliente;
            }
        }

        if (!encontrado) {
            Consola.println("El cliente no existe");
        }

        return null;
    }

    public void listar() {
        if (BaseDatos.listaClientes.isEmpty()) {
            Consola.println("No hay clientes registrados");
        } else {
            Consola.println("Lista de Clientes ");
            for (Cliente cliente : BaseDatos.listaClientes) {
                Consola.println(cliente.toString());
            }
        }
    }

    public void eliminar() throws IOException {
        String cedula = Consola.readln("Ingrese la cedula del cliente: ");

        boolean encontrado = false;
        for (Cliente cliente : BaseDatos.listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                Consola.println("Cliente eliminado correctamente");
                BaseDatos.listaClientes.remove(cliente);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Consola.println("El cliente no existe");
        }
    }
}
