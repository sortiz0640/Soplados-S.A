package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.BaseDatos;
import cr.ac.ucenfotec.controlador.OrdenServicioControlador;
import cr.ac.ucenfotec.controlador.ClienteControlador;
import cr.ac.ucenfotec.controlador.MecanicoControlador;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.modelos.OrdenServicio;
import cr.ac.ucenfotec.util.Estado;
import cr.ac.ucenfotec.util.Consola;

import java.io.IOException;

public class OrdenServicioMenu {

    private OrdenServicioControlador ordenServicioControlador = new OrdenServicioControlador();
    private ClienteControlador clienteControlador = new ClienteControlador();
    private MecanicoControlador mecanicoControlador = new MecanicoControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Crear Orden de Servicio
        [2] Buscar Orden de Servicio
        [3] Listar Ordenes de Servicio de Cliente
        [4] Eliminar Orden de Servicio
        [5] Regresar
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException{

        int opcion;
        do {
            opcion = mostrar();
            switch (opcion){
                case 1: validar(); break;
                case 2: buscar(); break;
                case 3: listar(); break;
                case 4: eliminar(); break;
                case 5: break;
                default:
                    Consola.println("Opcion invalida. Intente nuevamente");

            }
        } while (opcion != 5);

    }

    public void validar() throws IOException{

        String cedula = Consola.readln("Ingrese la cedula del cliente");
        Cliente cliente = clienteControlador.getCliente(cedula);

        String placa = Consola.readln("Ingrese la placa del vehiculo");
        Estado estado = clienteControlador.buscarVehiculo(placa, cedula);

        switch (estado){
            case Estado.NO_CLIENTE -> Consola.println("El cliente especificado no existe");
            case Estado.NO_VEHICULO ->  Consola.println("El vehiculo especificado no existe");
            case Estado.NULL_VEHICULO ->  Consola.println("El cliente no tiene vehiculos registrados");
            case Estado.SI_VEHICULO ->  crear(cliente, placa);
        }
    }

    public void crear(Cliente cliente, String placa) throws IOException{

        Consola.println(BaseDatos.listarTodosMecanico());
        int opcion = Consola.readInt("Seleccione un mecanico");

        Mecanico mecanico = mecanicoControlador.seleccionarMecanico(opcion);

        if (mecanico == null){
            Consola.println("Ingrese una opcion valida. Intente nuevamente");
            return;
        }

        OrdenServicio orden = ordenServicioControlador.crearOrdenServicio(cliente, placa, mecanico);
        Consola.println("Orden: " + orden.getNumeroOrden() + " creada correctamente");
        Consola.println(orden.toString());

    }

    public void buscar() throws IOException{

        int numeroOrden = Consola.readInt("Ingrese el numero de orden: ");
        OrdenServicio ordenEncontrada = ordenServicioControlador.getOrden(numeroOrden);

        if (ordenEncontrada != null){
            Consola.println(ordenEncontrada.toString());
            return;
        }

        Consola.println("La orden especificada no existe");

    }

    public void listar() throws IOException{

    }

    public void eliminar() throws IOException{

    }
}
