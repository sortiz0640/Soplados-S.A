package cr.ac.ucenfotec.modelos;

import java.util.ArrayList;

public class Mecanico extends Persona {

    private String especialidad;
    private ArrayList<Servicio> listaServicios;

    public Mecanico(String nombre, String cedula, String telefono, String correo,String especialidad) {
        super(cedula, nombre, telefono, correo);
        this.especialidad = especialidad;
        this.listaServicios = new ArrayList<>();
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mecánico: ").append(getNombre())
                .append(" | Especialidad: ").append(especialidad)
                .append("\nServicios: ");

        if (listaServicios.isEmpty()) {
            sb.append("Ninguno");
        } else {
            for (Servicio s : listaServicios) {
                sb.append("\n   - ").append(s.getNombre());
            }
        }

        return sb.toString();
    }
}
