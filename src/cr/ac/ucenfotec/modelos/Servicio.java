package cr.ac.ucenfotec.modelos;

public class Servicio {

    private String nombre;
    private Mecanico mecanicoAsignado;

    public Servicio(String nombre, Mecanico mecanico) {
        this.nombre = nombre;
        this.mecanicoAsignado = mecanico;
    }

    public String getNombre() {
        return nombre;
    }

}
