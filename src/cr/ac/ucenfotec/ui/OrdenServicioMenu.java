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
import java.util.ArrayList;

public class OrdenServicioMenu {

    // OrdenServicioMenu depende de 3 controladores distintos para funcionar.
    // Tambien depende de los modelos, consola y BaseDatos

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
            opcion = mostrar(); // Llama el metodo mostrar() hasta que el usuario decida romper el bucle
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

        // Este metodo verifica que tanto el cliente como el vehiculo (segun placa) existan para proceder con la creacion de la orden.

        String cedula = Consola.readln("Ingrese la cedula del cliente");
        Cliente cliente = clienteControlador.getCliente(cedula);

        String placa = Consola.readln("Ingrese la placa del vehiculo");
        Estado estado = clienteControlador.buscarVehiculo(placa, cedula);

        // Uso del enum segun validaciones para mostrar al usuario que sucedio.
        switch (estado){
            case Estado.NO_CLIENTE -> Consola.println("El cliente especificado no existe");
            case Estado.NO_VEHICULO ->  Consola.println("El vehiculo especificado no existe");
            case Estado.NULL_VEHICULO ->  Consola.println("El cliente no tiene vehiculos registrados");
            case Estado.SI_VEHICULO ->  crear(cliente, placa); // Si se verifico que el cliente y vehículo existe, se llama al método crear(0 para continuar
        }
    }

    public void crear(Cliente cliente, String placa) throws IOException{

        // Debe existir algún mecanico para proceder con la orden

        Consola.println(BaseDatos.listarTodosMecanicos()); // Imprime una lista de los mecanicos registrados y sus servicios
        int opcion = Consola.readInt("Seleccione un mecanico"); // Indice del mecanico

        Mecanico mecanico = mecanicoControlador.seleccionarMecanico(opcion); // Este metodo ayuda a escoger el mecanico basado en su indice.

        if (mecanico == null){
            Consola.println("Ingrese una opcion valida. Intente nuevamente");
            return;
        }

        // Validado el mecanico, aca se le indica al controlador que proceda con la creacion de la orden de servicio

        OrdenServicio orden = ordenServicioControlador.crearOrdenServicio(cliente, placa, mecanico);
        Consola.println("Orden: " + orden.getNumeroOrden() + " creada correctamente");
        Consola.println(orden.toString());

    }

    // Imprime una orden en base a su numero
    public void buscar() throws IOException{

        int numeroOrden = Consola.readInt("Ingrese el numero de orden: ");
        OrdenServicio ordenEncontrada = ordenServicioControlador.getOrdenServicio(numeroOrden);

        if (ordenEncontrada != null){
            Consola.println(ordenEncontrada.toString());
            return;
        }

        Consola.println("La orden especificada no existe");

    }

    // Lista todas las órdenes de un cliente mientras existan
    public void listar() throws IOException{

        String cedula = Consola.readln("Ingrese la cedula del cliente");
        Cliente cliente = clienteControlador.getCliente(cedula);

        if (cliente == null) {
            Consola.println("El cliente no existe");
            return;
        }

        ArrayList<OrdenServicio> ordenes = cliente.getListaOrdenServicios();

        if (ordenes.isEmpty()) {
            Consola.println("El cliente no tiene ordenes de servicio");
            return;
        }

        Consola.println("\n=== ORDENES DE SERVICIO ===");
        for (OrdenServicio orden : ordenes) {
            Consola.println(orden.toString());
        }

    }

    // Elimina una orden en base a su numero
    public void eliminar() throws IOException{
        int numeroOrden = Consola.readInt("Ingrese el numero de orden: ");
        boolean ordenEncontrada = ordenServicioControlador.eliminarOrdenServicio(numeroOrden);

        if (!ordenEncontrada){
            Consola.println("La orden especificada no existe");
            return;
        }

        Consola.println("La orden fue eliminada correctamente");
    }
}
