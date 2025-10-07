package modelos;

import java.util.ArrayList;

public class Mecanico extends Persona {

    private String especialidad;
    private double tarifaHora;
    private ArrayList<Servicio> listaServicios;

    public Mecanico(String cedula, String nombre, String telefono, String correo,String especialidad, double tarifaHora) {
        super(cedula, nombre, telefono, correo);
        this.especialidad = especialidad;
        this.tarifaHora = tarifaHora;
    }


}
