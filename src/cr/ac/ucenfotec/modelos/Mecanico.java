package cr.ac.ucenfotec.modelos;

import java.util.ArrayList;

public class Mecanico extends Persona {

    private String especialidad;
    private ArrayList<Servicio> listaServicios;

    // Mecanico extiende Persona para el almacenamiento de datos personales. Servicios depende de la existencia de un mecanico para existir.

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

    @Override
    public String toString() {

        // Generado con el apoyo de herramientas externas para mejorar el apartado visual.

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
