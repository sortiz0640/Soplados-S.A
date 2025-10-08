package modelos;

import java.util.ArrayList;

public class Mecanico extends Persona {

    private String especialidad;
    private ArrayList<Servicio> listaServicios;

    public Mecanico(String cedula, String nombre, String telefono, String correo,String especialidad) {
        super(cedula, nombre, telefono, correo);
        this.especialidad = especialidad;

    }




}
