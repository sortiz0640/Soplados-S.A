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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mecánico: ").append(getNombre())
                .append(" (Cédula: ").append(getCedula()).append(")")
                .append("\nEspecialidad: ").append(especialidad)
                .append("\nServicios que ofrece: ");

        if (listaServicios.isEmpty()) {
            sb.append("Ninguno");
        } else {
            for (int i = 0; i < listaServicios.size(); i++) {
                sb.append("\n   ").append(i + 1).append(". ").append(listaServicios.get(i).getNombre());
            }
        }

        return sb.toString();
    }
}
