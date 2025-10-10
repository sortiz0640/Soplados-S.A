package cr.ac.ucenfotec;
import cr.ac.ucenfotec.modelos.*;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Mecanico;

import java.util.ArrayList;

public class BaseDatos {
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static ArrayList<Mecanico> listaMecanicos = new ArrayList<>();

    public static String listarTodosCliente() {
        String  listarTodosCliente = "";
        for (Cliente cliente : listaClientes) {
            listarTodosCliente += cliente.toString() + "\n";
        }
        return listarTodosCliente;
    }

    public static String listarTodosMecanicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== MECANICOS DISPONIBLES ===\n");

        for (int i = 0; i < BaseDatos.listaMecanicos.size(); i++) {
            Mecanico m = BaseDatos.listaMecanicos.get(i);
            sb.append("[").append(i + 1).append("] ");
            sb.append(m.toString()).append("\n");
        }

        return sb.toString();
    }
}
