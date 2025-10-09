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

    public static String listarTodosMecanico() {
        StringBuilder sb = new StringBuilder();
        int contador = 1;

        for (Mecanico mecanico : listaMecanicos) {
            sb.append("[").append(contador).append("] ")
                    .append(mecanico.toString())
                    .append("\n");
            contador++;
        }

        return sb.toString();
    }
}
