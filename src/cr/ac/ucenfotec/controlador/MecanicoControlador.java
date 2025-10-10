package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.BaseDatos;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.util.Consola;

import java.io.IOException;

public class MecanicoControlador {

    // Metodo booleano. Guarda en listaClientes un nuevo cliente si este no existe
    public boolean registrar(String nombre, String cedula, String telefono, String correo, String especialidad) throws IOException {

        Mecanico nuevoMecanico = new Mecanico(nombre, cedula, telefono, correo, especialidad);
        boolean existe = buscar(cedula)!=null;

        if (existe) {
            return false;
        }

        BaseDatos.listaMecanicos.add(nuevoMecanico);
        return true;

    }

    // Retornar mecanico segun cedula
    public Mecanico buscar(String cedula) {
        for (Mecanico Mecanico : BaseDatos.listaMecanicos) {
            if (Mecanico.getCedula().equals(cedula)) {
                return Mecanico;
            }
        }
        return null;
    }

    // Metodo booleano: Eliminar mecanico segun cedula, indica si se logra o no eliminar.
    public boolean eliminar(String cedula) throws IOException {

        for (Mecanico Mecanico : BaseDatos.listaMecanicos) {
            if (Mecanico.getCedula().equals(cedula)) {
                BaseDatos.listaMecanicos.remove(Mecanico);
                return true;
            }
        }
        return false;
    }

    // Metodo generado con apoyo de herramientas externas
    public Mecanico seleccionarMecanico(int opcion) throws IOException {

        // Este metodo se llama luego de mostrar la lista de mecanicos, cada uno de ellos se muestra con un indice en pantalla

        if (opcion < 1 || opcion > BaseDatos.listaMecanicos.size()) {

            // Basandose en la longitud del arreglo, se procura que el usuario escoja un mecanico en pantalla
            Consola.println("Opción inválida. Intente nuevamente.");
            return null;
        }

        // Segun la opcion, crea una instancia de este mecanico y la retorna.
        Mecanico mecanicoSeleccionado = BaseDatos.listaMecanicos.get(opcion - 1);
        return mecanicoSeleccionado;
    }
}
