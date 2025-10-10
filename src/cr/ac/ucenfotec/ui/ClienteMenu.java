package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.BaseDatos;
import cr.ac.ucenfotec.util.Consola;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.controlador.ClienteControlador;

import java.io.IOException;

public class ClienteMenu {

    private ClienteControlador controlador = new ClienteControlador();

    private int mostrar() throws IOException {
        int opcion = -1;

        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar cliente
        [2] Consultar cliente (cedula)
        [3] Listar todos los clientes
        [4] Eliminar cliente
        [5] Gestionar vehiculos
        [6] Regresar
        ===================================
        """);

        opcion = Consola.readInt("Seleccione una opcion");
        return opcion;

    }

    public void activar() throws IOException{
        int opcion;
        do {
            opcion = mostrar();
            switch (opcion){
                case 1: registrar(); break;
                case 2: buscar(); break;
                case 3: listar(); break;
                case 4: eliminar(); break;
                case 5: registrarVehiculo(); break;
                case 6: Consola.println("..."); break;
                default: Consola.println("Opcion invalida. Intente nuevamente");
            }
        } while (opcion != 6);
    }

    public void registrar() throws IOException{
        String nombre = Consola.readln("Ingrese el nombre del cliente");
        String cedula = Consola.readln("Ingrese el cedula del cliente");
        String telefono = Consola.readln("Ingrese el telefono del cliente");
        String correo = Consola.readln("Ingrese el correo del cliente");

        if (!controlador.registrar(nombre, cedula, telefono, correo)) {
            Consola.println("El cliente ya se encuentra registrado");
            return;
        }

        Consola.println("Cliente registrado correctamente");
    }

    public void buscar() throws IOException{
        String cedula = Consola.readln("Ingrese el cedula del cliente");
        Cliente cliente = controlador.getCliente(cedula);
        if (cliente == null) {
            Consola.println("El cliente no existe");
            return;
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
            return;
        }
        Consola.println("Cliente eliminado correctamente");
    }

    public void registrarVehiculo() throws IOException{

        VehiculoMenu vehiculo =  new VehiculoMenu();

        String cedula = Consola.readln("Ingrese el cedula del cliente");
        Cliente cliente = controlador.getCliente(cedula);

        if (cliente == null) {
            Consola.println("El cliente no existe");
            return;
        }

        vehiculo.activar(cliente);
    }
}