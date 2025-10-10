package cr.ac.ucenfotec.modelos;

public class Servicio {

    // Servicio: Esta clase especifica que tipo de mantenimiento aplica un mecanico a un vehículo
    // Clase con COMPOSICIÓN: Para que exista debe registrarse previamente un mecanico que decida agregar servicios.

    private String nombre;
    private Mecanico mecanicoAsignado;

    public Servicio(String nombre, Mecanico mecanico) {
        this.nombre = nombre;
        this.mecanicoAsignado = mecanico;
    }

    public String getNombre() {
        return nombre;
    }

    /*
        Si un Mecanico se especializa en reparación de motores. Se esperan servicios como:

        > SERVICIO: Rectificación del cabezote
        > SERVICIO: Rectificación del bloque de motor
        > SERVICIO: Cambio del empaque de cabezote

     */

}
