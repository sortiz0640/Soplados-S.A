package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.modelos.Servicio;

public class ServicioControlador {

    public boolean registrar(String nombre, Mecanico mecanico){

        Servicio servicio = new Servicio(nombre, mecanico);
        return mecanico.agregarServicio(servicio);

    }

    public boolean eliminar(String nombre, Mecanico mecanico){

        return mecanico.eliminarServicio(nombre);
    }
}
