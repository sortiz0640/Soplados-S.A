package cr.ac.ucenfotec;
import cr.ac.ucenfotec.modelos.*;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Mecanico;

import java.util.ArrayList;

public class BaseDatos {

    // Esta clase brinda dos ArrayList para el guardado principal de información durante el programa.
    // Algunas clases cuentan con uno interno para el guardado de datos adicionales.

    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static ArrayList<Mecanico> listaMecanicos = new ArrayList<>();

    // Devuelve un string con todos los clientes registrados en listaCliente
    public static String listarTodosCliente() {
        String  listarTodosCliente = "";
        for (Cliente cliente : listaClientes) {
            listarTodosCliente += cliente.toString() + "\n";
        }
        return listarTodosCliente;
    }

    // Devuelve un string con todos los mecánicos registrados en listaMecanicos numerados con un índice
    public static String listarTodosMecanicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== MECÁNICOS DISPONIBLES ===\n");

        for (int i = 0; i < BaseDatos.listaMecanicos.size(); i++) {
            Mecanico m = BaseDatos.listaMecanicos.get(i);
            sb.append("[").append(i + 1).append("] ");
            sb.append(m.toString()).append("\n");
        }

        // El índice de los mecánicos se utiliza para la selección de estos al momento de crear una Orden de Servicio

        return sb.toString();
    }
}
