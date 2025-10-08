package app;
import modelos.*;
import java.util.ArrayList;

public class BaseDatos {
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static ArrayList<Mecanico> listaMecanicos = new ArrayList<>();
    public static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    public static ArrayList<OrdenServicio> listaOrdenes = new ArrayList<>();
    public static ArrayList<Servicio> listaServicios = new ArrayList<>();
    public static ArrayList<Factura> listaFacturas = new ArrayList<>();

    public static String listarTodosCliente() {
        String  listarTodosCliente = "";
        for (Cliente cliente : listaClientes) {
            listarTodosCliente += cliente.toString() + "\n";
        }
        return listarTodosCliente;
    }

    public static String listarTodosMecanico() {
        String  listarTodosCliente = "";
        for (Mecanico mecanico : listaMecanicos) {
            listarTodosCliente += mecanico.toString() + "\n";
        }
        return listarTodosCliente;
    }


}
