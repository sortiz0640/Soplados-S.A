package controlador;

import app.BaseDatos;
import modelos.Mecanico;
import modelos.Mecanico;
import util.Consola;

import java.io.IOException;

public class MecanicoControlador {

    public boolean registrar(String nombre, String cedula, String telefono, String correo, String especialidad) throws IOException {

        Mecanico nuevoMecanico = new Mecanico(nombre, cedula, telefono, correo, especialidad);
        boolean existe = buscar(cedula)!=null;

        if (!existe) {
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
}
