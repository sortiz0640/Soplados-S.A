package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.BaseDatos;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.util.Consola;

import java.io.IOException;

public class MecanicoControlador {

    public boolean registrar(String nombre, String cedula, String telefono, String correo, String especialidad) throws IOException {

        Mecanico nuevoMecanico = new Mecanico(nombre, cedula, telefono, correo, especialidad);
        boolean existe = buscar(cedula)!=null;

        if (existe) {
            return false;
        }

        BaseDatos.listaMecanicos.add(nuevoMecanico);
        return true;

    }

    public Mecanico buscar(String cedula) {
        for (Mecanico Mecanico : BaseDatos.listaMecanicos) {
            if (Mecanico.getCedula().equals(cedula)) {
                return Mecanico;
            }
        }
        return null;
    }

    public boolean eliminar(String cedula) throws IOException {

        for (Mecanico Mecanico : BaseDatos.listaMecanicos) {
            if (Mecanico.getCedula().equals(cedula)) {
                BaseDatos.listaMecanicos.remove(Mecanico);
                return true;
            }
        }
        return false;
    }

    public Mecanico seleccionarMecanico(int opcion) throws IOException {

        if (opcion < 1 || opcion > BaseDatos.listaMecanicos.size()) {
            Consola.println("Opción inválida. Intente nuevamente.");
            return null;
        }

        Mecanico mecanicoSeleccionado = BaseDatos.listaMecanicos.get(opcion - 1);

        return mecanicoSeleccionado;
    }
}
