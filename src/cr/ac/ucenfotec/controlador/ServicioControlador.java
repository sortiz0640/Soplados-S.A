package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.modelos.Servicio;

public class ServicioControlador {

    // Registra servicio. Recibe el nombre y el mecanico asignado
    public boolean registrar(String nombre, Mecanico mecanico){

        Servicio servicio = new Servicio(nombre, mecanico);
        return mecanico.agregarServicio(servicio);

    }

    // Elimina servicio, en base al nombre. No se implementaron validaciones para verificar que el nombre sea el correcto.
    public boolean eliminar(String nombre, Mecanico mecanico){

        return mecanico.eliminarServicio(nombre);
    }
}
