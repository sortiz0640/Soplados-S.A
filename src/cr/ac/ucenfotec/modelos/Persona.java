package cr.ac.ucenfotec.modelos;

public class Persona {
    private String cedula;
    private String nombre;
    private String telefono;
    private String correo;

    // Clase generalizada para el registro de personas del mundo real [ Mecanico y Cliente ]

    public Persona(String cedula, String nombre, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters generales para efectos de impresion en consola

    public String getCedula() {
        return cedula;
    }


    public String getNombre() {
        return nombre;
    }


    public String getTelefono() {
        return telefono;
    }


    public String getCorreo() {
        return correo;
    }

}
