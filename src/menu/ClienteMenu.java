package menu;

import app.BaseDatos;
import util.Consola;
import modelos.Cliente;
import controlador.ClienteControlador;

import java.io.IOException;

public class ClienteMenu {

    private ClienteControlador controlador = new ClienteControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar cliente
        [2] Consultar cliente (cedula)
        [3] Listar todos los clientes
        [4] Eliminar cliente
        [5] Regresar
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException{
        int opcion = mostrar();
        switch (opcion){
            case 1: registrar(); break;
            case 2: buscar(); break;
            case 3: listar(); break;
            case 4: eliminar(); break;
            case 5: return;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");

        }
    }

    public void registrar() throws IOException{
        String nombre = Consola.readln("Ingrese el nombre del clienteMenu");
        String cedula = Consola.readln("Ingrese el cedula del clienteMenu");
        String telefono = Consola.readln("Ingrese el telefono del clienteMenu");
        String correo = Consola.readln("Ingrese el correo del clienteMenu");

        if (!controlador.registrar(nombre, cedula, telefono, correo)) {
            Consola.println("El clienteMenu ya se encuentra registrado");
        }

        Consola.println("Cliente registrado correctamente");
    }

    public void buscar() throws IOException{
        String cedula = Consola.readln("Ingrese el cedula del clienteMenu");
        Cliente cliente = controlador.buscar(cedula);
        if (cliente == null) {
            Consola.println("El clienteMenu no existe");
        }

        Consola.println(cliente.toString());
    }

    public void listar() throws IOException{
        Consola.println("Lista de clientes: " + BaseDatos.listarTodosCliente());
    }

    public void eliminar() throws IOException{
        String cedula = Consola.readln("Ingrese la cedula del cliente");
        if (!controlador.eliminar(cedula)) {
            Consola.println("El cliente no existe");
        }
        Consola.println("Cliente eliminado correctamente");
    }
}