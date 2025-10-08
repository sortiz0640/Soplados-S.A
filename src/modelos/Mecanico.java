package modelos;

import java.util.ArrayList;

public class Mecanico extends Persona {

    private String especialidad;
    private ArrayList<Servicio> listaServicios;

    public Mecanico(String cedula, String nombre, String telefono, String correo,String especialidad) {
        super(cedula, nombre, telefono, correo);
        this.especialidad = especialidad;

    }

    public boolean agregarServicio(Servicio servicio){

        for(Servicio existeServicio: listaServicios){
            if(existeServicio.getNombre().equals(servicio.getNombre())){
                return false;
            }
        }

        listaServicios.add(servicio);
        return true;

    }

    public boolean eliminarServicio(String servicio){
        for(Servicio existeServicio: listaServicios){
            if (existeServicio.getNombre().equals(servicio)) {
                listaServicios.remove(existeServicio);
                return true;
            }
        }
        return false;
    }
}
