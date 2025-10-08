package controlador;

import modelos.Mecanico;
import modelos.Servicio;

public class ServicioControlador {

    public boolean registrar(String nombre, double costo, Mecanico mecanico){

        Servicio servicio = new Servicio(nombre, mecanico, costo);
        return mecanico.agregarServicio(servicio);

    }

    public boolean eliminar(String nombre, Mecanico mecanico){

        return mecanico.eliminarServicio(nombre);
    }
}
